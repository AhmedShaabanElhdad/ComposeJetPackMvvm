package com.example.composejetpackmvvmproject.presentation.ui.reciepeList

import com.example.composejetpackmvvmproject.presentation.ui.reciepeList.FoodCategory.*

enum class FoodCategory(value: String) {
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut"),
}

fun getAllCategory(): List<FoodCategory> {
    return listOf(CHICKEN, BEEF, SOUP, DESSERT, VEGETARIAN, MILK, VEGAN, PIZZA, DONUT)
}

fun getSpecificCategory(value:String): FoodCategory? {
    val map = FoodCategory.values().associateBy(FoodCategory::name )
    return map.get(value)
}