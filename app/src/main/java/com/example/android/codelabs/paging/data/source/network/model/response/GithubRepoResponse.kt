package com.example.android.codelabs.paging.data.source.network.model.response

import com.example.android.codelabs.paging.data.source.common.DomainMapper
import com.example.android.codelabs.paging.domain.entities.GithubRepo
import com.google.gson.annotations.SerializedName

data class GithubRepoResponse(
        @SerializedName("id") val id: Long,
        @SerializedName("name") val name: String,
        @SerializedName("full_name") val fullName: String,
        @SerializedName("description") val description: String?,
        @SerializedName("html_url") val url: String,
        @SerializedName("stargazers_count") val stars: Int,
        @SerializedName("forks_count") val forks: Int,
        @SerializedName("language") val language: String?
) : DomainMapper<GithubRepo> {
    override fun mapToDomainEntity(): GithubRepo = GithubRepo(
            id,
            name,
            fullName,
            description,
            url,
            stars,
            forks,
            language
    )

    companion object {
        fun mapToDomainEntityList(items: List<GithubRepoResponse>): List<GithubRepo> =
                items.map { item -> item.mapToDomainEntity() }
    }

}