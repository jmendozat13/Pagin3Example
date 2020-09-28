package com.example.android.codelabs.paging.data.source

import com.example.android.codelabs.paging.data.source.database.model.PagingInfoModel
import kotlinx.coroutines.flow.Flow

interface IPagingInfoDataSource {
    suspend fun insertPagingInfo(paging: PagingInfoModel)
    fun getPagingInfo(source: String): Flow<PagingInfoModel>
}