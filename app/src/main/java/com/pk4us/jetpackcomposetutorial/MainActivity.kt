package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonAnimation()
                Spacer(modifier = Modifier.height(height = 40.dp))
                HeartAnimation()
            }
        }

    }
}

@Preview
@Composable
fun ButtonAnimation() {
    val interactionSource = MutableInteractionSource()
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .background(
                color = Color(0xFF35898F),
                shape = RoundedCornerShape(size = 12f)
            )
            .clickable(interactionSource = interactionSource, indication = null) {
                coroutineScope.launch {
                    scale.animateTo(
                        0.9f,
                        animationSpec = tween(100),
                    )
                    scale.animateTo(
                        1f,
                        animationSpec = tween(100),
                    )
                }
            }
    ) {
        Text(
            text = "Button Animation",
            modifier = Modifier.padding(horizontal = 36.dp, vertical = 12.dp),
            fontSize = 26.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun HeartAnimation() {
    val coroutineScope = rememberCoroutineScope()
    var enabled by remember { mutableStateOf(false) }
    val scale = remember { Animatable(1f) }

    Icon(
        imageVector = Icons.Filled.Favorite,
        contentDescription = "Like the product",
        tint = if (enabled) Color.Red else Color.LightGray,
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 100.dp)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) {
                enabled = !enabled
                coroutineScope.launch {
                    scale.animateTo(
                        0.8f,
                        animationSpec = tween(100),
                    )
                    scale.animateTo(
                        1f,
                        animationSpec = tween(100),
                    )
                }
            }
    )
}