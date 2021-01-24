package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.transition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import com.example.composejetpackmvvmproject.R
import com.example.composejetpackmvvmproject.presentation.animation.HeartAnimationDefination
import com.example.composejetpackmvvmproject.presentation.animation.HeartAnimationDefination.HeartState.ACTIVE
import com.example.composejetpackmvvmproject.presentation.animation.HeartAnimationDefination.HeartState.IDLE
import com.example.composejetpackmvvmproject.presentation.animation.HeartAnimationDefination.heartAnimaDef
import com.example.composejetpackmvvmproject.presentation.animation.HeartAnimationDefination.heartSize
import com.example.composejetpackmvvmproject.utiles.LoadImage

object HeartAnimation {

    @Composable
    fun AnimatedHeartButton(
        modifier: Modifier,
        heartState: MutableState<HeartAnimationDefination.HeartState>,
        onToggle: () -> Unit
    ) {

        val toState = if (heartState.value == IDLE)
            ACTIVE
        else
            IDLE

        val state = transition(
            definition = heartAnimaDef,
            toState = toState,
            initState = heartState.value
        )

        HeartButton(
            modifier = modifier,
            state = state,
            heartState = heartState,
            onToggle = onToggle
        )
    }


    @Composable
    fun HeartButton(
        modifier: Modifier,
        state: TransitionState,
        heartState: MutableState<HeartAnimationDefination.HeartState>,
        onToggle: () -> Unit
    ) {

        if (heartState.value == IDLE) {
            LoadImage(srcId = R.drawable.empty_heart).value?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    modifier = modifier
                        .width(state[heartSize])
                        .height(state[heartSize])
                        .clickable(onClick = onToggle, indication = null)
                )
            }
        } else {
            LoadImage(srcId = R.drawable.heart).value?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    modifier = modifier
                        .width(state[heartSize])
                        .height(state[heartSize])
                        .clickable(onClick = onToggle, indication = null)
                )
            }
        }
    }
}