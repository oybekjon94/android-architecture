package com.oybekdev.android_architecture.store.presentation.product_screen

import com.oybekdev.android_architecture.store.domain.model.Product

data class ProductsViewState(
    val isLoading:Boolean = false,
    val products:List<Product> = emptyList(),
    val error:String? = null
)
