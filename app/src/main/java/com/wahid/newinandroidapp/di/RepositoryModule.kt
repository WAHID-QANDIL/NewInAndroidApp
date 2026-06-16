package com.wahid.newinandroidapp.di

import com.wahid.newinandroidapp.data.remote.datasource.RemoteMovieDatasource
import com.wahid.newinandroidapp.data.remote.datasource.RemoteMovieDatasourceImpl
import com.wahid.newinandroidapp.data.repository.MovieRepositoryImpl
import com.wahid.newinandroidapp.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun provideRemoteDataSource(remoteMovieDatasourceImpl: RemoteMovieDatasourceImpl): RemoteMovieDatasource


    @Binds
    @Singleton
    abstract fun bindMovieRepository(repositoryImpl: MovieRepositoryImpl): MovieRepository

}