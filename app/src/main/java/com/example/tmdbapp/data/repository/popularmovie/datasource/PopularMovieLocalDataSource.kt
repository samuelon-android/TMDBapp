package com.example.tmdbapp.data.repository.popularmovie.datasource

import com.example.tmdbapp.data.model.popular.PopularMovie

interface PopularMovieLocalDataSource {

    suspend fun getPopularMoviesFromDB():List<PopularMovie>
    suspend fun savePopularMoviesFromDB(popularMovies:List<PopularMovie>)
    suspend fun clearAll()
}