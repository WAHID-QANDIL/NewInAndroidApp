package com.wahid.newinandroidapp.di

import com.wahid.newinandroidapp.domain.repository.MovieRepository
import com.wahid.newinandroidapp.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideGetMoviesUseCase(
        movieRepository: MovieRepository
    ): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository =  movieRepository)
    }
}