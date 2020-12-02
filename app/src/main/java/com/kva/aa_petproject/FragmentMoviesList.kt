package com.kva.aa_petproject

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kva.aa_petproject.data.FakeMovies
import com.kva.aa_petproject.data.Movie
import com.kva.aa_petproject.databinding.FragmentMoviesListBinding
import com.kva.aa_petproject.utils.Utils
import kotlin.math.roundToInt


class FragmentMoviesList : Fragment() {

    private var fragmentMoviesListBinding: FragmentMoviesListBinding? = null
    private var listener: FragmentMoviesListListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        fragmentMoviesListBinding = FragmentMoviesListBinding.bind(view)
        val adapter = MoviesListRvAdapter(requireContext(), FakeMovies().getListMovies())
        val orientation = context?.resources?.configuration?.orientation
        val spanCount = if (orientation == ORIENTATION_PORTRAIT) 2 else 3
        val gridLayoutManager = GridLayoutManager(context, spanCount, RecyclerView.VERTICAL, false)
        val spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (orientation) {
                    ORIENTATION_PORTRAIT -> if (position == 0) 2 else 1
                    ORIENTATION_LANDSCAPE -> if (position == 0) 3 else 1
                    else -> if (position == 0) 2 else 1
                }
            }
        }
        gridLayoutManager.spanSizeLookup = spanSizeLookup

        fragmentMoviesListBinding?.rvListMovies?.adapter = adapter
        fragmentMoviesListBinding?.rvListMovies?.layoutManager = gridLayoutManager
        fragmentMoviesListBinding?.rvListMovies?.addItemDecoration(
            ItemDecoration(
                paddingLeft =  Utils.convertDpToPixel(6f, requireContext()).roundToInt(),
                paddingRight =  Utils.convertDpToPixel(6f, requireContext()).roundToInt(),
                paddingBottom = Utils.convertDpToPixel(10f, requireContext()).roundToInt()
            )
        )
        return view
    }

    override fun onDestroyView() {
        fragmentMoviesListBinding?.rvListMovies?.adapter = null
        fragmentMoviesListBinding = null
        super.onDestroyView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentMoviesListListener) {
            listener = context
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentMoviesList()
    }
}

interface FragmentMoviesListListener {
    fun onClick(movie: Movie)
}