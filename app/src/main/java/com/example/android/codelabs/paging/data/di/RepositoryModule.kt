package com.example.android.codelabs.paging.data.di

import com.example.android.codelabs.paging.data.repository.GithubRepository
import com.example.android.codelabs.paging.domain.repository.IGithubRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IGithubRepository> { GithubRepository() }
}