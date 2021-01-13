package com.example.composejetpackmvvmproject.presentation.ui.reciepe

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.composejetpackmvvmproject.repository.RecipeRepository
import javax.inject.Named

class ReciepeViewModel @ViewModelInject constructor(
    private val repo: RecipeRepository,
    private @Named("access_token") val token: String
) : ViewModel() {

}