package com.example.ktor.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.ktor.R
import com.example.ktor.network.ApiResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getProducts()
    }

    private fun getProducts() {
        lifecycleScope.launch {
            viewModel.geProduct().collect {
                when (it) {

                    is ApiResult.Success -> {
                        Toast.makeText(
                            this@MainActivity,
                            it.data!![0].description,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    is ApiResult.Error -> {
                        Toast.makeText(this@MainActivity, it.exception, Toast.LENGTH_SHORT).show()

                    }

                    is ApiResult.Loading -> {
                        Toast.makeText(this@MainActivity, "loading", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }
    }
}