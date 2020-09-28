package com.example.android.codelabs.paging.data.di

import androidx.room.Room
import com.example.android.codelabs.paging.data.source.IPagingInfoDataSource
import com.example.android.codelabs.paging.data.source.database.PagingDataBase
import com.example.android.codelabs.paging.data.source.database.PagingInfoDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
                androidContext(),
                PagingDataBase::class.java,
                "${androidContext().packageName}.db"
        )
                .fallbackToDestructiveMigration()
                .build()
    }
    single { get<PagingDataBase>().pagingInfo }
    single<IPagingInfoDataSource> { PagingInfoDataSource() }
}