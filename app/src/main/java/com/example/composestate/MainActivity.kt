package com.example.composestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composestate.ui.theme.ComposeStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStateTheme {
                val viewModel = viewModel<MainViewModel>()
                val flowColor by viewModel.stateFlowColor.collectAsStateWithLifecycle()
                val composeColor = viewModel.composeColor

                Box(
                    modifier = Modifier.fillMaxSize()
                        .background(Color(flowColor))
                        .clickable {
                            viewModel.generateNewColor()
                        }
                )
            }
        }
    }
}