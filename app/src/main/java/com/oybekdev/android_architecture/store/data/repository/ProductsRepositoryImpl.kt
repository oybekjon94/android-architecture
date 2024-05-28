package com.oybekdev.android_architecture.store.data.repository

import arrow.core.Either
import com.oybekdev.android_architecture.store.data.mapper.toGeneralError
import com.oybekdev.android_architecture.store.data.remote.ProductsApi
import com.oybekdev.android_architecture.store.domain.model.NetworkError
import com.oybekdev.android_architecture.store.domain.model.Product
import com.oybekdev.android_architecture.store.domain.repository.ProductRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi
) : ProductRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft { it.toGeneralError() }
    }
}