package com.oybekdev.android_architecture.di

import com.oybekdev.android_architecture.store.data.repository.ProductsRepositoryImpl
import com.oybekdev.android_architecture.store.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideProductsRepository(impl: ProductsRepositoryImpl): ProductRepository

}