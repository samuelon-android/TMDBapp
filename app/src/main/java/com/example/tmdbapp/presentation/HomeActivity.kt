package com.example.tmdbapp.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbapp.R
import com.example.tmdbapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.apply {

            btnPopularMovies.setOnClickListener {
                val intent = Intent(this@HomeActivity,PopularMoviesActivity::class.java)
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this@HomeActivity).toBundle())
            }

            btnPlayingMovies.setOnClickListener {
                val intent = Intent(this@HomeActivity,PlayingMoviesActivity::class.java)
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this@HomeActivity).toBundle())
            }

        }

    }
}