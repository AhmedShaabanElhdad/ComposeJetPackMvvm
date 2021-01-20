package com.example.composejetpackmvvmproject.domain.model

import android.os.Parcelable

data class Recipe(
    val id: Int? = null,
    val cooking_instructions: String? = null,
    val date_added: String? = null,
    val date_updated: String? = null,
    val description: String? = null,
    val featured_image: String? = null,
    val ingredients: List<String> = listOf(),
    val publisher: String? = null,
    val rating: Int = 0,
    val source_url: String? = null,
    val title: String? = null
)