package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.animation.transition
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composejetpackmvvmproject.presentation.animation.ShimmerAnimationDefination
import com.example.composejetpackmvvmproject.presentation.animation.ShimmerAnimationDefination.*

@Composable
fun LoadRecipesListShimmer(imageHeight: Dp, padding: Dp = 16.dp) {
    WithConstraints {

        val cardWidth = with(AmbientDensity.current){
            (maxWidth - (padding * 2)).toPx()
        }
        val cardheight = with(AmbientDensity.current){
            (imageHeight - padding).toPx()
        }

        //every time new frame added object will recompose if you don't put remeber not see any thing as
        // new frame added restart defination from 0.0f and 0.0f position
        val animationDefination = remember {
            ShimmerAnimationDefination(widthPX = cardWidth, heightPX = cardheight)
        }

        val transationState = transition(
            definition = animationDefination.shimmerTransitionDefinition,
            initState = ShimmerState.START,
            toState = ShimmerState.END
        )

        val cardXShimmer = transationState[animationDefination.xShimmer]
        val cardYShimmer = transationState[animationDefination.yShimmer]

        val colors = listOf(
            Color.LightGray.copy(alpha = 0.9f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.9f)
        )

        ScrollableColumn {
            repeat(5){
                ShimmerCardItem(
                    colors = colors,
                    height = imageHeight,
                    XShimmer = cardXShimmer,
                    YShimmer = cardYShimmer,
                    padding = padding,
                    gradientValue = animationDefination.gradientValue
                )
            }
        }

    }

}