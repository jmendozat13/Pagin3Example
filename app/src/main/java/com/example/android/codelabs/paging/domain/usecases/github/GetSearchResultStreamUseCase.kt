package com.example.android.codelabs.paging.domain.usecases.github

import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.android.codelabs.paging.domain.entities.GithubRepo
import com.example.android.codelabs.paging.domain.repository.IGithubRepository
import com.example.android.codelabs.paging.domain.usecases.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import org.koin.core.inject

class GetSearchResultStreamUseCase : BaseUseCase() {
    private val githubRepository: IGithubRepository by inject()
    operator fun invoke(scope: CoroutineScope, query: String): Flow<PagingData<GithubRepo>> =
            githubRepository.getSearchResultStream(query).cachedIn(scope)
}