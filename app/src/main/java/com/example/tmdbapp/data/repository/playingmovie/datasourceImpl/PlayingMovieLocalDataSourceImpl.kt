package com.example.tmdbapp.data.repository.playingmovie.datasourceImpl

import com.example.tmdbapp.data.db.PlayingMovieDao
import com.example.tmdbapp.data.model.playing.PlayingMovie
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayingMovieLocalDataSourceImpl(private val playingMovieDao: PlayingMovieDao):
    PlayingMovieLocalDataSource {
    override suspend fun getPlayingMoviesFromDB(): List<PlayingMovie> {
        return playingMovieDao.getPlayingMovies()
    }

    override suspend fun savePlayingMoviesFromDB(playingMovies: List<PlayingMovie>) {
        CoroutineScope(Dispatchers.IO).launch {
            playingMovieDao.savePlayingMovies(playingMovies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            playingMovieDao.deletePlayingMovies()
        }
    }

}