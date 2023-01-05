package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PieChart1()
            }
        }
    }
}

@Composable
fun PieChart1() {
    val sumOfValues = listOf(15f, 35f, 50f).sum() // Sum of all the values
    val proportions =
        listOf(15f, 35f, 50f).map { it * 100 / sumOfValues } // Calculate each proportion value
    val sweepAngles = proportions.map { 360 * it / 100 }// Convert each proportions to angle

    Canvas(modifier = Modifier.size(size = 200.dp)) {
        var startAngle = -90f

        for (i in sweepAngles.indices) {
            drawArc(
                color = listOf(
                    Color(0xFF58BDFF),
                    Color(0xFF125B7F),
                    Color(0xFF092D40))[i],
                startAngle = startAngle,
                sweepAngle = sweepAngles[i],
                useCenter = true
            )
            startAngle += sweepAngles[i]
        }
    }

    Spacer(modifier = Modifier.height(32.dp))

    Column {
        for (i in listOf(15f, 35f, 50f).indices) {
            DisplayLegend1(
                color = listOf(
                    Color(0xFF58BDFF),
                    Color(0xFF125B7F),
                    Color(0xFF092D40)
                )[i], legend = listOf("Mango", "Banana", "Apple")[i]
            )
        }
    }
}

@Composable
fun DisplayLegend1(color: Color, legend: String) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier.width(16.dp),
            thickness = 4.dp,
            color = color
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = legend,
            color = Color.Black
        )
    }
}