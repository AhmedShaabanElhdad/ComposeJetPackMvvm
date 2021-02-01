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

const val PAGESIZE = 30

class ReciepeListViewModel @ViewModelInject constructor(
    private val repo: RecipeRepository,
    private @Named("access_token") val token: String
) : ViewModel() {


    //for normal search
    val query = mutableStateOf("")
    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())

    //for search through category
    var selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)
    var selectedPosititon: Float = 0f

    //general variable help in design
    var loading: MutableState<Boolean> = mutableStateOf(false)

    //pagination
    var page = mutableStateOf(1)
    var recipeScrollPosition = 0

    init {
        onSearch()
    }


    //search will
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

    // use pagination from scratch is very well rather than using other pagination library
    // as i can't handle more than data source in my code
    // like caching component nad network component
    fun onGetNext() {
        viewModelScope.launch {
            if (recipeScrollPosition + 1 >= (page.value * PAGESIZE)) {
                loading.value = true
                increasePage()

                //this check for the first time app is open
                if (page.value > 1) {
                    val result = repo.search(
                        query = query.value,
                        page = page.value,
                        tocken = token
                    )
                    print("result is $result")
                    delay(1000)
                    appendRecipes(result)
                }
                loading.value = false

            }
        }
    }

    private fun appendRecipes(result: List<Recipe>) {
        val current = ArrayList(recipes.value)
        current.addAll(result)
        recipes.value = current
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
        recipeScrollPosition = 0
        page.value = 1
        if (selectedCategory.value?.name != query.value)
            clearCategory()
    }


    fun increasePage() {
        page.value = page.value + 1
    }

    fun onChangeRecipeScrollPosition(position: Int) {
        recipeScrollPosition = position
    }
}