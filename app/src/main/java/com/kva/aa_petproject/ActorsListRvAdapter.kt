package com.kva.aa_petproject

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kva.aa_petproject.data.ActorData
import com.kva.aa_petproject.data.MovieData
import com.kva.aa_petproject.databinding.MovieDetailsActorsListItemBinding

class ActorsListRvAdapter(
    movie: MovieData?,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val actors: List<ActorData>? = movie?.actors

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ActorsListViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return actors?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ActorsListViewHolder -> {
                val currentItem = actors?.get(position)
                currentItem?.let { holder.bind(it) }
            }
        }
    }

    class ActorsListViewHolder private constructor(private val binding: MovieDetailsActorsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val res: Resources = itemView.context.resources

        fun bind(item: ActorData) {
            Glide
                .with(itemView)
                .load(item.imageUrl)
                .error(ResourcesCompat.getDrawable(res, R.drawable.image_error, null))
                .into(binding.ivActorPoster)
            binding.tvActorName.text = item.name

        }

        companion object {
            fun from(parent: ViewGroup): ActorsListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieDetailsActorsListItemBinding.inflate(layoutInflater, parent, false)
                return ActorsListViewHolder(binding)
            }
        }
    }
}

