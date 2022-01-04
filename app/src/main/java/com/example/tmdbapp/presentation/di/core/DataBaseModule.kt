package com.example.tmdbapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbapp.data.db.PlayingMovieDao
import com.example.tmdbapp.data.db.PopularMovieDao
import com.example.tmdbapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providePopularMovieDataBase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun providePopularMovieDao(tmdbDatabase: TMDBDatabase):PopularMovieDao{
        return tmdbDatabase.popularMovieDao()
    }

    @Singleton
    @Provides
    fun providePlayingMovieDao(tmdbDatabase: TMDBDatabase): PlayingMovieDao {
        return tmdbDatabase.playingMovieDao()
    }


}