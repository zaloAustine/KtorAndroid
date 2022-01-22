package com.example.ktor.data

import com.example.ktor.data.models.RequestModel
import com.example.ktor.network.ApiService
import com.example.ktor.network.utils.safeApiCall
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepository {
    override suspend fun getProducts() = safeApiCall {
        apiService.getProducts()
    }

    override suspend fun createProducts(productRequest: RequestModel) = safeApiCall {
        apiService.createProducts(productRequest)
    }
}