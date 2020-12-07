package com.kva.aa_petproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kva.aa_petproject.data.Movie
import com.kva.aa_petproject.databinding.FragmentMovieDetailsBinding

private const val MOVIE_PARAM = "MOVIE_PARAM"

class FragmentMovieDetails : Fragment() {
    private var fragmentMovieDetailsBinding: FragmentMovieDetailsBinding? = null
    var movieDetails: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieDetails = it.getParcelable(MOVIE_PARAM) as? Movie
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)
        fragmentMovieDetailsBinding = FragmentMovieDetailsBinding.bind(view)
        val adapter = ActorsListRvAdapter(movieDetails)
        fragmentMovieDetailsBinding?.rvMovieDetailsListActors?.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentMovieDetailsBinding?.tvBack?.setOnClickListener { navigateBack() }
        fragmentMovieDetailsBinding?.ivMovieImage?.let {
            Glide
                .with(this)
                .load(movieDetails?.detailPoster)
                .into(it)
        }
        fragmentMovieDetailsBinding?.tvPgInfo?.text = movieDetails?.rated
        fragmentMovieDetailsBinding?.tvName?.text = movieDetails?.nameMovie
        fragmentMovieDetailsBinding?.tvFilmDescription?.text = movieDetails?.description
        fragmentMovieDetailsBinding?.tvGenres?.text = movieDetails?.movieGenre
        fragmentMovieDetailsBinding?.rbReviewRate?.rating = movieDetails?.rating ?: 0f
        fragmentMovieDetailsBinding?.tvReview?.text = resources.getString(R.string.reviews, movieDetails?.reviews.toString())
    }

    override fun onDestroyView() {
        fragmentMovieDetailsBinding?.rvMovieDetailsListActors?.adapter = null
        fragmentMovieDetailsBinding = null
        super.onDestroyView()
    }

    private fun navigateBack() {
        parentFragmentManager.popBackStack()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param movie Movie to show details.
         * @return A new instance of fragment MovieDetailsFragment.
         */
        @JvmStatic
        fun newInstance(movie: Movie) =
            FragmentMovieDetails().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE_PARAM, movie)
                }
            }
    }
}