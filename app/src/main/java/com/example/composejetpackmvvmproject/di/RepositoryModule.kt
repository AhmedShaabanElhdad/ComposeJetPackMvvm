package com.example.composejetpackmvvmproject.di

import com.example.composejetpackmvvmproject.network.ReceipeService
import com.example.composejetpackmvvmproject.network.model.RecipeDTOMapper
import com.example.composejetpackmvvmproject.presentation.BaseApplication
import com.example.composejetpackmvvmproject.repository.RecipeRepository
import com.example.composejetpackmvvmproject.repository.RecipeRepositoryImp
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(BaseApplication::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideReciepeRepository(service: ReceipeService,mapper:RecipeDTOMapper): RecipeRepository {
        return RecipeRepositoryImp(service = service,mapper = mapper)
    }

}