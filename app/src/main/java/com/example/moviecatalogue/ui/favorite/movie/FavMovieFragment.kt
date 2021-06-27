package com.example.moviecatalogue.ui.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.FragmentFavMovieBinding
import com.example.moviecatalogue.viewModel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavMovieFragment : Fragment() {

    private lateinit var fragmentFavMovieBinding: FragmentFavMovieBinding
    private lateinit var viewModel: FavMovieViewModel
    private lateinit var moviesAdapter: FavMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavMovieBinding = FragmentFavMovieBinding.inflate(layoutInflater, container, false)
        return fragmentFavMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentFavMovieBinding.rvFavMovies)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavMovieViewModel::class.java]

            moviesAdapter = FavMovieAdapter()

            viewModel.getFavMovie().observe(this, { favMovies ->
                if (favMovies != null){
                    fragmentFavMovieBinding.progressBar.visibility = View.GONE
                    moviesAdapter.submitList(favMovies)

                }
            })

            with(fragmentFavMovieBinding.rvFavMovies){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }

        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = moviesAdapter.getSwipedData(swipedPosition)

                movieEntity?.let { viewModel.setFav(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    movieEntity?.let { viewModel.setFav(it) }
                }
                snackbar.show()
            }
        }
    })
}