package com.oybekdev.android_architecture.store.domain.repository

import arrow.core.Either
import com.oybekdev.android_architecture.store.domain.model.NetworkError
import com.oybekdev.android_architecture.store.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): Either<NetworkError,List<Product>>
}