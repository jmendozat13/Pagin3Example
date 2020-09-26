package com.example.android.codelabs.paging

import android.app.Application
import com.example.android.codelabs.paging.data.di.dataSourceModule
import com.example.android.codelabs.paging.data.di.repositoryModule
import com.example.android.codelabs.paging.data.di.retrofitModule
import com.example.android.codelabs.paging.domain.usecases.di.useCaseModule
import com.example.android.codelabs.paging.ui.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@BaseApplication)
            modules(
                    listOf(
                            retrofitModule,
                            dataSourceModule,
                            repositoryModule,
                            useCaseModule,
                            viewModelModule
                    )
            )
        }
    }
}