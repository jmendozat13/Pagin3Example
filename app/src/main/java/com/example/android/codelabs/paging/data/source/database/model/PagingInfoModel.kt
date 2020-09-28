package com.example.android.codelabs.paging.data.source.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PagingInfoModel(
        @PrimaryKey
        var source: String,
        var totalCount: Long
)