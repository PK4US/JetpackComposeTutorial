package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Column {
                    SliderExample1()
                    SliderExample2()
                    SliderExample3()
                }
            }
        }
    }
}


@Preview
@Composable
fun SliderExample1() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Text(text = sliderPosition.toString())
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it })
    }
}


@Preview
@Composable
fun SliderExample2() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Text(text = sliderPosition.toString())
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
            steps = 5
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SliderExample3() {
    var sliderPosition by remember { mutableStateOf(0f) }
    val interactionSource = MutableInteractionSource()
    val colors = SliderDefaults.colors(thumbColor = Color.Red, activeTrackColor = Color.Red)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = sliderPosition.toString(),fontSize = sliderPosition.sp)
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
            interactionSource = interactionSource,
            thumb = {
                SliderDefaults.Thumb(
                    interactionSource = interactionSource,
                    colors = colors
                )
            },
            track = { sliderPositions ->
                SliderDefaults.Track(
                    colors = colors,
                    sliderPositions = sliderPositions
                )
            }
        )
    }
}