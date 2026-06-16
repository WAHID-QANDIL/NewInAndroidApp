package com.wahid.newinandroidapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.wahid.newinandroidapp.data.remote.service.MovieService
import com.wahid.newinandroidapp.utils.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().addInterceptor(NetworkInterceptor()).build()

    @Singleton
    @Provides
    fun provideMovieService(
        json: Json,
        okHttpClient: OkHttpClient
    ): MovieService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()
            .create(MovieService::class.java)
    }


}