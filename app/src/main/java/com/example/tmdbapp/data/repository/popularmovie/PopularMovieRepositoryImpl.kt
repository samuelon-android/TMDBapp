package com.example.tmdbapp.data.repository.popularmovie

import android.util.Log
import com.example.tmdbapp.data.model.popular.PopularMovie
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieCacheDataSource
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieLocalDataSource
import com.example.tmdbapp.data.repository.popularmovie.datasource.PopularMovieRemoteDataSource
import com.example.tmdbapp.domain.repository.PopularMovieRepository

class PopularMovieRepositoryImpl(private val popularMovieRemoteDataSource: PopularMovieRemoteDataSource,
                                 private val popularMovieLocalDataSource: PopularMovieLocalDataSource,
                                 private val popularMovieCacheDataSource: PopularMovieCacheDataSource
): PopularMovieRepository {

    override suspend fun getPopularMovies(): List<PopularMovie>? {
        return getPopularMoviesFromCache()
    }

    override suspend fun updatePopularMovies(): List<PopularMovie>? {
        val newListOfMovies = getPopularMoviesFromAPI()
        popularMovieLocalDataSource.clearAll()
        popularMovieLocalDataSource.savePopularMoviesFromDB(newListOfMovies)
        popularMovieCacheDataSource.savePopularMoviesFromCache(newListOfMovies)
        return newListOfMovies
    }


    suspend fun getPopularMoviesFromAPI():List<PopularMovie>{
        lateinit var popularMovieList:List<PopularMovie>
        try {
            val response = popularMovieRemoteDataSource.getPopularMovies()
            val body = response.body()
            if(body!=null){
                popularMovieList = body.popularMovies
            }
        }catch(exception:Exception){
            Log.i("MY_TAG",exception.message.toString())
        }
        return popularMovieList
    }


    suspend fun getPopularMoviesFromDB():List<PopularMovie>{
        lateinit var popularMovieList:List<PopularMovie>

        try {
            popularMovieList = popularMovieLocalDataSource.getPopularMoviesFromDB()
        }catch(exception:Exception){
            Log.i("MY_TAG",exception.message.toString())
        }

        if(popularMovieList.size>0){
            return popularMovieList
        }else{
            popularMovieList = getPopularMoviesFromAPI()
            popularMovieLocalDataSource.savePopularMoviesFromDB(popularMovieList)
        }

        return popularMovieList
    }


    suspend fun getPopularMoviesFromCache():List<PopularMovie>{
        lateinit var popularMovieList:List<PopularMovie>

        try {
            popularMovieList = popularMovieCacheDataSource.getPopularMoviesFromCache()
        }catch(exception:Exception){
            Log.i("MY_TAG",exception.message.toString())
        }

        if(popularMovieList.size>0){
            return popularMovieList
        }else{
            popularMovieList = getPopularMoviesFromDB()
            popularMovieCacheDataSource.savePopularMoviesFromCache(popularMovieList)
        }

        return popularMovieList
    }

}