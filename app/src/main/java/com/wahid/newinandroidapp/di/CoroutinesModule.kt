package com.wahid.newinandroidapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesModule {


    @IO
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @DEFAULT
    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default


    @MAIN
    @Provides
    fun provideMAINDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    fun provideIOScope(@IO ioDispatcher: CoroutineDispatcher): CoroutineScope =
        CoroutineScope(ioDispatcher)


}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IO

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MAIN

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DEFAULT

