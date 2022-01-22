package com.example.ktor.network

sealed class ApiResult<out T> {
    data class Success<out T>(val value: T) : ApiResult<T>()
    data class Failure<out T>(val throwable: Throwable) : ApiResult<T>()
}