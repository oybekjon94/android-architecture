package com.oybekdev.android_architecture.store.data.remote

import com.oybekdev.android_architecture.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    suspend fun getProducts():List<Product>
}