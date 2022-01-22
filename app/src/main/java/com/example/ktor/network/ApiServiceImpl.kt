package com.example.ktor.network

import com.example.ktor.data.models.RequestModel
import com.example.ktor.data.models.ResponseModel
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(
    private val client: HttpClient
) : ApiService {
    override suspend fun getProducts(): ApiResult<List<ResponseModel>> =
        client.get { url(ApiRoutes.PRODUCTS) }

    override suspend fun createProducts(productRequest: RequestModel): ApiResult<ResponseModel> =
        client.post {
            url(ApiRoutes.PRODUCTS)
            body = productRequest
        }

}