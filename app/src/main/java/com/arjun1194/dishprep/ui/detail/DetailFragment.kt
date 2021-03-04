package com.arjun1194.dishprep.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.arjun1194.dishprep.data.model.DataResponse
import com.arjun1194.dishprep.databinding.FragmentDetailBinding
import com.arjun1194.dishprep.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment: Fragment() {

    lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    val args: DetailFragmentArgs by navArgs()
    private val recipeAdapter = RecipeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recipeList.adapter = recipeAdapter
        subscribe()
    }

    fun subscribe(){
        //TODO: Add other Query params
        viewModel.getSearchResults(args.searchQuery,args.cuisine,args.diet)
        viewModel.searchResponse.observe(viewLifecycleOwner){
           when(it){
               is DataResponse.Error -> toast(it.error.message.toString())
               is DataResponse.Success -> {
                   if(it.data.results.isNotEmpty()){
                       binding.noDataImage.visibility = View.GONE
                       binding.recipeList.visibility = View.VISIBLE
                       recipeAdapter.submitList(it.data.results)
                   }
                   else {
                       binding.noDataImage.visibility = View.VISIBLE
                       binding.recipeList.visibility = View.GONE
                   }
               }
           }
        }
    }
}