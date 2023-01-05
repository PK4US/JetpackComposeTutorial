package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ArcProgressbar()
            }
        }
    }
}

@Preview
@Composable
fun ArcProgressbar() {
    // It remembers the number value
    var dataR by remember {
        mutableStateOf(-1f)
    }

    val gapBetweenEnds = (150f - 90) * 2

    // Number Animation
    val animateNumber = animateFloatAsState(
        targetValue = dataR,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        dataR = 128f
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = 250.dp)
    ) {
        Canvas(
            modifier = Modifier
                .size(size = 250.dp)
        ) {

            // Background Arc
            drawArc(
                color = Color.LightGray.copy(alpha = 0.2f),
                startAngle = 150f,
                sweepAngle = 360f - gapBetweenEnds,
                useCenter = false,
                style = Stroke(width = 64.dp.toPx(), cap = StrokeCap.Round)
            )

            // convert the number to angle
            val sweepAngle = (animateNumber.value / 100f) * (360f - gapBetweenEnds)

            // Foreground circle
            drawArc(
                color = Color(0xFF35898f),
                startAngle = 150f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(64.dp.toPx(), cap = StrokeCap.Round)
            )
        }

        // Display the data usage value
        DisplayText(
            animateNumber = animateNumber,
            dataTextStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
                fontSize = MaterialTheme.typography.h3.fontSize),
            remainingTextStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                fontSize = 16.sp
            ))
    }

    Spacer(modifier = Modifier.height(32.dp))

    ButtonProgressbar {
        dataR = (0 until 100f.toInt()).random().toFloat()
    }
}

@Composable
private fun DisplayText(
    animateNumber: State<Float>,
    dataTextStyle: TextStyle,
    remainingTextStyle: TextStyle
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Text that shows the number inside the circle
        Text(
            text = (animateNumber.value).toInt().toString() + " GB",
            style = dataTextStyle
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Remaining",
            style = remainingTextStyle
        )
    }
}

@Composable
private fun ButtonProgressbar(
    backgroundColor: Color = Color(0xFF35898f),
    onClickButton: () -> Unit
) {
    Button(
        onClick = {
            onClickButton()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Text(
            text = "Animate with Random Value",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}