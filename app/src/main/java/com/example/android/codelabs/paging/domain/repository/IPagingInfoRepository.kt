package com.example.android.codelabs.paging.domain.repository

import com.example.android.codelabs.paging.data.source.database.model.PagingInfoModel
import kotlinx.coroutines.flow.Flow

interface IPagingInfoRepository : BaseRepository {
    fun getPagingInfo(source: String): Flow<PagingInfoModel>
}