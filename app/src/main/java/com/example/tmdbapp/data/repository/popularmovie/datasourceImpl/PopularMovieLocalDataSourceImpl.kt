package com.example.tmdbapp.data.repository.popularmovie.datasourceImpl

import com.example.tmdbapp.data.db.PopularMovieDao
import com.example.tmdbapp.data.model.popular.PopularMovie
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PopularMovieLocalDataSourceImpl(private val popularMovieDao: PopularMovieDao):
    PopularMovieLocalDataSource {
    override suspend fun getPopularMoviesFromDB(): List<PopularMovie> {
        return popularMovieDao.getPopularMovies()
    }

    override suspend fun savePopularMoviesFromDB(popularMovies: List<PopularMovie>) {
        CoroutineScope(Dispatchers.IO).launch {
            popularMovieDao.savePopularMovies(popularMovies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            popularMovieDao.deleteAllPopularMovies()
        }
    }

}