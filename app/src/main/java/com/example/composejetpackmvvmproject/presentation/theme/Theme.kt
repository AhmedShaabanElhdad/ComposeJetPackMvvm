package com.example.composejetpackmvvmproject.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val lightThemeColor = lightColors(
    primary = BLUE600,
    primaryVariant = BLUE400,
    onPrimary = BLACK2,

    secondary = Color.White,
    secondaryVariant = TEAL,
    onSecondary = BLACK1,

    background = GREY1,
    onBackground = Color.Black,

    error = RedErrorDark,
    onError = RedErrorLight,

    surface = Color.White,
    onSurface = BLACK2
)

val darkThemeColor = darkColors(
    primary = BLUE700,
    primaryVariant = Color.White,
    onPrimary = Color.White,

    secondary = BLACK2,
    onSecondary = Color.White,

    background = Color.Black,
    onBackground = Color.White,

    error = RedErrorDark,
    onError = RedErrorLight,

    surface = BLACK2,
    onSurface = Color.White
)

//you can also custom color
val myNewCustomColor = Colors(
    primary = BLUE700,
    primaryVariant = Color.White,
    onPrimary = Color.White,

    secondary = BLACK2,
    onSecondary = Color.White,

    background = Color.Black,
    onBackground = Color.White,

    error = RedErrorDark,
    onError = RedErrorLight,

    surface = BLACK2,
    onSurface = Color.White,
    secondaryVariant = TEAL,
    isLight = false
)


@Composable
fun AppTheme(
    darkTheme:Boolean,
    content:@Composable () -> Unit
){
    MaterialTheme(colors = if (darkTheme) darkThemeColor else lightThemeColor) {
        content()
    }
}