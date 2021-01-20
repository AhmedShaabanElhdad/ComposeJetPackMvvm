package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
fun RecipeCard(recipe: Recipe, onclick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
            .clickable(onClick = onclick),
        elevation = 8.dp,
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            recipe.featured_image?.let { url ->
                LoadImage(url = url, defaultImage = DEFAULTIMAGE).value?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        modifier = Modifier.fillMaxWidth().preferredHeight(225.dp),
                        contentScale = ContentScale.Crop
                    )
                }

            }
            recipe.title.let {
                Row {
                    Text(
                        text = recipe.title!!,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 12.dp,
                            bottom = 12.dp
                        )
                            .fillMaxWidth(0.85f).wrapContentWidth(Alignment.Start)
                    )
                    recipe.rating.let {
                        Text(
                            text = recipe.rating.toString(),
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.End)
                                .align(
                                    Alignment.CenterVertically
                                )
                        )
                    }
                }
            }


        }
    }
}