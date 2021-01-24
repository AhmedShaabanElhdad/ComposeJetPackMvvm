package com.example.composejetpackmvvmproject.presentation.animation

import androidx.compose.animation.core.*
import com.example.composejetpackmvvmproject.presentation.animation.animationDefination.AnimState.*


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