package com.example.tmdbapp.presentation.popularmovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbapp.R
import com.example.tmdbapp.data.model.popular.PopularMovie
import com.example.tmdbapp.databinding.ListItemBinding

class PopularMovieAdapter():RecyclerView.Adapter<MyViewHolder>() {

    private val popularMovieList = ArrayList<PopularMovie>()
    fun setList(popularMovies:List<PopularMovie>){
        popularMovieList.clear()
        popularMovieList.addAll(popularMovies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from((parent.context))
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(popularMovieList[position])
    }

    override fun getItemCount(): Int = popularMovieList.size
}

class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(popularMovie : PopularMovie){
        binding.tvTitle.text = popularMovie.title
        binding.tvDescription.text = popularMovie.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500" + popularMovie.posterPath
        Glide.with(binding.imgMovie.context).load(posterUrl).into(binding.imgMovie)
    }

}