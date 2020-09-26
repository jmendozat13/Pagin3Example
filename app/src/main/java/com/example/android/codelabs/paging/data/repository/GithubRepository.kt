package com.example.android.codelabs.paging.data.repository

import androidx.paging.PagingData
import com.example.android.codelabs.paging.data.source.IGithubDataSource
import com.example.android.codelabs.paging.domain.entities.GithubRepo
import com.example.android.codelabs.paging.domain.repository.IGithubRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.inject

class GithubRepository : IGithubRepository {

    private val githubDataSource: IGithubDataSource by inject()

    override fun getSearchResultStream(query: String): Flow<PagingData<GithubRepo>> =
            githubDataSource.getSearchResultStream(query)

}