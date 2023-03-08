package com.sale.hive.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.sale.hive.MainDispatcherRule
import com.sale.hive.content.ProductContent.Content.fridgeModel
import com.sale.hive.content.ProductContent.Content.microwaveModel
import com.sale.hive.domain.repository.FakeProductRepository
import io.mockk.MockKAnnotations
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class HomeViewModelTest {

    @get:Rule
    var mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private var productRepository = FakeProductRepository()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        viewModel = HomeViewModel(
            productRepository = productRepository
        )
        viewModel.loadProducts()
    }

    @Test
    fun `Load products from data layer`() = runTest {
        viewModel.uiState.test {
            // Initial state
            assertThat(HomeViewModel.UIState.ProductsLoaded()).isEqualTo(awaitItem())
            // State after products are loaded
            assertThat(
                HomeViewModel.UIState.ProductsLoaded(mutableListOf(fridgeModel, microwaveModel))
            ).isEqualTo(awaitItem())
        }
    }

    @Test
    fun `filter products based on user search query`() = runTest {
        viewModel.filterProducts(searchQuery = "Grill")

        viewModel.uiState.test {
            // Initial state
            assertThat(HomeViewModel.UIState.ProductsLoaded()).isEqualTo(awaitItem())
            // State after products are loaded
            assertThat(
                HomeViewModel.UIState.ProductsLoaded(mutableListOf(fridgeModel, microwaveModel))
            ).isEqualTo(awaitItem())
        }
    }
}
