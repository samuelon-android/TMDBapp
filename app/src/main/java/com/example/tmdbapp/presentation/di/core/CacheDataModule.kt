package com.example.tmdbapp.presentation.di.core

import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieCacheDataSource
import com.example.tmdbapp.data.repository.playingmovie.datasourceImpl.PlayingMovieCacheDataSourceImpl
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieCacheDataSource
import com.example.tmdbapp.data.repository.popularmovie.datasourceImpl.PopularMovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providePopularMovieCacheDataSource():PopularMovieCacheDataSource{
        return PopularMovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providePlayingMovieCacheDataSource(): PlayingMovieCacheDataSource {
        return PlayingMovieCacheDataSourceImpl()
    }

}