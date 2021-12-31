package com.example.tmdbapp.data.model.popular
import com.example.tmdbapp.data.model.popular.PopularMovie
import com.google.gson.annotations.SerializedName

data class PopularMovieList(

    @SerializedName("results")
    val popularMovies: List<PopularMovie>

    )