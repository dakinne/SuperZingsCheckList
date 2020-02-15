package com.noox.checklist.core.di

import com.noox.checklist.BuildConfig
import com.noox.checklist.core.API_BASE_URL
import com.noox.checklist.core.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    single { createOkHttpClient() }
    single { createApiService(okHttpClient = get()) }
}

private fun createOkHttpClient(): OkHttpClient {

    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    return OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
}

private fun createApiService(
    okHttpClient: OkHttpClient
): ApiService = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(ApiService::class.java)
