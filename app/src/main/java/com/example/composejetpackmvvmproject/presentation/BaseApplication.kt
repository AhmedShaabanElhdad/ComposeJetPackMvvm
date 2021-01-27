package com.example.composejetpackmvvmproject.presentation

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.MutableStateFlow

@HiltAndroidApp
class BaseApplication : Application() {

    val isDark = mutableStateOf(false)

    fun toggleSwitch() {
        isDark.value = !isDark.value
    }
}