package com.example.composejetpackmvvmproject.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class RecipeDTO(
    val pk: Int? = null,
    @SerializedName("cooking_instructions")
    val cookingInstructions: String? = null,

    @SerializedName("date_added")
    val dateAdded: String? = null,

    @SerializedName("date_updated")
    val dateUpdated: String? = null,

    val description: String? = null,

    @SerializedName("featured_image")
    val featuredImage: String? = null,
    val ingredients: List<String>?,
    val publisher: String? = null,
    val rating: Int = 0,
    val source_url: String? = null,
    val title: String? = null
)