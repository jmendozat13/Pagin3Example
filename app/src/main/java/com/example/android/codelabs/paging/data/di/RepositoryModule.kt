package com.example.android.codelabs.paging.data.di

import com.example.android.codelabs.paging.data.repository.GithubRepository
import com.example.android.codelabs.paging.data.repository.PagingInfoRepository
import com.example.android.codelabs.paging.domain.repository.IGithubRepository
import com.example.android.codelabs.paging.domain.repository.IPagingInfoRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IGithubRepository> { GithubRepository() }
    single<IPagingInfoRepository> { PagingInfoRepository() }
}