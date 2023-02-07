package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Column {
                    MyAnim1()
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
private fun MyAnim1() {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        var visible by remember { mutableStateOf(true) }
        val visibleState = remember {
            MutableTransitionState(false).apply {
                targetState = true // start the animation immediately
            }
        }

        Box(modifier = Modifier.align(Alignment.TopStart)) {
            if (visible) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }

        }

        Box(modifier = Modifier.align(Alignment.TopCenter)) {
            AnimatedVisibility(visible) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
        }

        Box(modifier = Modifier.align(Alignment.TopEnd)) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .size(size = 120.dp)
                            .clip(shape = CircleShape)
                            .animateEnterExit(
                                enter = expandVertically(),
                                exit = shrinkHorizontally()
                            ),
                        painter = painterResource(id = R.drawable.dog),
                        contentDescription = "Dog",
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .animateEnterExit(
                                enter = slideInHorizontally(),
                                exit = slideOutHorizontally()
                            ),
                        text = "Frankie"
                    )
                }
            }
        }

        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                // this: AnimatedVisibilityScope
                // Use AnimatedVisibilityScope#transition to add a custom animation

                val backgroundColor by transition.animateColor(label = "ColorAnimation") { enterExistState ->
                    if (enterExistState == EnterExitState.Visible) Color.Green else Color.Yellow
                }

                Box(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .background(color = backgroundColor)
                )
            }
        }

        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(
                    visibleState = visibleState,
                    enter = fadeIn() + slideInHorizontally(),
                    exit = fadeOut() + slideOutHorizontally()
                ) {
                    Image(
                        modifier = Modifier
                            .size(size = 120.dp)
                            .clip(shape = CircleShape),
                        painter = painterResource(id = R.drawable.dog),
                        contentDescription = "Dog",
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = when {
                        visibleState.isIdle && visibleState.currentState -> "Visible" // enter transition is completed
                        !visibleState.isIdle && visibleState.currentState -> "Disappearing" // exit transition is running
                        visibleState.isIdle && !visibleState.currentState -> "Invisible" // exit transition is completed
                        else -> "Appearing" // enter transition is running
                    }
                )
            }
        }

        Box(modifier = Modifier.align(Alignment.Center)) {
            Column {
                Button(
                    onClick = { visible = !visible },
                    content = { Text(text = "Toggle Visibility") }
                )
                Button(
                    onClick = { visibleState.targetState = !visibleState.targetState },
                    content = { Text(text = "Toggle Visibility") }
                )
            }

        }
    }
}

//_________________________________________________________________________________________________________________________

@Preview
@ExperimentalAnimationApi
@Composable
private fun MyAnim2() {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        var visible by remember { mutableStateOf(true) }

        Box(modifier = Modifier.align(Alignment.TopStart)) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "fade")
        }

        Box(modifier = Modifier.align(Alignment.TopCenter)) {
            AnimatedVisibility(
                visible = visible,
                enter = slideInHorizontally(),
                exit = slideOutHorizontally()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "slideHorizontally")
        }

        Box(modifier = Modifier.align(Alignment.TopEnd)) {
            AnimatedVisibility(
                visible = visible,
                enter = slideInVertically(),
                exit = slideOutVertically()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "slideVertically")
        }

        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            AnimatedVisibility(
                visible = visible,
                enter = scaleIn(),
                exit = scaleOut()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "scale")
        }

        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            AnimatedVisibility(
                visible = visible,
                enter = expandIn(),
                exit = shrinkOut()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "expand")
        }

        Box(modifier = Modifier.align(Alignment.BottomStart)) {
            AnimatedVisibility(
                visible = visible,
                enter = expandHorizontally(),
                exit = shrinkHorizontally()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "expandHorizontally")
        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            AnimatedVisibility(
                visible = visible,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "expandVertically")
        }

        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = { visible = !visible },
            content = { Text(text = "Click") }
        )
    }
}