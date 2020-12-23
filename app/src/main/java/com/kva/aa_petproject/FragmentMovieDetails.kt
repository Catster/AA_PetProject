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
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentMovieDetailsBinding.bind(view)
        val adapter = ActorsListRvAdapter(movieDetails)
        binding.rvMovieDetailsListActors.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            tvBack.setOnClickListener { navigateBack() }
            tvPgInfo.text = movieDetails?.rated
            tvName.text = movieDetails?.nameMovie
            tvFilmDescription.text = movieDetails?.description
            tvGenres.text = movieDetails?.movieGenre
            rbReviewRate.rating = movieDetails?.rating ?: 0f
            tvReview.text = resources.getString(R.string.reviews, movieDetails?.reviews.toString())

            binding.ivMovieImage.let {
                Glide.with(requireContext())
                    .load(movieDetails?.detailPoster)
                    .into(it)
            }
        }
    }

    override fun onDestroyView() {
        binding.rvMovieDetailsListActors.adapter = null
        _binding = null
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