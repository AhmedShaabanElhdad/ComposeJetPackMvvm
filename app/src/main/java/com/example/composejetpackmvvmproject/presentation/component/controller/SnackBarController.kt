package com.example.composejetpackmvvmproject.presentation.component.controller

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SnackBarController(private val scope: CoroutineScope) {

    private var myJob: Job? = null

    fun getScope() = scope

    init {
        cancelActiveJob()
    }


    @ExperimentalMaterialApi
    fun showSnackBar(scaffoldState: ScaffoldState, message: String, labelAction: String) {
        if (myJob == null) {
            myJob = scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = message,
                    actionLabel = labelAction,
                    duration = SnackbarDuration.Short
                )
                cancelActiveJob()
            }

        } else {
            cancelActiveJob()
            myJob = scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = message,
                    actionLabel = labelAction,
                    duration = SnackbarDuration.Short
                )
                cancelActiveJob()
            }

        }
    }

    private fun cancelActiveJob() {
        myJob?.let { job ->
            job.cancel()
            myJob = Job()
        }
    }

}