package com.example.android.codelabs.paging.data.repository

import com.example.android.codelabs.paging.data.source.IPagingInfoDataSource
import com.example.android.codelabs.paging.data.source.database.model.PagingInfoModel
import com.example.android.codelabs.paging.domain.repository.IPagingInfoRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.inject

class PagingInfoRepository : IPagingInfoRepository {
    private val pagingDataSource: IPagingInfoDataSource by inject()
    override fun getPagingInfo(source: String): Flow<PagingInfoModel> = pagingDataSource.getPagingInfo(source)
}