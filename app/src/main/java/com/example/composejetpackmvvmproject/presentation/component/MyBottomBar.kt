package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MyBottomBar(navController: NavController) {
    BottomNavigation(elevation = 12.dp) {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home) },
            selected = false,
            onClick = {  }
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Default.Search) },
            selected = false,
            onClick = {  }
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Default.Satellite) },
            selected = false,
            onClick = {  }
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Default.Collections) },
            selected = false,
            onClick = {  }
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Default.Room) },
            selected = false,
            onClick = {  }
        )
    }
}