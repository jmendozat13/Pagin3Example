package com.example.android.codelabs.paging.data.source.network.paging

import androidx.paging.PagingSource
import com.example.android.codelabs.paging.data.source.IPagingInfoDataSource
import com.example.android.codelabs.paging.data.source.database.model.PagingInfoModel
import com.example.android.codelabs.paging.data.source.network.api.GithubService
import com.example.android.codelabs.paging.data.source.network.api.IN_QUALIFIER
import com.example.android.codelabs.paging.data.source.network.model.response.GithubRepoResponse
import com.example.android.codelabs.paging.domain.entities.FilterGithub
import com.example.android.codelabs.paging.domain.entities.GithubRepo
import retrofit2.HttpException
import java.io.IOException

private const val GITHUB_STARTING_PAGE_INDEX = 1

class GithubPagingSource(
        private val service: GithubService,
        private val pagingInfoDataSource: IPagingInfoDataSource,
        private val filter: FilterGithub
) : PagingSource<Int, GithubRepo>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubRepo> {
        val position = params.key ?: GITHUB_STARTING_PAGE_INDEX
        val apiQuery = filter.query + IN_QUALIFIER
        return try {
            val response = service.searchRepos(apiQuery, position, params.loadSize)
            val repos = GithubRepoResponse.mapToDomainEntityList(response.items)
            pagingInfoDataSource.insertPagingInfo(PagingInfoModel(filter.source, response.total.toLong()))
            LoadResult.Page(
                    data = repos,
                    prevKey = if (position == GITHUB_STARTING_PAGE_INDEX) null else position - 1,
                    nextKey = if (repos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}
