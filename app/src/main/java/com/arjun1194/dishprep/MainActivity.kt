package com.arjun1194.dishprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.arjun1194.dishprep.data.model.DataResponse
import com.arjun1194.dishprep.databinding.ActivityMainBinding
import com.arjun1194.dishprep.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this,R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment_container)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.d(TAG, "Destination Changed: $destination with arguments $arguments")
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}