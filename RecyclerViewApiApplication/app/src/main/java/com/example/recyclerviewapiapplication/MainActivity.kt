package com.example.recyclerviewapiapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapiapplication.databinding.ActivityMainBinding
//import com.example.recyclerviewapiapplication.utils.isInternetAvailable
import com.example.recyclerviewapiapplication.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)

//        val internetCheck = isInternetAvailable(this)
//
//        if (internetCheck) {
            viewModel.getRemoteContributors()
            viewModel.contributorsList.observe(this) {contributorList ->

                viewModel.upsertLocalContributor(contributorList)

            }

//        }
        viewModel.getLocalContributors().observe(this) {
            if (it.isNotEmpty()) {
                binding.recyclerView.adapter = RecyclerAdapter(it, this)
            } else {
//                if (!internetCheck) {
//                    Toast.makeText(this, "Connect to Internet First", Toast.LENGTH_LONG).show()
//                }
            }
        }

    }
}