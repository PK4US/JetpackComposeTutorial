package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 24.dp, // Gap between kids = 24 dp
                    alignment = Alignment.CenterVertically
                )
            ) {
                GradientBorderButtonClick()
                GradientBorderButtonRound()
                GradientBorderButtonDisable()
            }
        }
    }
}

@Preview
@Composable
fun GradientBorderButtonClick() {
    var clickCount by remember { mutableStateOf(0) }
    // To disable ripple
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .fillMaxWidth(fraction = 0.7f)
            .border(
                width = 4.dp,
                brush = Brush.horizontalGradient(colors = listOf(Color.Yellow, Color.Red)),
                shape = RectangleShape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null // To disable ripple
            ) {
                clickCount++
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Click $clickCount",
            fontSize = 26.sp,
            modifier = Modifier.padding(PaddingValues(horizontal = 24.dp, vertical = 12.dp)),
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun GradientBorderButtonRound() {
    val context = LocalContext.current.applicationContext

    Box(
        modifier = Modifier
            .fillMaxWidth(fraction = 0.7f)
            .border(
                width = 4.dp,
                brush = Brush.horizontalGradient(colors = listOf(Color.Yellow, Color.Red)),
                shape = RoundedCornerShape(percent = 50)
            )
            // To make the ripple round
            .clip(shape = RoundedCornerShape(percent = 50))
            .clickable {
                Toast
                    .makeText(context, "Round Button Click", Toast.LENGTH_SHORT)
                    .show()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Round Button",
            fontSize = 26.sp,
            modifier = Modifier.padding(PaddingValues(horizontal = 24.dp, vertical = 12.dp)),
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview()
@Composable
fun GradientBorderButtonDisable() {
    val disabledColor = Color.Gray.copy(alpha = 0.3f)
    var enabled by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxWidth(fraction = 0.68f)
            .border(
                width = 4.dp,
                brush = Brush.horizontalGradient(
                    colors = if (enabled) listOf(Color.Yellow, Color.Red)
                    else listOf(disabledColor, disabledColor)
                ),
                shape = RectangleShape
            )
            .clickable(enabled = enabled) {
                enabled = false
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (enabled) "Disable Me" else "I'm Disabled",
            fontSize = 26.sp,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
            fontWeight = FontWeight.Medium,
            color = if (enabled) Color.Black else disabledColor
        )
    }

}