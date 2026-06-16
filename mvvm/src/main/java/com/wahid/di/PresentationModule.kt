package com.wahid.di

import com.wahid.mvvm.domain.MovieRepository
import com.wahid.mvvm.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {


    @Provides
    @Singleton
    fun provideGetMoviesUseCase(
        movieRepository: MovieRepository
    ): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository =  movieRepository)
    }
}