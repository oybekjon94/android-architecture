package com.oybekdev.android_architecture.store.presentation.product_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import com.oybekdev.android_architecture.store.presentation.product_screen.components.ProductCard
import com.oybekdev.android_architecture.store.presentation.util.components.LoadingDialog
import com.oybekdev.android_architecture.store.presentation.util.components.MyTopAppBar

@Composable
internal fun ProductsScreen() {
    val viewModel: ProductsViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductsContent(state = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsContent(
    state: ProductsViewState
) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar(text = "Products") }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(state.products) { product ->
                ProductCard(product = product)
            }
        }
    }
}