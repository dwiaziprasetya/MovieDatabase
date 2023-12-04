package com.example.moviedatabase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.databinding.ItemMoviesBinding
import com.example.moviedatabase.response.NowPlayingMovieResultsItem

class RvNowPlayingMovieAdapter: ListAdapter<NowPlayingMovieResultsItem, RvNowPlayingMovieAdapter.MyViewHolder>(DIFF_CALLBACK){
    private lateinit var onItemCallback : OnItemClickCallback

    class MyViewHolder(val binding: ItemMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"
        fun bind(movie : NowPlayingMovieResultsItem){
            binding.tvMovieTitle.text = movie.title
            Glide.with(itemView)
                .load(IMAGE_BASE_URL + movie.posterPath)
                .into(binding.imgItemPhoto)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NowPlayingMovieResultsItem>(){
            override fun areContentsTheSame(
                oldItem: NowPlayingMovieResultsItem,
                newItem: NowPlayingMovieResultsItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(
                oldItem: NowPlayingMovieResultsItem,
                newItem: NowPlayingMovieResultsItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.binding.root.setOnClickListener {
            onItemCallback.onItemClicked(movie)
        }
    }

    fun setOnItemClickCallback(onItemClickCallback : OnItemClickCallback){
        this.onItemCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data : NowPlayingMovieResultsItem)
    }
}