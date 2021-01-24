package com.example.composejetpackmvvmproject.presentation.ui.reciepeList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejetpackmvvmproject.domain.model.Recipe
import com.example.composejetpackmvvmproject.repository.RecipeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Named

class ReciepeListViewModel @ViewModelInject constructor(
    private val repo: RecipeRepository,
    private @Named("access_token") val token: String
) : ViewModel() {


    val query = mutableStateOf("")
    var selectedPosititon: Float = 0f
    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())
    var selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)
    var loading: MutableState<Boolean> = mutableStateOf(false)

    init {
        onSearch()
    }

    fun onQueryChange(value: String) {
        query.value = value
    }

    fun onCategoryChanged(category: String) {
        val newCategory = getSpecificCategory(category)
        selectedCategory.value = newCategory
        onQueryChange(category)
    }

    fun onPositionChanged(newPosition: Float) {
        selectedPosititon = newPosition
    }

    fun clearCategory() {
        selectedCategory.value = null
    }

    fun resetData() {
        recipes.value = listOf()
        if (selectedCategory.value?.name != query.value)
            clearCategory()
    }

    fun onSearch() {
        loading.value = true
        resetData()
        viewModelScope.launch {
            val result = repo.search(
                query = query.value,
                page = 1,
                tocken = token
            )
            delay(1000)
            loading.value = false
            recipes.value = result
        }
    }
}