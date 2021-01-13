package com.example.composejetpackmvvmproject.presentation.ui.reciepeList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejetpackmvvmproject.domain.model.Recipe
import com.example.composejetpackmvvmproject.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Named

class ReciepeListViewModel @ViewModelInject constructor(
    private val repo: RecipeRepository,
    private @Named("access_token") val token: String
) : ViewModel() {
    val recipes: StateFlow<List<Recipe>> = MutableStateFlow(listOf())

    init {
        viewModelScope.launch {
            repo.search(query = "chicken",page = 1,tocken = token)
        }
    }
}