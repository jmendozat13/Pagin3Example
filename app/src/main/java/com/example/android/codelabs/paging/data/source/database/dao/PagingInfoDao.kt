package com.example.android.codelabs.paging.data.source.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.codelabs.paging.data.source.database.model.PagingInfoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface PagingInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPagingInfo(paging: PagingInfoModel)

    @Query("SELECT * FROM paginginfomodel WHERE source=:source")
    fun getPagingInfo(source: String): Flow<PagingInfoModel>
}