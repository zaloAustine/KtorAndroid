package com.example.ktor.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktor.databinding.ActivityMainBinding
import com.example.ktor.network.ApiResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productAdapter = ProductAdapter()

        binding.productRecylerview.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        getProducts()

        loading()
    }

    private fun getProducts() {
        lifecycleScope.launch {
            viewModel.geProduct().collect {
                when (it) {
                    is ApiResult.Success -> {
                        productAdapter.submitList(it.value)
                    }

                    is ApiResult.Loading -> {
                        binding.progress.isVisible = false
                    }

                    is ApiResult.Failure -> {
                        Toast.makeText(
                            this@MainActivity,
                            it.throwable.localizedMessage,
                            Toast.LENGTH_SHORT
                        ).show()

                        binding.progress.isVisible = false

                    }
                }
            }
        }
    }

    private fun loading() {
        viewModel.isLoading.observe(this, {
            binding.progress.isVisible = it
        })
    }
}