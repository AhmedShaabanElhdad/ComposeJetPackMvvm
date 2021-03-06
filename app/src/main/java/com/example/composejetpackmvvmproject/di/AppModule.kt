package com.example.composejetpackmvvmproject.di

import android.content.Context
import com.example.composejetpackmvvmproject.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApp(@ApplicationContext app: Context): BaseApplication {
        return  app as BaseApplication
    }

}