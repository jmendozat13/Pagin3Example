package com.example.android.codelabs.paging.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.android.codelabs.paging.domain.entities.FilterGithub
import com.example.android.codelabs.paging.domain.entities.GithubRepo
import com.example.android.codelabs.paging.domain.usecases.GetPagingInfoUseCase
import com.example.android.codelabs.paging.domain.usecases.github.GetSearchResultStreamUseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * ViewModel for the [SearchRepositoriesActivity] screen.
 * The ViewModel works with the [GithubRepository] to get the data.
 */


private const val GITHUB_PAGING_SOURCE = "GITHUB"

class SearchRepositoriesViewModel : ViewModel(), KoinComponent {

    private val getSearchResultStreamUseCase: GetSearchResultStreamUseCase by inject()
    private val getPagingInfoUseCase: GetPagingInfoUseCase by inject()

    private var currentQueryValue: String? = null

    private var currentSearchResult: Flow<PagingData<GithubRepo>>? = null
    
    fun getPageHeaderInfo() = getPagingInfoUseCase(GITHUB_PAGING_SOURCE).asLiveData()

    fun searchRepo(queryString: String): Flow<PagingData<GithubRepo>> {
        val lastResult = currentSearchResult
        if (queryString == currentQueryValue && lastResult != null) {
            return lastResult
        }
        currentQueryValue = queryString
        val newResult: Flow<PagingData<GithubRepo>> = getSearchResultStreamUseCase(viewModelScope, FilterGithub(GITHUB_PAGING_SOURCE, queryString))
        currentSearchResult = newResult
        return newResult
    }
}
