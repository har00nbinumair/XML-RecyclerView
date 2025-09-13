package com.example.recyclerviewapiapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ContributorModel(
    @PrimaryKey
    @SerializedName("login")
    val login: String,
    @SerializedName("contributions")
    val contributions: Int,
    @SerializedName("avatar_url")
    val avatarUrl: String
)
