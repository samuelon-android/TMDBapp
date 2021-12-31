package com.example.tmdbapp.data.repository.popularmovie.datasourceImpl

import com.example.tmdbapp.data.model.popular.PopularMovie
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieCacheDataSource

class PopularMovieCacheDataSourceImpl: PopularMovieCacheDataSource {

    private var popularMovieList = ArrayList<PopularMovie>()

    override suspend fun getPopularMoviesFromCache(): List<PopularMovie> {
        return popularMovieList
    }

    override suspend fun savePopularMoviesFromCache(popularMovies: List<PopularMovie>) {
        popularMovieList.clear()
        popularMovieList = ArrayList(popularMovies)
    }
}