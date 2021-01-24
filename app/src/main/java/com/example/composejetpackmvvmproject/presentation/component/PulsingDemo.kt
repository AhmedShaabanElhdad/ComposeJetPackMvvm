package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.animation.core.*
import androidx.compose.animation.transition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.example.composejetpackmvvmproject.presentation.animation.animationDefination
import com.example.composejetpackmvvmproject.presentation.animation.animationDefination.AnimState.*

@Composable
fun pulseAnimation() {
    val color = MaterialTheme.colors.primary

    // animation will use our three requirement we define below
    val pulseAnim = transition(
        definition = animationDefination.pulseDefinition,
        initState = INIT,
        toState = FINISH
    )

    //this is float value that will be made on property
    val pulseMagintude = pulseAnim[animationDefination.pulsePropKey]

//    Canvas(modifier = Modifier.fillMaxWidth().height(50.dp)) {
//        drawCircle(
//            radius = pulseMagintude,
//            brush = SolidColor(color)
//        )
//    }

    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.height(pulseMagintude.dp).width(pulseMagintude.dp).align(Alignment.CenterVertically),
            imageVector = Icons.Default.Favorite
        )
    }
}