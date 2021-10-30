package com.example.moviecatalogue.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviecatalogue.core.ui.MoviesAdapter
import com.example.moviecatalogue.favorite.databinding.FragmentFavMovieBinding
import com.example.moviecatalogue.favorite.favoriteModule
import com.example.moviecatalogue.ui.detail.movie.DetailMovieActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavMovieFragment : Fragment() {

    private val favMovieViewModel: FavMovieViewModel by viewModel()
    private var _binding: FragmentFavMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadKoinModules(favoriteModule)

        if (activity != null){
            val favMovieAdapter = MoviesAdapter()
            favMovieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favMovieViewModel.favoriteMovie.observe(viewLifecycleOwner, { data ->
                favMovieAdapter.setData(data)
                binding.viewEmpty.root.visibility = if (data.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvFavMovies) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = favMovieAdapter
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}