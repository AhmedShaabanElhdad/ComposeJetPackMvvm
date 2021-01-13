package com.example.composejetpackmvvmproject.network

import com.example.composejetpackmvvmproject.network.model.RecipeDTO
import com.example.composejetpackmvvmproject.network.response.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ReceipeService {
    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeSearchResponse


    @GET("get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): RecipeDTO
}