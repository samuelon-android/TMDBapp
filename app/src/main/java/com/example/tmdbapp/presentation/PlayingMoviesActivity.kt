package com.example.tmdbapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbapp.R
import com.example.tmdbapp.databinding.ActivityPlayingMoviesBinding

class PlayingMoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayingMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_playing_movies)
    }
}