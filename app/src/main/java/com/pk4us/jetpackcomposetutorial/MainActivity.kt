package com.pk4us.jetpackcomposetutorial

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(
                    32.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonCount()
                ButtonDisable()
                ButtonNoRipple()
            }
        }
    }
}


@Preview
@Composable
fun ButtonCount(
) {
    var clickCount by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .background(
                color = Color.Blue,
                shape = RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp)
            )
            .clip(RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp))
            .clickable {
                clickCount++
            }
            .padding(PaddingValues(horizontal = 80.dp, vertical = 30.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Click $clickCount",
        )
    }
}

@Preview
@Composable
fun ButtonDisable() {
    var enabled by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .background(
                color = if (enabled) Color.Green else Color.Gray,
                shape = RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp)
            )
            .clip(RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp))
            .clickable(enabled = enabled) { enabled = false }
            .padding(PaddingValues(horizontal = 80.dp, vertical = 30.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (enabled) "Disable Me!" else "I'm Disabled!",
        )
    }
}

@Preview
@Composable
fun ButtonNoRipple(
    context: Context = LocalContext.current.applicationContext
) {
    // To disable ripple effect
    val interactionSource = MutableInteractionSource()
    Box(
        modifier = Modifier
            .background(
                color = Color.Magenta,
                shape = RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp)
            )
            .clip(RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp))
            .clickable(indication = null, interactionSource = interactionSource) {
                Toast
                    .makeText(context, "No Ripple", Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(PaddingValues(horizontal = 80.dp, vertical = 30.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No touch",
        )
    }
}