package com.example.tmdbapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbapp.data.model.playing.PlayingMovie

@Dao
interface PlayingMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePlayingMovies(playingMovies:List<PlayingMovie>)

    @Query("DELETE FROM playing_movies")
    suspend fun deletePlayingMovies()

    @Query("SELECT * FROM playing_movies")
    suspend fun getPlayingMovies():List<PlayingMovie>

}