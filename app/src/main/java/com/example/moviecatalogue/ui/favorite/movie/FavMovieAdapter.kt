package com.example.moviecatalogue.ui.favorite.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.databinding.ItemMoviesBinding
import com.example.moviecatalogue.ui.detail.movie.DetailMovieActivity

class FavMovieAdapter : PagedListAdapter<MovieEntity, FavMovieAdapter.FavMovieViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>(){
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavMovieViewHolder {
        val itemsFavMovieBinding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavMovieViewHolder(itemsFavMovieBinding)
    }

    override fun onBindViewHolder(holder: FavMovieViewHolder, position: Int) {
        val favMovie = getItem(position)
        if (favMovie != null){
            holder.bind(favMovie)
        }
    }

    fun getSwipedData(swipePosition: Int): MovieEntity? = getItem(swipePosition)

    inner class FavMovieViewHolder(private val binding: ItemMoviesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(favMovie: MovieEntity){
            with(binding){
                tvItemTitle.text = favMovie.title
                tvItemGenre.text = favMovie.genre
                tvItemYear.text = favMovie.year.toString()
                tvItemRate.text = favMovie.rating.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_ID, favMovie.movieId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(favMovie.poster)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgMovie)
            }
        }
    }
}