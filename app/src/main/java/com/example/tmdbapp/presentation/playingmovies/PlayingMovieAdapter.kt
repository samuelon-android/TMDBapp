package com.example.tmdbapp.presentation.playingmovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbapp.R
import com.example.tmdbapp.data.model.playing.PlayingMovie
import com.example.tmdbapp.data.model.popular.PopularMovie
import com.example.tmdbapp.databinding.ListItemBinding

class PlayingMovieAdapter():RecyclerView.Adapter<MyViewHolder>() {

    private val playingMovieList = ArrayList<PlayingMovie>()
    fun setList(playingMovies:List<PlayingMovie>){
        playingMovieList.clear()
        playingMovieList.addAll(playingMovies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from((parent.context))
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(playingMovieList[position])
    }

    override fun getItemCount(): Int = playingMovieList.size
}

class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(playingMovie : PlayingMovie){
        binding.tvTitle.text = playingMovie.title
        binding.tvDescription.text = playingMovie.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500" + playingMovie.posterPath
        Glide.with(binding.imgMovie.context).load(posterUrl).into(binding.imgMovie)
    }

}