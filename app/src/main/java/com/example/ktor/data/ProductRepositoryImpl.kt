package com.example.ktor.data

import com.example.ktor.data.models.RequestModel
import com.example.ktor.data.models.ResponseModel
import com.example.ktor.network.ApiResult
import com.example.ktor.network.ApiService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepository {
    override suspend fun getProducts(): ApiResult<List<ResponseModel>> {
        return apiService.getProducts()
    }

    override suspend fun createProducts(productRequest: RequestModel): ApiResult<ResponseModel>{
        return apiService.createProducts(productRequest)
    }
}