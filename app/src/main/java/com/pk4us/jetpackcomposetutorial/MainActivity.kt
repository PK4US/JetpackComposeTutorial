package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
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
                Row(
                    Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MyUI1()
                    MyUI2()
                    MyUI3()
                }
            }
        }
    }
}


@Preview
@Composable
fun MyUI1() {
    CircularProgressIndicator(
        progress = 0.6f,
        modifier = Modifier.size(size = 64.dp),
        color = Color.Magenta,
        strokeWidth = 6.dp
    )
}

@Preview
@Composable
fun MyUI2() {
    Column {
        // progress value
        var progress by remember {
            mutableStateOf(0f) // initially 0f
        }

        // For animation
        val progressAnimate by animateFloatAsState(
            targetValue = progress,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )

        CircularProgressIndicator(
            progress = progressAnimate,
            modifier = Modifier.size(size = 64.dp),
            color = Color.Magenta,
            strokeWidth = 6.dp
        )

        // This is called when the Activity is launched
        LaunchedEffect(Unit) {
            progress = 0.6f
        }

        // Add space between indicator and button
        Spacer(modifier = Modifier.height(height = 16.dp))

        Button(
            onClick = {
                progress = (0 until 100).random().toFloat() / 100
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        ) {
            Text(
                text = "Random",
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun MyUI3() {

    CircularProgressIndicator(
        progress = 0.6f,
        modifier = Modifier
            .size(size = 64.dp)
            .rotate(degrees = 45f),
        color = Color.Magenta,
        strokeWidth = 6.dp
    )
}