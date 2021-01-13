package com.example.composejetpackmvvmproject.network.response

import com.example.composejetpackmvvmproject.network.model.RecipeDTO
import com.google.gson.annotations.SerializedName


data class RecipeSearchResponse(
    val count: Int,
    val next: String,
    val previous: String,
    @SerializedName("results")
    val recipes: List<RecipeDTO>
)