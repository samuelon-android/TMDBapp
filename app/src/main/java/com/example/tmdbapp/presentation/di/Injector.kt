package com.example.tmdbapp.presentation.di

import com.example.tmdbapp.presentation.di.playingmovie.PlayingMovieSubComponent
import com.example.tmdbapp.presentation.di.popularmovie.PopularMovieSubComponent

interface Injector {

    fun createPopularMovieSubComponent():PopularMovieSubComponent
    fun createPlayingMovieSubComponent():PlayingMovieSubComponent

}