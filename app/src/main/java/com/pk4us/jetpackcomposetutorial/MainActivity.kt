package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                // Gap between children = 26 dp
                verticalArrangement = Arrangement.spacedBy(26.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GradientButton()
                GradientButtonDisable()
                GradientButtonNoRipple()
            }
        }
    }
}

@Preview
@Composable
private fun GradientButton(
) {
    val gradientColors = listOf(Color(0xFFFFF000), Color(0xFFFF0000))
    var clickCount by remember {
        mutableStateOf(0)
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = { clickCount++ },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = RoundedCornerShape(16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(colors = gradientColors),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Click $clickCount",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun GradientButtonDisable(
    disabledColors: List<Color> = listOf(Color.Transparent, Color.Transparent)
) {
    val gradientColors = listOf(Color(0xFFFFF000), Color(0xFFFF0000))
    var enabled by remember { mutableStateOf(true) }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = {
            enabled = false
        },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        enabled = enabled,
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(colors = if (enabled) gradientColors else disabledColors),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (enabled) "Disable Me" else "I'm Disabled!",
                fontSize = 20.sp,
                color = if (enabled) Color.White else Color.Black.copy(alpha = 0.6F)
            )
        }
    }
}


@Preview
@Composable
private fun GradientButtonNoRipple(
) {
    val gradientColors = listOf(Color(0xFFFFF000), Color(0xFFFF0000))

    // This is used to disable the ripple effect
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
            .background(
                brush = Brush.linearGradient(colors = gradientColors),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(
                indication = null, // Assign null to disable the ripple effect
                interactionSource = interactionSource
            ) {},
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No Ripple",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}