package com.example.android.codelabs.paging.data.source

import androidx.paging.PagingData
import com.example.android.codelabs.paging.domain.entities.FilterGithub
import com.example.android.codelabs.paging.domain.entities.GithubRepo
import kotlinx.coroutines.flow.Flow

interface IGithubDataSource {
    fun getSearchResultStream(filter: FilterGithub): Flow<PagingData<GithubRepo>>
}