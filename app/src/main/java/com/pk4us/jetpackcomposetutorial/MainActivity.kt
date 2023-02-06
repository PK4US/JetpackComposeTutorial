package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    BoxSizeAnimation8()
                    BoxSizeAnimation9()
                }
            }
        }
    }
}

@Composable
fun BoxSizeAnimation1() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(targetValue = 4f)
                }
            }
    )
}

@Composable
fun BoxSizeAnimation2() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = tween(
                            durationMillis = 2000,                  // продолжительность анимации в миллисекундах.
                            delayMillis = 1000,                     // вы можете отложить (или задержать) анимацию.
                            easing = FastOutLinearInEasing          // позволяет изменить скорость изменения анимации.
                            //FastOutSlowInEasing
                            //LinearOutSlowInEasing
                            //FastOutLinearEasing
                            //LinearEasing
                            //CubicBezierEasing
                        )
                    )
                }
            }
    )
}

@Composable
fun BoxSizeAnimation3() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioHighBouncy,        //определяет отскок анимации.
                            //Spring.DampingRatioNoBouncy
                            //Spring.DampingRatioLowBouncy
                            //Spring.DampingRatioMediumBouncy
                            //Spring.DampingRationHighBouncy
                            stiffness = Spring.StiffnessHigh                     //определяет, насколько быстро пружина должна двигаться к конечному значению.
                            //Spring.StiffnessHigh
                            //Spring.StiffnessMedium
                            //Spring.StiffnessMediumLow
                            //Spring.StiffnessLow
                            //Spring.StiffnessVeryLow
                        )
                    )
                }
            }
    )
}

@Composable
fun BoxSizeAnimation4() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = keyframes {
                            durationMillis = 4000
                            1f at 1000 with LinearOutSlowInEasing // 0 - 1000 ms
                            2f at 1100 with FastOutLinearInEasing // 1000 - 1100 ms
                            3f at 1200 // 1100 - 1200 ms
                            4f at 4000 // 1200 - 4000 ms
                        }
                    )
                }
            }
    )
}

@Composable
fun BoxSizeAnimation5() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = repeatable(
                            iterations = 3,                                 //сколько раз должна повторяться анимация (целочисленное значение).
                            animation = tween(durationMillis = 1000),       //это анимация, которая должна повторяться. Вы можете указать анимацию на основе продолжительности (например, tween или ключевые кадры ) .
                            repeatMode = RepeatMode.Reverse                 //должна ли анимация повторяться, начиная с начала ( RepeatMode.Restart ) или с конца ( RepeatMode.Reverse ).
                        )
                    )
                }
            }
    )
}

@Composable
fun BoxSizeAnimation6() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(durationMillis = 1000),       //это анимация, которая должна повторяться. Вы можете указать анимацию на основе продолжительности (например, tween или ключевые кадры ) .
                            repeatMode = RepeatMode.Reverse                 //должна ли анимация повторяться, начиная с начала ( RepeatMode.Restart ) или с конца ( RepeatMode.Reverse ).
                        )
                    )
                }
            }
    )
}


@Composable
fun BoxSizeAnimation7() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = snap(delayMillis = 1000)
                    )
                }
            }
    )
}

@Composable
fun BoxSizeAnimation8() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }
    val color = remember { Animatable(initialValue = Color.Red) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = color.value)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = tween(durationMillis = 2000)
                    )

                    color.animateTo(
                        targetValue = Color.Yellow,
                        animationSpec = tween(durationMillis = 2000)
                    )
                }
            }
    )
}

@Composable
fun BoxSizeAnimation9() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }
    val color = remember { Animatable(initialValue = Color.Red) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = color.value)
            .clickable {
                coroutineScope.launch {
                    launch {
                        scale.animateTo(
                            targetValue = 4f,
                            animationSpec = tween(durationMillis = 2000)
                        )
                    }

                    launch {
                        color.animateTo(
                            targetValue = Color.Yellow,
                            animationSpec = tween(durationMillis = 2000)
                        )
                    }
                }
            }
    )
}