package com.example.tmdbapp.data.repository.popularmovie.datasource

import com.example.tmdbapp.data.model.popular.PopularMovie

interface PopularMovieCacheDataSource {

    suspend fun getPopularMoviesFromCache():List<PopularMovie>
    suspend fun savePopularMoviesFromCache(popularMovies:List<PopularMovie>)

}