package com.arjun1194.dishprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.arjun1194.dishprep.data.model.DataResponse
import com.arjun1194.dishprep.databinding.ActivityMainBinding
import com.arjun1194.dishprep.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: SearchViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this,R.layout.activity_main)
        subscribe()
    }

    fun subscribe(){
        viewModel.getSearchResults("noodles")
        viewModel.searchResponse.observe(this){
            when(it){
                is DataResponse.Error -> {
                    Toast.makeText(this,it.error.message.toString(),Toast.LENGTH_SHORT).show()
                }
                is DataResponse.Success -> {
                    binding.data = it.data
                }
            }
        }
    }
}