package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MyDrawer(navController: NavController){
    Column {
        Text(text = "Profile")
        Text(text = "Profile")
        Text(text = "Profile")
        Text(text = "Profile")
        Text(text = "Profile")
    }
}