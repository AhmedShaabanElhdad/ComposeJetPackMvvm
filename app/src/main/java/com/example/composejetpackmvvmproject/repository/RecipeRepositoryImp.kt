package com.example.composejetpackmvvmproject.repository

import com.example.composejetpackmvvmproject.domain.model.Recipe
import com.example.composejetpackmvvmproject.domain.utility.DomainMapper
import com.example.composejetpackmvvmproject.network.ReceipeService
import com.example.composejetpackmvvmproject.network.model.RecipeDTOMapper
import javax.inject.Inject

class RecipeRepositoryImp /*@Inject constructor*/(private val service: ReceipeService, private val mapper: RecipeDTOMapper) :
    RecipeRepository {
    override suspend fun search(tocken: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(service.search(token = tocken,page = page,query = query).recipes)
    }

    override suspend fun get(tocken: String, id: Int): Recipe {
        return mapper.mapToDomainModel(service.get(token = tocken,id = id))
    }

}