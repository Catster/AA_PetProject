package com.kva.aa_petproject

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kva.aa_petproject.data.Movie
import com.kva.aa_petproject.databinding.MovieListItemBinding
import com.kva.aa_petproject.databinding.MoviesListHeaderBinding

private const val ITEM_VIEW_TYPE_HEADER = 0
private const val ITEM_VIEW_TYPE_ITEM = 1

class MoviesListRvAdapter(
    context: Context,
    private val movies: List<Movie>,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listener = context as? FragmentMoviesListListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> TextHeaderViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> MoviesListViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == 0) ITEM_VIEW_TYPE_HEADER else ITEM_VIEW_TYPE_ITEM
    }

    override fun getItemCount(): Int {
        return movies.size + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MoviesListViewHolder -> {
                val currentItem = movies[position - 1]
                holder.bind(currentItem)
                holder.itemView.setOnClickListener {
                    listener?.onClick(movie = currentItem)
                }
            }
        }
    }

    class TextHeaderViewHolder private constructor(binding: MoviesListHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): TextHeaderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MoviesListHeaderBinding.inflate(layoutInflater, parent, false)
                return TextHeaderViewHolder(binding)
            }
        }
    }

    class MoviesListViewHolder private constructor(private val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val res: Resources = itemView.context.resources

        fun bind(item: Movie) {
            Glide
                .with(itemView)
                .load(item.poster)
                .into(binding.ivMoviePoster)
            binding.tvFilmName.text = item.nameMovie
            binding.tvPgInfo.text = item.rated
            binding.tvGenres.text = item.movieGenre
            binding.rbReviewRate.rating = item.rating
            binding.tvReview.text =
                res.getString(R.string.reviews, item.reviews.toString())
            binding.tvFilmDuration.text =
                res.getString(R.string.film_duration, item.movieDuration.toString())
        }

        companion object {
            fun from(parent: ViewGroup): MoviesListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieListItemBinding.inflate(layoutInflater, parent, false)
                return MoviesListViewHolder(binding)
            }
        }
    }
}

