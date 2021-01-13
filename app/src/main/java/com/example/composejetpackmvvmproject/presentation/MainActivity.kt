package com.example.composejetpackmvvmproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.material.Text
import androidx.compose.ui.platform.setContent
import com.example.composejetpackmvvmproject.network.ReceipeService
import com.example.composejetpackmvvmproject.network.model.RecipeDTO
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "Hello  for Test")
        }

        val service = Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ReceipeService::class.java)


        CoroutineScope(IO).launch {
            val recipe:RecipeDTO = service.get("Token 9c8b06d329136da358c2d00e76946b0111ce2c48",583)
            Log.e("MainActivity","title is ${recipe.title}")
        }

    }
}