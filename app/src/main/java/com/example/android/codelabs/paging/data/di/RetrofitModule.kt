package com.example.android.codelabs.paging.data.di

import com.example.android.codelabs.paging.data.source.network.api.GithubService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.github.com/"

val retrofitModule = module {
    single { providerHttpLoggingInterceptor() }
    single { providerGsonConverterFactory() }
    single { providerOkHttpClient(get()) }
    single { providerRetrofit(BASE_URL, get(), get()) }
    single { providerGithubServices(get()) }
}


fun providerHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
}

fun providerGsonConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create()
}

fun providerOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
}

fun providerRetrofit(
        baseUrl: String,
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
}

fun providerGithubServices(retrofit: Retrofit): GithubService {
    return retrofit.create(GithubService::class.java)
}