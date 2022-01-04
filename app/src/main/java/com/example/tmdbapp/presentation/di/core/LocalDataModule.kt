package com.example.tmdbapp.presentation.di.core

import com.example.tmdbapp.data.db.PlayingMovieDao
import com.example.tmdbapp.data.db.PopularMovieDao
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieLocalDataSource
import com.example.tmdbapp.data.repository.playingmovie.datasourceImpl.PlayingMovieLocalDataSourceImpl
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieLocalDataSource
import com.example.tmdbapp.data.repository.popularmovie.datasourceImpl.PopularMovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providePopularMovieLocalDataSource(popularMovieDao: PopularMovieDao):PopularMovieLocalDataSource{
        return PopularMovieLocalDataSourceImpl(popularMovieDao)
    }

    @Singleton
    @Provides
    fun providePlayingMovieLocalDataSource(playingMovieDao: PlayingMovieDao): PlayingMovieLocalDataSource {
        return PlayingMovieLocalDataSourceImpl(playingMovieDao)
    }

}