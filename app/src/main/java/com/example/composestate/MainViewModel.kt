package com.example.composestate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class MainViewModel: ViewModel() {
    private val _stateFlowColor = MutableStateFlow(0xFFFFFFFF)
    val stateFlowColor = _stateFlowColor.asStateFlow()

    var composeColor by mutableStateOf(0xFFFFFFFF)
        private set

    fun generateNewColor() {
        val newColor = Random.nextLong(0xFFFFFFFF)
        _stateFlowColor.value = newColor
        composeColor = newColor
    }
}