package com.example.ktor.di

import com.example.ktor.data.ProductRepository
import com.example.ktor.data.ProductRepositoryImpl
import com.example.ktor.network.ApiService
import com.example.ktor.network.ApiServiceImpl
import com.example.ktor.network.ktorHttpClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkModule {

    companion object {
        @Provides
        fun provideKtorClient(): HttpClient {
            return ktorHttpClient
        }

        @Provides
        fun provideApiService(client: HttpClient): ApiService {
            return ApiServiceImpl(client)
        }
    }

    @Binds
    abstract fun bindProductRepository(repository: ProductRepositoryImpl): ProductRepository

}