package com.sale.hive.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.google.android.material.snackbar.Snackbar
import com.sale.hive.databinding.FragmentHomeBinding
import com.sale.hive.domain.model.ProductModel
import com.sale.hive.extension.ObserveExtension.Companion.observeState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    private val productsAdapter: ProductsAdapter by lazy { ProductsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObservers()
        setUpList()
        setUpInputListeners()

        viewModel.loadProducts()
    }

    private fun setUpObservers() {
        viewModel.uiState.observeState(this, Lifecycle.State.STARTED) { state ->
            when (state) {
                is HomeViewModel.UIState.Error -> setUpErrorSnack(message = state.message)
                is HomeViewModel.UIState.ProductsLoaded ->
                    setUpListContent(products = state.products)
            }
        }
    }

    private fun setUpErrorSnack(message: Any?) {
        val finalMessage = when (message) {
            is Int -> getString(message)
            is String -> message
            else -> ""
        }
        val snackBar = Snackbar
            .make(binding.parentConstraint, finalMessage, Snackbar.LENGTH_LONG)
            .setAction("Retry") {
                viewModel.loadProducts()
            }
        snackBar.show()
    }

    private fun setUpList() {
        binding.productList.adapter = productsAdapter
    }

    private fun setUpListContent(products: List<ProductModel>) {
        productsAdapter.submitList(products)
    }

    private fun setUpInputListeners() {
        binding.searchProductInput.editText?.doAfterTextChanged { searchQuery ->
            if (searchQuery != null && searchQuery.isNotEmpty()) {
                viewModel.filterProducts(searchQuery = searchQuery.toString())
            } else {
                viewModel.filterProducts(searchQuery = "")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
