package com.example.composejetpackmvvmproject.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun DefaultSnackBar(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier,
    onDissmiss: () -> Unit
) {

    SnackbarHost(
        modifier = modifier,
        hostState = snackbarHostState,
        snackbar = { data ->
            Snackbar(
                modifier = Modifier.padding(15.dp),
                action = {
                    TextButton(onClick = { onDissmiss() }) {
                        data.actionLabel?.let {
                            Text(
                                text = it,
                                color = Color.White,
                                style = MaterialTheme.typography.body2
                            )
                        }
                    }
                }) {
                Text(
                    text = data.message,
                    color = Color.White,
                    style = MaterialTheme.typography.body2
                )
            }
        },
    )

}

@ExperimentalMaterialApi
@Composable
fun MyHostedSnackBar(
    snackbarHostState: SnackbarHostState,
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val snackbar = createRef()
        SnackbarHost(
            modifier = Modifier.background(MaterialTheme.colors.error).constrainAs(snackbar) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }, hostState = snackbarHostState, snackbar = {
                Snackbar(
                    modifier = Modifier.background(color = MaterialTheme.colors.error),
                    action = {
                        TextButton(onClick = { snackbarHostState.currentSnackbarData?.dismiss() }) {
                            Text(
                                text = snackbarHostState.currentSnackbarData?.actionLabel ?: "ok",
                                style = MaterialTheme.typography.h5
                            )
                        }
                    }) {
                    Text(
                        text = snackbarHostState.currentSnackbarData?.message ?: "Exception",
                        style = MaterialTheme.typography.h6
                    )

                }
            }
        )
    }


}


@Composable
fun MySnackBar(
    isShowing: Boolean,
    error: String,
    actionLabel: String,
    sbackBarAction: () -> Unit
) {
    if (isShowing) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val snackbar = createRef()
            Snackbar(
                modifier = Modifier.background(MaterialTheme.colors.error).constrainAs(snackbar) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }, action = {
                    Text(
                        text = actionLabel,
                        modifier = Modifier.clickable(onClick = sbackBarAction),
                        style = MaterialTheme.typography.h5
                    )
                }) {
                Text(
                    text = error,
                    style = TextStyle(color = Color.White)
                )
            }
        }
    }

}