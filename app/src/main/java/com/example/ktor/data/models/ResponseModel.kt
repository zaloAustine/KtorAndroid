package com.example.ktor.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseModel(
    val id:Int,
    val title: String,
    val description: String,
    val image: String,
    val price:Double
)