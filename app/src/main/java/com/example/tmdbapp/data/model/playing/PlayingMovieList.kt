package com.example.tmdbapp.data.model.playing


import com.example.tmdbapp.data.model.playing.PlayingMovie
import com.google.gson.annotations.SerializedName

data class PlayingMovieList(

    @SerializedName("results")
    val playingMovies: List<PlayingMovie>

)