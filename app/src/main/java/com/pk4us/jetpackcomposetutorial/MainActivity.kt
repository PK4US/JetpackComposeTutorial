package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 4.dp),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MyUI1()
                        MyUI2()
                        MyUI3()
                        MyUI4()
                        MyUI5()
                        MyUI6()
                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun MyUI1() {
        // pass the initial value
    var sliderValue by remember { mutableStateOf(0f) }

    Slider(
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            // this is called when the user completed selecting the value
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },
        valueRange = 0f..10f
    )

    Text(text = sliderValue.toString())
}


@Preview
@Composable
private fun MyUI2() {

    var sliderValue by remember {
        mutableStateOf(0f)
    }

    Slider(
        modifier = Modifier
            .width(width = 130.dp)
            .rotate(degrees = -90f),
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            // this is called when the user completed selecting the value
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },
        valueRange = 0f..5f
    )
}


@Preview
@Composable
private fun MyUI3() {

    var sliderValue by remember {
        mutableStateOf(0f)
    }

    Slider(
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            // this is called when the user completed selecting the value
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },
        valueRange = 0f..10f,
        colors = SliderDefaults.colors(
            thumbColor = Color.Green,
            activeTrackColor = Color.Magenta
        )
    )

    Text(text = sliderValue.toString())
}


@Preview
@Composable
private fun MyUI4() {

    var sliderValue by remember {
        mutableStateOf(0f)
    }

    Slider(
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            // this is called when the user completed selecting the value
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },
        valueRange = 0f..10f,
        steps = 4
    )

    Text(text = sliderValue.toString())
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun MyUI5() {

    var sliderValues by remember {
        mutableStateOf(1f..20f) // pass the initial values
    }

    RangeSlider(
        value = sliderValues,
        onValueChange = { sliderValues_ ->
            sliderValues = sliderValues_
        },
        valueRange = 1f..20f,
        onValueChangeFinished = {
            // this is called when the user completed selecting the value
            Log.d(
                "MainActivity",
                "First: ${sliderValues.start}, Last: ${sliderValues.endInclusive}"
            )
        }
    )

    Text(text = "Start: ${sliderValues.start}, End: ${sliderValues.endInclusive}")
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun MyUI6() {

    var sliderValues by remember {
        mutableStateOf(0f..10f)
    }

    RangeSlider(
        value = sliderValues,
        onValueChange = { sliderValues_ ->
            sliderValues = sliderValues_
        },
        valueRange = 0f..10f,
        onValueChangeFinished = {
            // this is called when the user completed selecting the value
            Log.d(
                "MainActivity",
                "First: ${sliderValues.start}, Last: ${sliderValues.endInclusive}"
            )
        },
        steps = 4
    )

    Text(text = "Start: ${sliderValues.start}, End: ${sliderValues.endInclusive}")
}