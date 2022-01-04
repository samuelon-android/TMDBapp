package com.example.tmdbapp.presentation.playingmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbapp.domain.usecase.GetPlayingMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdatePlayingMoviesUseCase


class PlayingMovieViewModelFactory (
    private val getPlayingMoviesUseCase: GetPlayingMoviesUseCase,
    private val updatePlayingMoviesUseCase: UpdatePlayingMoviesUseCase
):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlayingMoviesViewModel(getPlayingMoviesUseCase,updatePlayingMoviesUseCase) as T
    }

}