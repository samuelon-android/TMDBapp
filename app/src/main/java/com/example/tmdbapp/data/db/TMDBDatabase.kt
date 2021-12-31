package com.example.tmdbapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbapp.data.db.PlayingMovieDao
import com.example.tmdbapp.data.db.PopularMovieDao
import com.example.tmdbapp.data.model.playing.PlayingMovie
import com.example.tmdbapp.data.model.popular.PopularMovie

@Database(entities = [PopularMovie::class,PlayingMovie::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun popularMovieDao() : PopularMovieDao
    abstract fun playingMovieDao() : PlayingMovieDao

}