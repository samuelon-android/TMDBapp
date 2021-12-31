package com.example.tmdbapp.data.repository.playingmovie

import android.util.Log
import com.example.tmdbapp.data.model.playing.PlayingMovie
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieCacheDataSource
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieLocalDataSource
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieRemoteDataSource
import com.example.tmdbapp.domain.repository.PlayingMovieRepository


class PlayingMovieRepositoryImpl(private val playingMovieRemoteDataSource: PlayingMovieRemoteDataSource,
                                 private val playingMovieLocalDataSource: PlayingMovieLocalDataSource,
                                 private val playingMovieCacheDataSource: PlayingMovieCacheDataSource
): PlayingMovieRepository {

    override suspend fun getPlayingMovies(): List<PlayingMovie>? {
        return getPlayingMoviesFromCache()
    }

    override suspend fun updatePlayingMovies(): List<PlayingMovie>? {
        val newListOfMovies = getPlayingMoviesFromAPI()
        playingMovieLocalDataSource.clearAll()
        playingMovieLocalDataSource.savePlayingMoviesFromDB(newListOfMovies)
        playingMovieCacheDataSource.savePlayingMoviesFromCache(newListOfMovies)
        return newListOfMovies
    }


    suspend fun getPlayingMoviesFromAPI():List<PlayingMovie>{
        lateinit var playingMovieList:List<PlayingMovie>
        try {
            val response = playingMovieRemoteDataSource.getPlayingMovies()
            val body = response.body()
            if(body!=null){
                playingMovieList = body.playingMovies
            }
        }catch(exception:Exception){
            Log.i("MY_TAG",exception.message.toString())
        }
        return playingMovieList
    }


    suspend fun getPlayingMoviesFromDB():List<PlayingMovie>{
        lateinit var playingMovieList:List<PlayingMovie>

        try {
            playingMovieList = playingMovieLocalDataSource.getPlayingMoviesFromDB()
        }catch(exception:Exception){
            Log.i("MY_TAG",exception.message.toString())
        }

        if(playingMovieList.size>0){
            return playingMovieList
        }else{
            playingMovieList = getPlayingMoviesFromAPI()
            playingMovieLocalDataSource.savePlayingMoviesFromDB(playingMovieList)
        }

        return playingMovieList
    }


    suspend fun getPlayingMoviesFromCache():List<PlayingMovie>{
        lateinit var playingMovieList:List<PlayingMovie>

        try {
            playingMovieList = playingMovieCacheDataSource.getPlayingMoviesFromCache()
        }catch(exception:Exception){
            Log.i("MY_TAG",exception.message.toString())
        }

        if(playingMovieList.size>0){
            return playingMovieList
        }else{
            playingMovieList = getPlayingMoviesFromDB()
            playingMovieCacheDataSource.savePlayingMoviesFromCache(playingMovieList)
        }

        return playingMovieList
    }

}