package com.example.android.codelabs.paging.data.di

import com.example.android.codelabs.paging.data.source.IGithubDataSource
import com.example.android.codelabs.paging.data.source.network.GithubNetworkDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<IGithubDataSource> { GithubNetworkDataSource() }
}