package com.example.android.codelabs.paging.domain.repository

import androidx.paging.PagingData
import com.example.android.codelabs.paging.domain.entities.GithubRepo
import kotlinx.coroutines.flow.Flow

interface IGithubRepository : BaseRepository {
    fun getSearchResultStream(query: String): Flow<PagingData<GithubRepo>>
}