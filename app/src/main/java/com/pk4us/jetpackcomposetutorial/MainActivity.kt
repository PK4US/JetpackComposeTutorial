package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray),
                verticalArrangement = Arrangement.spacedBy(
                    32.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoadingAnimation1()
                LoadingAnimation2()
                LoadingAnimation3()
                LoadingAnimation()
            }
        }
    }
}

@Preview
@Composable
fun LoadingAnimation1() {

    // circle's scale state
    var circleScale by remember {
        mutableStateOf(0f)
    }

    // animation
    val circleScaleAnimate = animateFloatAsState(
        targetValue = circleScale,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000
            )
        )
    )

    // This is called when the app is launched
    LaunchedEffect(Unit) {
        circleScale = 1f
    }

    // animating circle
    Box(
        modifier = Modifier
            .size(size = 64.dp)
            .scale(scale = circleScaleAnimate.value)
            .border(
                width = 4.dp,
                color = Color.Magenta.copy(alpha = 1 - circleScaleAnimate.value),
                shape = CircleShape
            )
    ) {

    }
}

@Preview
@Composable
fun LoadingAnimation2() {

    // 3 circles
    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(Unit) {
            // Используем задержку сопрограммы для синхронизации анимации
            // делим задержку анимации на количество кругов
            delay(timeMillis = (1500 / 3L) * (index + 1))

            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1500,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    // outer circle
    Box(
        modifier = Modifier
            .size(size = 200.dp)
            .background(color = Color.Transparent)
    ) {
        // animating circles
        circles.forEachIndexed { index, animatable ->
            Box(
                modifier = Modifier
                    .scale(scale = animatable.value)
                    .size(size = 200.dp)
                    .clip(shape = CircleShape)
                    .background(
                        color = Color.Magenta
                            .copy(alpha = (1 - animatable.value))
                    )
            ) {
            }
        }
    }
}

@Preview
@Composable
fun LoadingAnimation3() {

    // 3 circles
    val circles = listOf(
        remember { Animatable(initialValue = 0.3f) },
        remember { Animatable(initialValue = 0.3f) },
        remember { Animatable(initialValue = 0.3f) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(Unit) {
            // Use coroutine delay to sync animations
            delay(timeMillis = (400 / circles.size).toLong() * index)

            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 400
                    ),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
    }

    // container for circles
    Row(
        modifier = Modifier
        //.border(width = 2.dp, color = Color.Magenta)
    ) {

        // adding each circle
        circles.forEachIndexed { index, animatable ->

            // gap between the circles
            if (index != 0) {
                Spacer(modifier = Modifier.width(width = 6.dp))
            }

            Box(
                modifier = Modifier
                    .size(size = 24.dp)
                    .clip(shape = CircleShape)
                    .background(
                        color = Color.Magenta
                            .copy(alpha = animatable.value)
                    )
            ) {
            }
        }
    }
}

@Preview
@Composable
fun LoadingAnimation() {
    val infiniteTransition = rememberInfiniteTransition()
    val rotateAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 360,
                easing = LinearEasing
            )
        )
    )

    CircularProgressIndicator(
        modifier = Modifier
            .size(size = 70.dp)
            .rotate(degrees = rotateAnimation)
            .border(
                width = 2.dp,
                brush = Brush.sweepGradient(
                    listOf(
                        Color(0xFF5851D8),
                        Color(0xFF833AB4),
                        Color(0xFFC13584),
                        Color(0xFFE1306C),
                        Color(0xFFFD1D1D),
                        Color(0xFFF56040),
                        Color(0xFFF77737),
                        Color(0xFFFCAF45),
                        Color(0xFFFFDC80),
                        Color(0xFF5851D8)
                    )
                ),
                shape = CircleShape
            ),
        progress = 1f,
        strokeWidth = 1.dp,
        color = MaterialTheme.colors.background // Set background color
    )
}