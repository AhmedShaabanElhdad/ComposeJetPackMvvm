package com.example.composejetpackmvvmproject.di

import com.example.composejetpackmvvmproject.network.ReceipeService
import com.example.composejetpackmvvmproject.network.model.RecipeDTOMapper
import com.example.composejetpackmvvmproject.presentation.BaseApplication
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(BaseApplication::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideReciepeMapper(): RecipeDTOMapper {
        return RecipeDTOMapper()
    }

    @Singleton
    @Provides
    fun provideRetrofit(): ReceipeService {
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ReceipeService::class.java)
    }

    @Singleton
    @Provides
    @Named("access_token")
    fun provideAccessToken():String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }

}