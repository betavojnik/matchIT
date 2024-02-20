package com.example.matchittryhard.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Position(
    val name: String,
    val about: String,
    val picture: String,
    val salaryRange: Double,
    val description: String,
    val technologies: String,
) : Parcelable
