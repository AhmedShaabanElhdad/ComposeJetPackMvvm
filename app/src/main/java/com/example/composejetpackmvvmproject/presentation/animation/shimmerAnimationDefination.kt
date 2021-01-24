package com.example.composejetpackmvvmproject.presentation.animation

import androidx.compose.animation.core.*
import com.example.composejetpackmvvmproject.presentation.animation.ShimmerAnimationDefination.ShimmerState.*

//we here not make it object as we want to pass parameter like width and height in pixel that reperesent the position
class ShimmerAnimationDefination(
    widthPX:Float,
    heightPX:Float
) {

    val gradientValue:Float

    init {
        gradientValue = 0.2f * heightPX
    }

    enum class ShimmerState {
        START, END
    }

    val xShimmer = FloatPropKey("xShimmer")
    val yShimmer = FloatPropKey("yShimmer")


    val shimmerTransitionDefinition = transitionDefinition<ShimmerState> {

        state(START) {
            this[xShimmer] = 0.0f
            this[yShimmer] = 0.0f
        }

        state(END) {
            this[xShimmer] = widthPX + gradientValue
            this[yShimmer] = heightPX + gradientValue
        }

        transition (START,END){
            xShimmer using infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    delayMillis = 300,
                    easing = LinearEasing
                )
            )

            yShimmer using infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    delayMillis = 300,
                    easing = LinearEasing
                )
            )
        }
    }

}