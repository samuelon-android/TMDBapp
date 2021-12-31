package com.example.tmdbapp.data.repository.popularmovie.datasource

import com.example.tmdbapp.data.model.popular.PopularMovieList
import retrofit2.Response

interface PopularMovieRemoteDataSource {

    suspend fun getPopularMovies(): Response<PopularMovieList>

}