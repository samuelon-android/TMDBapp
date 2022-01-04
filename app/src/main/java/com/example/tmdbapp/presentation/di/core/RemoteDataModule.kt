package com.example.tmdbapp.presentation.di.core

import com.example.tmdbapp.data.api.TMDBService
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieRemoteDataSource
import com.example.tmdbapp.data.repository.playingmovie.datasourceImpl.PlayingMovieRemoteDataSourceImpl
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieRemoteDataSource
import com.example.tmdbapp.data.repository.popularmovie.datasourceImpl.PopularMovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String){

    @Singleton
    @Provides
    fun providePopularMovieRemoteDataSource(tmdbService: TMDBService):PopularMovieRemoteDataSource{
        return PopularMovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun providePlayingMovieRemoteDataSource(tmdbService: TMDBService): PlayingMovieRemoteDataSource {
        return PlayingMovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

}