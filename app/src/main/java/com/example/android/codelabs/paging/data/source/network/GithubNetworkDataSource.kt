package com.example.android.codelabs.paging.data.source.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android.codelabs.paging.data.source.IGithubDataSource
import com.example.android.codelabs.paging.data.source.network.api.GithubService
import com.example.android.codelabs.paging.data.source.network.paging.GithubPagingSource
import com.example.android.codelabs.paging.domain.entities.GithubRepo
import kotlinx.coroutines.flow.Flow
import org.koin.core.KoinComponent
import org.koin.core.inject

class GithubNetworkDataSource : IGithubDataSource, KoinComponent {
    private val service: GithubService by inject()
    override fun getSearchResultStream(query: String): Flow<PagingData<GithubRepo>> {
        return Pager(
                config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
                pagingSourceFactory = { GithubPagingSource(service, query) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}