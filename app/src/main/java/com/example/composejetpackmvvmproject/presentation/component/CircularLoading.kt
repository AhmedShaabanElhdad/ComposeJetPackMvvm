package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.ConstraintSet
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.composejetpackmvvmproject.R
import com.example.composejetpackmvvmproject.utiles.PROGRESS
import com.example.composejetpackmvvmproject.utiles.TITLE

@Composable
fun CircularLoading(isDisplayed: Boolean) {


    if (isDisplayed) {

        WithConstraints(modifier = Modifier.fillMaxWidth()) {
            val constraint = if (minWidth < 600.dp)//portrait
                decoupleConstrain(0.7f)
            else //landscap
                decoupleConstrain(0.3f)


            ConstraintLayout(
                modifier = Modifier.fillMaxWidth(),
                constraintSet = constraint
            ) {

                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.layoutId(PROGRESS)
                )

                Text(
                    text = AmbientContext.current.resources.getString(R.string.loading),
                    style = TextStyle(
                        MaterialTheme.colors.primary,
                        fontSize = TextUnit.Companion.Sp(15)
                    ),
                    modifier = Modifier.layoutId(TITLE)
                )
            }
        }


//    if (isDisplayed) {
//
//        ConstraintLayout(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//
//            val progressBar = createRef()
//            val title = createRef()
//            val guideline = createGuidelineFromTop(0.3f)
//
//            CircularProgressIndicator(
//                color = MaterialTheme.colors.primary,
//                modifier = Modifier.constrainAs(progressBar) {
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(guideline)
//                },
//            )
//
//            Text(
//                text = AmbientContext.current.resources.getString(R.string.loading),
//                style = TextStyle(
//                    MaterialTheme.colors.primary,
//                    fontSize = TextUnit.Companion.Sp(15)
//                ),
//                modifier = Modifier.constrainAs(title) {
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(progressBar.bottom)
//                }
//            )
//        }


//        Row (
//            modifier = Modifier.fillMaxWidth().padding(20.dp),
//            horizontalArrangement = Arrangement.Center
//        ){
//            CircularProgressIndicator(
//                color = MaterialTheme.colors.primary
//            )
//        }

    }


}

fun decoupleConstrain(verticalBais: Float) = ConstraintSet {
    val progressBar = createRefFor(PROGRESS)
    val title = createRefFor(TITLE)
    val topGuideline = createGuidelineFromTop(verticalBais)

    constrain(progressBar) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(topGuideline)
    }

    constrain(title) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(progressBar.bottom)
    }

}