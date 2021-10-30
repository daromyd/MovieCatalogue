package com.example.moviecatalogue.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.R
import com.example.moviecatalogue.core.domain.model.Movie
import com.example.moviecatalogue.databinding.ItemMoviesBinding
import java.text.SimpleDateFormat

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.ListViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?){
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMoviesBinding.bind(itemView)
        fun bind(data: Movie) {

            with(binding){
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/original" + data.imageUrl)
                    .into(imgMovie)
                tvItemTitle.text = data.title
                tvReleaseDate.text = dateFormat(data.release)
                tvItemRate.text = data.rate.toString()
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

    @SuppressLint("SimpleDateFormat")
    fun dateFormat(date: String): String{
        val cutFormatter = SimpleDateFormat("yyyy-MM-dd")
        val dateObject = cutFormatter.parse(date)
        val postFormatter = SimpleDateFormat("dd MMMM yyyy")
        return postFormatter.format(dateObject)
    }
}