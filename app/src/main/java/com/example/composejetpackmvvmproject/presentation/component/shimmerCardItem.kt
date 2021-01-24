package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

///we will make shimmer with same size of image that showing loading [height] will be good for that
///[colors] represent the color for gradient brush
///[xShimmer][yShimmer]
@Composable
fun ShimmerCardItem(
    colors:List<Color>,
    height:Dp,
    XShimmer:Float,
    YShimmer:Float,
    padding:Dp,
    gradientValue:Float

){
    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(XShimmer-gradientValue,YShimmer-gradientValue),
        end = Offset(x = XShimmer,YShimmer)
    )

    Column(modifier = Modifier.padding(padding)) {
        Surface(shape = MaterialTheme.shapes.small) {
            Spacer(modifier = Modifier.fillMaxWidth().preferredHeight(height).background(brush = brush))
        }

        Spacer(modifier = Modifier.padding(top = 10.dp))

        Surface(shape = MaterialTheme.shapes.small) {
            Spacer(modifier = Modifier.fillMaxWidth().preferredHeight(height/10).background(brush = brush))
        }
    }

}