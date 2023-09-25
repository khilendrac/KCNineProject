package com.example.kcnineproject.utilities

import com.example.kcnineproject.data.Asset

/*
Declaring a sealed class UIState in order to restrict the types of variables that UIState can have.
The advantage of sealed class instead of enum is it enables us to pass values with the states.
 */
sealed class UIState {
    object Loading : UIState()
    data class Loaded(val assets: List<Asset>) : UIState()
    data class Error(val message: String) : UIState()
}