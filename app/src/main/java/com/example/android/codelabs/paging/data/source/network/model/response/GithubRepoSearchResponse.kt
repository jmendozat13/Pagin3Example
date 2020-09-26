package com.example.android.codelabs.paging.data.source.network.model.response

import com.google.gson.annotations.SerializedName

/**
 * Data class to hold repo responses from searchRepo API calls.
 */
data class GithubRepoSearchResponse(
        @SerializedName("total_count") val total: Int = 0,
        @SerializedName("items") val items: List<GithubRepoResponse> = emptyList(),
        val nextPage: Int? = null
)
