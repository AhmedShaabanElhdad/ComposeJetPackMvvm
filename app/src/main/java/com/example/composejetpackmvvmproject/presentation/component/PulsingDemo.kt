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
import com.example.composejetpackmvvmproject.presentation.component.animationDefination.AnimState.*

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


object animationDefination {

    //1- first we will define state for animation
    enum class AnimState {
        INIT, FINISH
    }

    //2- define property key in animation like FloatPropKey , IntPropKey , ColorPropKey , PxPropKey , .....
    //Each property (to be animated) needs to be associated with a [PropKey] of the type of the property.
    val pulsePropKey = FloatPropKey("pulseKey")


    //3- define transationProperty that
    // --- define the value for each state
    // --- define how to animate from one state to another
    val pulseDefinition = transitionDefinition<AnimState> {

        state(INIT) { this[pulsePropKey] = 40.0f }
        state(FINISH) { this[pulsePropKey] = 50.0f }

        transition(INIT to FINISH) {
            //there exist alot of animationAspec like
            // --- tween(duration and easing animation)
            // --- spring (work if you want to make physics animation that ball hit in wall the animation done after hit)
            // --- keyframe if you want to make animate in more than stan 0.1 -> 0.4 -> 0.8 -> 1
            pulsePropKey using infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Restart
            )

        }
    }
}