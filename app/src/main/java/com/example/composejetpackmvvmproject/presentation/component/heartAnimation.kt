package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.animation.ColorPropKey
import androidx.compose.animation.DpPropKey
import androidx.compose.animation.core.*
import androidx.compose.animation.transition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.example.composejetpackmvvmproject.R
import com.example.composejetpackmvvmproject.presentation.component.HeartAnimation.HeartState.*
import com.example.composejetpackmvvmproject.utiles.LoadImage

object HeartAnimation {

    @Composable
    fun AnimatedHeartButton(
        modifier: Modifier,
        heartState: MutableState<HeartState>,
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
        heartState: MutableState<HeartState>,
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


    //define state
    enum class HeartState {
        IDLE, ACTIVE
    }

    //define prop key
    // here we use label if we will use more than one prop key
    val heartColor = ColorPropKey(label = "heartColorKey")
    val heartSize = DpPropKey(label = "heartSizeKey")


    val idleSize = 50f.dp
    val expandIconSize = 80f.dp

    // define defination
    val heartAnimaDef = transitionDefinition<HeartState> {

        state(IDLE) {
            this[heartColor] = Color.White
            this[heartSize] = idleSize
        }
        state(ACTIVE) {
            this[heartColor] = Color.Red
            this[heartSize] = expandIconSize
        }

        transition(IDLE to ACTIVE) {
            heartColor using tween(
                durationMillis = 500,
            )
            heartSize using keyframes {
                durationMillis = 500
                expandIconSize at 100
                idleSize at 200
            }
        }
        transition(ACTIVE to IDLE) {
            heartColor using tween(
                durationMillis = 500,
            )
            heartSize using keyframes {
                durationMillis = 500
                expandIconSize at 100
                idleSize at 200
            }
        }
    }

}