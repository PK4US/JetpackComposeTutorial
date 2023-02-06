package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Row(
                    Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MyUI4()
                }
            }
        }
    }
}

@Composable
fun MyUI1() {
    var size by remember { mutableStateOf(1f) }
    val animateScale by animateFloatAsState(targetValue = size)

    Box(
        modifier = Modifier
            .scale(scale = animateScale)
            .size(size = 50.dp)
            .background(color = Color.Red)
            .clickable {
                size = if (size == 2f) 1f else 2f
            }
    ) {

    }
}

@Composable
fun MyUI2() {
    var size by remember { mutableStateOf(1f) }
    val animateScale by animateFloatAsState(targetValue = size, animationSpec = tween(durationMillis = 3000))

    Box(
        modifier = Modifier
            .scale(scale = animateScale)
            .size(size = 50.dp)
            .background(color = Color.Red)
            .clickable {
                size = if (size == 2f) 1f else 2f
            }
    ) {
    }
}

@Composable
fun MyUI3() {
    var color by remember { mutableStateOf(Color.Red) }
    val animateColor by animateColorAsState(targetValue = color, animationSpec = tween(durationMillis = 3000))

    Box(
        modifier = Modifier
            .size(size = 100.dp)
            .background(color = animateColor)
            .clickable {
                color = if (color == Color.Red) Color.Yellow else Color.Red
            }
    ) {
    }
}

@Composable
fun MyUI4() {
    var sizeDp by remember { mutableStateOf(50.dp) }
    val animateSize by animateDpAsState(targetValue = sizeDp, animationSpec = tween(durationMillis = 3000))

    Box(
        modifier = Modifier
            .size(size = animateSize)
            .background(color = Color.Red)
            .clickable {
                sizeDp = if (sizeDp == 50.dp) 100.dp else 50.dp
            }
    ) {
    }
}