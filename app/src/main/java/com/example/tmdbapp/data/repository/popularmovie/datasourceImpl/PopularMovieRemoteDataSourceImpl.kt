package com.example.tmdbapp.data.repository.popularmovie.datasourceImpl

import com.example.tmdbapp.data.api.TMDBService
import com.example.tmdbapp.data.model.popular.PopularMovieList
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieRemoteDataSource
import retrofit2.Response

class PopularMovieRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                       private val apiKey:String): PopularMovieRemoteDataSource {

    override suspend fun getPopularMovies(): Response<PopularMovieList> = tmdbService.getPopularMovies(apiKey)
}