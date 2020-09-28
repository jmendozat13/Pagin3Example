package com.example.android.codelabs.paging.data.source.database

import com.example.android.codelabs.paging.data.source.IPagingInfoDataSource
import com.example.android.codelabs.paging.data.source.database.dao.PagingInfoDao
import com.example.android.codelabs.paging.data.source.database.model.PagingInfoModel
import kotlinx.coroutines.flow.Flow
import org.koin.core.KoinComponent
import org.koin.core.inject

class PagingInfoDataSource : IPagingInfoDataSource, KoinComponent {
    private val dao: PagingInfoDao by inject()
    override suspend fun insertPagingInfo(paging: PagingInfoModel) = dao.insertPagingInfo(paging)
    override fun getPagingInfo(source: String): Flow<PagingInfoModel> = dao.getPagingInfo(source)
}