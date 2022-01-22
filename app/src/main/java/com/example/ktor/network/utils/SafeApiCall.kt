package com.example.ktor.network.utils

import com.example.ktor.network.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> safeApiCall(
    apiCall: suspend () -> T
): ApiResult<T> = withContext(Dispatchers.IO) {
    try {
        ApiResult.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
        ApiResult.Failure(throwable)
    }
}

