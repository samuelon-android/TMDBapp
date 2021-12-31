package com.example.tmdbapp.data.repository.playingmovie.datasourceImpl

import com.example.tmdbapp.data.model.playing.PlayingMovie
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieCacheDataSource

class PlayingMovieCacheDataSourceImpl: PlayingMovieCacheDataSource {

    private var playingMovieList = ArrayList<PlayingMovie>()

    override suspend fun getPlayingMoviesFromCache(): List<PlayingMovie> {
        return playingMovieList
    }

    override suspend fun savePlayingMoviesFromCache(playingMovies: List<PlayingMovie>) {
        playingMovieList.clear()
        playingMovieList = ArrayList(playingMovies)
    }
}