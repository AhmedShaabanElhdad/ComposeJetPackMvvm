package com.example.composejetpackmvvmproject.presentation.ui.reciepeList


// act like mvi here is the action and make it unidirection
sealed class ReciepeListEvent {
    object SearchEvent:ReciepeListEvent()
    object GetNextPageEvent:ReciepeListEvent()
}