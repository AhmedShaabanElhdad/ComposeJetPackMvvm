package com.example.composejetpackmvvmproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.material.Text
import androidx.compose.ui.platform.setContent
import com.example.composejetpackmvvmproject.R
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
        setContentView(R.layout.activity_custom_view_with_compose_jetpack)
//        setContent {
//            Text(text = "Hello  for Test")
//        }

    }
}