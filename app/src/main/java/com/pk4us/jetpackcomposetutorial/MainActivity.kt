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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                DoughnutChart1()
            }
        }
    }
}

@Preview
@Composable
fun DoughnutChart1() {
    val sumOfValues = listOf(65f, 40f, 25f, 20f).sum()    // Sum of all the values
    val proportions = listOf(65f, 40f, 25f, 20f).map { it * 100 / sumOfValues }    // Calculate each proportion
    val sweepAngles = proportions.map { 360 * it / 100 }    // Convert each proportion to angle

    Canvas(modifier = Modifier.size(size = 200.dp)) {
        var startAngle = -90f

        for (i in listOf(65f, 40f, 25f, 20f).indices) {
            drawArc(
                color = listOf(
                    Color(0xFFFF6384),
                    Color(0xFFFFCE56),
                    Color(0xFF36A2EB),
                    Color(0xFF448AFF)
                )[i],
                startAngle = startAngle,
                sweepAngle = sweepAngles[i],
                useCenter = false,
                style = Stroke(width = 36.dp.toPx(), cap = StrokeCap.Butt)
            )
            startAngle += sweepAngles[i]
        }
    }

    Spacer(modifier = Modifier.height(32.dp))

    Column {
        for (i in listOf(65f, 40f, 25f, 20f).indices) {
            DisplayLegend(
                color = listOf(
                    Color(0xFFFF6384),
                    Color(0xFFFFCE56),
                    Color(0xFF36A2EB),
                    Color(0xFF448AFF))[i],
                legend = listOf("Mango", "Banana", "Apple", "Melon")[i]
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