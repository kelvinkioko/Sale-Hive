package com.sale.hive.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sale.hive.domain.model.ProductModel
import com.sale.hive.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.ProductsLoaded())
    val uiState = _uiState.asStateFlow()

    private val products = mutableListOf<ProductModel>()

    fun loadProducts() {
        viewModelScope.launch {
            val productsResponse = withContext(Dispatchers.IO) {
                productRepository.loadProducts()
            }

            if (productsResponse.responseData != null) {
                products.clear()
                products.addAll(productsResponse.responseData)
                _uiState.value = UIState.ProductsLoaded(
                    products = products
                )
            } else {
                _uiState.value = UIState.Error(
                    message = productsResponse.errorMessage ?: ""
                )
            }
        }
    }

    fun filterProducts(searchQuery: String) {
        val filteredProducts = products.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        }

        _uiState.value = UIState.ProductsLoaded(
            products = filteredProducts
        )
    }

    sealed class UIState {
        data class ProductsLoaded(val products: List<ProductModel> = emptyList()) : UIState()
        data class Error(val message: Any? = null) : UIState()
    }
}
