package com.example.ktor.data

import com.example.ktor.data.models.RequestModel
import com.example.ktor.data.models.ResponseModel
import com.example.ktor.network.ApiResult

interface  ProductRepository{

    suspend fun getProducts(): ApiResult<List<ResponseModel>>

    suspend fun createProducts(productRequest: RequestModel): ApiResult<ResponseModel>
}
