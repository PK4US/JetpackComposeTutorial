package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Purple500
import com.pk4us.jetpackcomposetutorial.ui.theme.Purple700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressBarRootView()
        }
    }
}

@Composable
@Preview
fun LinearProgressIndicator() {
    LinearProgressIndicator()
}


@Composable
@Preview
fun LinearProgressIndicator07(): Unit {
    LinearProgressIndicator(0.7f)
}


@Preview
@Composable
private fun CustomLinearProgressBar() {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .height(4.dp),
        backgroundColor = Color.LightGray,
        color = Purple500
    )
}


@Composable
@Preview
fun CircularProgressIndicator() {
    CircularProgressIndicator()
}

@Composable
@Preview
fun CircularProgressIndicator07() {
    CircularProgressIndicator(progress = 0.75f)
}


@Preview
@Composable
private fun CircularProgressAnimated() {
    val infiniteTransition = rememberInfiniteTransition()
    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 0.75f,
        animationSpec = infiniteRepeatable(animation = tween(10000))
    )
    CircularProgressIndicator(progress = progressAnimationValue)
}


@Preview
@Composable
private fun CustomCircularProgressBar() {
    CircularProgressIndicator(
        modifier = Modifier.size(40.dp),
        color = Purple500,
        strokeWidth = 4.dp)
}


@Preview(showSystemUi = true)
@Composable
private fun ProgressBarRootView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator()
        LinearProgressIndicator(0.7f)
        CustomLinearProgressBar()
        CircularProgressIndicator()
        CircularProgressIndicator(progress = 0.75f)
        CircularProgressAnimated()
        CustomCircularProgressBar()
    }
}