package com.example.moviecatalogue.core.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.moviecatalogue.core.domain.model.Movie

open class MovieDiffCallback(private val oldMovies: List<Movie>, private val newMovies: List<Movie>) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldMovies.size

    override fun getNewListSize(): Int = newMovies.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldMovies[oldItemPosition].id == newMovies[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldMovies[oldItemPosition] == newMovies[newItemPosition]
}