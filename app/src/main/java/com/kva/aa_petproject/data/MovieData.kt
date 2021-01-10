package com.kva.aa_petproject.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieData(
    val id: Int,
    val pgAge: Int,
    val title: String,
    val genres: List<GenreData>,
    val runningTime: Int,
    val reviewCount: Int,
    val isLiked: Boolean,
    val rating: Int,
    val imageUrl: String,
    val detailImageUrl: String,
    val storyLine: String,
    val actors: List<ActorData>

) : Parcelable