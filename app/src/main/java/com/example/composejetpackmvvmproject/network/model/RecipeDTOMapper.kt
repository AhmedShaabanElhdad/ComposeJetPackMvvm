package com.example.composejetpackmvvmproject.network.model

import com.example.composejetpackmvvmproject.domain.model.Recipe
import com.example.composejetpackmvvmproject.domain.utility.DomainMapper

class RecipeDTOMapper() : DomainMapper<Recipe, RecipeDTO> {

    override fun mapToDomainModel(domain: RecipeDTO): Recipe {
        return Recipe(
            id = domain.pk,
            title = domain.title,
            featured_image = domain.featuredImage,
            ingredients = domain.ingredients ?: listOf(),
            cooking_instructions = domain.cookingInstructions,
            date_added = domain.dateAdded,
            date_updated = domain.dateUpdated,
            description = domain.description,
            publisher = domain.publisher,
            rating = domain.rating,
            source_url = domain.source_url
        )
    }


    override fun mapFromDomainModel(model: Recipe): RecipeDTO {
        TODO("Not yet implemented")
    }


    fun toDomainList(initial:List<RecipeDTO>):List<Recipe>{
        return initial.map { mapToDomainModel(it) }
    }


    fun fromDomainList(initial:List<Recipe>):List<RecipeDTO>{
        TODO("Not yet implemented")
        return listOf()
    }
}