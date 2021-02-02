package com.example.composejetpackmvvmproject.presentation.ui.reciepeList

sealed class ReciepeListEvent {
    object SearchEvent:ReciepeListEvent()
    object GetNextPageEvent:ReciepeListEvent()
}