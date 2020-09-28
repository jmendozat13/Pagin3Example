package com.example.android.codelabs.paging.data.source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.codelabs.paging.data.source.database.dao.PagingInfoDao
import com.example.android.codelabs.paging.data.source.database.model.PagingInfoModel

@Database(entities = [PagingInfoModel::class], version = 1, exportSchema = false)
abstract class PagingDataBase : RoomDatabase() {
    abstract val pagingInfo: PagingInfoDao
}