package com.example.android.codelabs.paging.domain.usecases.di

import com.example.android.codelabs.paging.domain.usecases.GetPagingInfoUseCase
import com.example.android.codelabs.paging.domain.usecases.github.GetSearchResultStreamUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetSearchResultStreamUseCase() }
    single { GetPagingInfoUseCase() }
}