package com.example.android.codelabs.paging.ui

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchRepositoriesViewModel() }
}