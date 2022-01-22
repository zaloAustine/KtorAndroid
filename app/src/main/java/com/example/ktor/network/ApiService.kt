package com.example.ktor.network

import com.example.ktor.data.models.RequestModel
import com.example.ktor.data.models.ResponseModel

interface ApiService {

    suspend fun getProducts(): List<ResponseModel>

    suspend fun createProducts(productRequest: RequestModel):ResponseModel
}