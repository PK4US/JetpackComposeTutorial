package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        MyUI1()
                        MyUI2()
                        MyUI3()
                        MyUI4()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MyUI1() {
    var switchOn by remember { mutableStateOf(false) }
    Switch(
        checked = switchOn,
        onCheckedChange = { switchOn_ ->
            switchOn = switchOn_
        }
    )
}

@Preview
@Composable
private fun MyUI2() {
    var switchOn by remember { mutableStateOf(false) }
    Switch(
        checked = switchOn,
        onCheckedChange = { switchOn_ ->
            switchOn = switchOn_
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Magenta
        )
    )
}


@Preview
@Composable
private fun MyUI3() {
    var switchOn by remember { mutableStateOf(false) }

    Switch(
        modifier = Modifier.scale(scale = 2f),
        checked = switchOn,
        onCheckedChange = { switchOn_ ->
            switchOn = switchOn_
        }
    )
}

@Preview
@Composable
private fun MyUI4() {
    var switchOn by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = switchOn,
            onCheckedChange = { switchOn_ ->
                switchOn = switchOn_
            }
        )
        Text(text = if (switchOn) "ON" else "OFF")
    }
}