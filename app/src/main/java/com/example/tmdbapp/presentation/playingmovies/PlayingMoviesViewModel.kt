package com.example.tmdbapp.presentation.playingmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbapp.domain.usecase.GetPlayingMoviesUseCase

import com.example.tmdbapp.domain.usecase.UpdatePlayingMoviesUseCase


class PlayingMoviesViewModel(
    private val getPlayingMoviesUseCase: GetPlayingMoviesUseCase,
    private val updatePlayingMoviesUseCase: UpdatePlayingMoviesUseCase):ViewModel() {

    fun get_playingMovies() = liveData{
        val playingMovieList = getPlayingMoviesUseCase.execute()
        emit(playingMovieList)
    }

    fun update_playingMovies() = liveData {
        val playingMovieList = updatePlayingMoviesUseCase.execute()
        emit(playingMovieList)
    }

}