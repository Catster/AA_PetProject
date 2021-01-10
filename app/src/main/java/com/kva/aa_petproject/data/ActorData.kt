package com.kva.aa_petproject.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActorData(
    val id: Int,
    val name: String,
    val imageUrl: String
) : Parcelable