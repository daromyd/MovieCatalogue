package com.example.moviecatalogue.ui.favorite.tvshow

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
import com.example.moviecatalogue.databinding.FragmentFavTvShowBinding
import com.example.moviecatalogue.viewModel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavTvShowFragment : Fragment() {

    private lateinit var fragmentFavTvShowBinding: FragmentFavTvShowBinding
    private lateinit var viewModel: FavTvShowViewModel
    private lateinit var tvShowAdapter: FavTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavTvShowBinding = FragmentFavTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentFavTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentFavTvShowBinding.rvFavTvShow)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavTvShowViewModel::class.java]

            tvShowAdapter = FavTvShowAdapter()

            viewModel.getFavTvShow().observe(this, { tvShow ->
                if (tvShow != null){
                    fragmentFavTvShowBinding.progressBar.visibility = View.GONE
                    tvShowAdapter.submitList(tvShow)
                }
            })

            with(fragmentFavTvShowBinding.rvFavTvShow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
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
                val tvShowEntity = tvShowAdapter.getSwipedData(swipedPosition)

                tvShowEntity?.let { viewModel.setFav(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    tvShowEntity?.let { viewModel.setFav(it) }
                }
                snackbar.show()
            }
        }
    })
}