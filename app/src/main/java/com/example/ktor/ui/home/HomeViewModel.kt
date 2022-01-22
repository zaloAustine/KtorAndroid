package com.example.ktor.ui.home

import androidx.lifecycle.ViewModel
import com.example.ktor.data.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    fun geProduct() = flow {
        emit(productRepository.getProducts())
    }

}