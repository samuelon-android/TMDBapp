package com.example.tmdbapp.presentation.di.core

import com.example.tmdbapp.data.repository.playingmovie.PlayingMovieRepositoryImpl
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieCacheDataSource
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieLocalDataSource
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieRemoteDataSource
import com.example.tmdbapp.data.repository.popularmovie.PopularMovieRepositoryImpl
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieCacheDataSource
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieLocalDataSource
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieRemoteDataSource
import com.example.tmdbapp.domain.repository.PlayingMovieRepository
import com.example.tmdbapp.domain.repository.PopularMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providePopularMovieRepository(
        popularMovieRemoteDataSource: PopularMovieRemoteDataSource,
        popularMovieLocalDataSource: PopularMovieLocalDataSource,
        popularMovieCacheDataSource: PopularMovieCacheDataSource
    ):PopularMovieRepository{
        return PopularMovieRepositoryImpl(
            popularMovieRemoteDataSource,
            popularMovieLocalDataSource,
            popularMovieCacheDataSource)
    }

    @Singleton
    @Provides
    fun providePlayingMovieRepository(
        playingMovieRemoteDataSource: PlayingMovieRemoteDataSource,
        playingMovieLocalDataSource: PlayingMovieLocalDataSource,
        playingMovieCacheDataSource: PlayingMovieCacheDataSource
    ): PlayingMovieRepository {
        return PlayingMovieRepositoryImpl(
            playingMovieRemoteDataSource,
            playingMovieLocalDataSource,
            playingMovieCacheDataSource)
    }

}