package com.kva.aa_petproject.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreData(
    val id: Int,
    val name: String,
) : Parcelable