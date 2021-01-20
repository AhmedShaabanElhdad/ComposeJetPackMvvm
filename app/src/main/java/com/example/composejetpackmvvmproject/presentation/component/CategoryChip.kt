package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.composejetpackmvvmproject.R
import com.example.composejetpackmvvmproject.domain.model.Recipe
import com.example.composejetpackmvvmproject.utiles.DEFAULTIMAGE
import com.example.composejetpackmvvmproject.utiles.LoadImage

@Composable
fun CategoryShip(
    category: String,
    isSelected:Boolean,
    onSelectedChange:(String)->Unit,
    onclick: () -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = if(isSelected) Color.LightGray else MaterialTheme.colors.primary,
        modifier = Modifier.padding(end = 8.dp,start = 8.dp,bottom = 8.dp),
        elevation = 8.dp,
    ) {
        Row(
            modifier = Modifier.toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectedChange(category)
                    onclick()
                }
            )
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}