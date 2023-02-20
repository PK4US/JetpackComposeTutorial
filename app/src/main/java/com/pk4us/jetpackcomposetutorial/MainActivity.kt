package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Column {
                    Row() {
                        MyUI1()
                        MyUI2()
                        MyUI3()
                        MyUI4()

                    }
                    Row() {
                        MyUI5()
                    }
                    Row() {
                        MyUI6()
                    }
                }

            }
        }
    }
}

@Composable
fun MyUI1() {

    var count by remember {
        mutableStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "$count", fontSize = 20.sp)

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                count++
            }
        ) {
            Text(text = "+")
        }
    }
}

@Preview
@ExperimentalAnimationApi
@Composable
fun MyUI2() {
    var count by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedContent(targetState = count) { targetState ->
            Text(text = "$targetState", fontSize = 20.sp)
        }

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                count++
            }
        ) {
            Text(text = "+")
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun MyUI3() {
    var count by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedContent(
            targetState = count,
            transitionSpec = {
                fadeIn() with fadeOut()
            }
        ) { targetCount ->
            Text(
                text = "$targetCount",
                fontSize = 20.sp
            )
        }

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                count++
            }
        ) {
            Text(text = "+")
        }
    }
}


@ExperimentalAnimationApi
@Composable
fun MyUI4() {
    var count by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedContent(
            targetState = count,
            transitionSpec = {
                EnterTransition.None with ExitTransition.None
            }
        ) { targetCount ->
            Text(
                modifier = Modifier.animateEnterExit(
                    enter = scaleIn(),
                    exit = scaleOut()
                ),
                text = "$targetCount",
                fontSize = 20.sp
            )
        }

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                count++
            }
        ) {
            Text(text = "+")
        }
    }
}

@Composable
fun MyUI5() {

    val smallText = "Hello"
    val largeText = "Hello Android"

    var text by remember {
        mutableStateOf(smallText)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .animateContentSize()
                .background(color = Color.Yellow)
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable {
                    text = if (text == smallText) {
                        largeText
                    } else {
                        smallText
                    }
                },
            text = text,
            fontSize = 20.sp
        )
    }
}

@Composable
fun MyUI6() {

    val smallText = "Hello"
    val largeText =
        "Hello Android Hello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello Android"

    var text by remember {
        mutableStateOf(smallText)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = tween(durationMillis = 2000)
                )
                .background(color = Color.Yellow)
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable {
                    text = if (text == smallText) {
                        largeText
                    } else {
                        smallText
                    }
                },
            text = text,
            fontSize = 20.sp
        )
    }
}
