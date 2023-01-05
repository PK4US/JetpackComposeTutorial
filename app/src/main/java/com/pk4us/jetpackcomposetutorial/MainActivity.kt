package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularChart1()
            }
        }
    }
}

@Preview
@Composable
fun CircularChart1() {
    val sweepAngles = listOf(65f, 60f, 55f).map { 360 * it / 100 } // Convert each value to angle

    Canvas(modifier = Modifier.size(280.dp)) {
        var arcRadius = 280.dp.toPx()

        for (i in listOf(65f, 60f, 55f).indices) {
            arcRadius -= 42.dp.toPx()

            drawCircle(
                color = Color.LightGray.copy(alpha = 0.3f),
                radius = arcRadius / 2,
                style = Stroke(width = 16.dp.toPx(), cap = StrokeCap.Butt)
            )

            drawArc(
                color = listOf(
                    Color(0xFFbe1558),
                    Color(0xFFe75874),
                    Color(0xFFfbcbc9)
                )[i],
                startAngle = -90f,
                sweepAngle = sweepAngles[i],
                useCenter = false,
                style = Stroke(width = 16.dp.toPx(), cap = StrokeCap.Round),
                size = Size(arcRadius, arcRadius),
                topLeft = Offset(
                    x = (280.dp.toPx() - arcRadius) / 2,
                    y = (280.dp.toPx() - arcRadius) / 2
                )
            )
        }
    }

    Spacer(modifier = Modifier.height(32.dp))

    Column {
        for (i in listOf(65f, 60f, 55f).indices) {
            DisplayLegend(
                color = listOf(
                    Color(0xFFbe1558),
                    Color(0xFFe75874),
                    Color(0xFFfbcbc9)
                )[i], legend = listOf("Mango", "Apple", "Melon")[i]
            )
        }
    }
}

@Composable
fun DisplayLegend(color: Color, legend: String) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color = color, shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = legend,
            color = Color.Black
        )
    }
}