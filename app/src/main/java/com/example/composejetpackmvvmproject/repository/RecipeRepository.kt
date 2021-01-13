package com.example.composejetpackmvvmproject.repository

import com.example.composejetpackmvvmproject.domain.model.Recipe

interface RecipeRepository {
    suspend fun search(tocken: String, page: Int, query: String): List<Recipe>
    suspend fun get(tocken: String, id: Int): Recipe
}