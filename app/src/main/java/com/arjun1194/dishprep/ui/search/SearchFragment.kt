package com.arjun1194.dishprep.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.arjun1194.dishprep.data.hardcoded.FormData
import com.arjun1194.dishprep.databinding.FragmentSearchBinding
import com.arjun1194.dishprep.utils.toast

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cuisineSpinner.run {
            setItems(FormData.cuisineList)
            selectItemByIndex(0)
        }
        binding.dietSpinner.run {
            setItems(FormData.dietList)
        }
        binding.submitBtn.setOnClickListener {
            val query = binding.searchEditText.text.toString().trim()
            if (query.isNotEmpty()){
                val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(
                    selectedCuisine(),
                    selectedDiet(),
                    binding.searchEditText.text.toString()
                )
                findNavController().navigate(action)
            } else {
                toast("Fill in a Search Query")
            }
        }

    }

    private fun selectedCuisine(): String =
        FormData.cuisineList[binding.cuisineSpinner.selectedIndex]

    private fun selectedDiet(): String =
        if (binding.dietSpinner.selectedIndex == -1) "" else FormData.dietList[binding.dietSpinner.selectedIndex]

}