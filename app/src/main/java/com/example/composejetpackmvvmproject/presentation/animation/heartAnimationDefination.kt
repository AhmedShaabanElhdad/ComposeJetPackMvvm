package com.example.composejetpackmvvmproject.presentation.animation

import androidx.compose.animation.ColorPropKey
import androidx.compose.animation.DpPropKey
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composejetpackmvvmproject.presentation.animation.HeartAnimationDefination.HeartState.ACTIVE
import com.example.composejetpackmvvmproject.presentation.animation.HeartAnimationDefination.HeartState.IDLE

object HeartAnimationDefination {


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