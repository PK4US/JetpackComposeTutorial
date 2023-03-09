package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MyUI1()
                        MyUI2()
                        MyUI3()
                        MyUI4()
                        MyUI5()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MyUI1() {
    Row {
        Box(
            modifier = Modifier
                .size(width = 72.dp, height = 36.dp)
                .background(color = Color.Yellow)
                .clickable {
                    // handle click events
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Click Me")
        }

        Spacer(modifier = Modifier.size(30.dp))

        val interactionSource = MutableInteractionSource()
        Box(
            modifier = Modifier
                .size(width = 72.dp, height = 36.dp)
                .background(color = Color.Yellow)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    // handle click events
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Click Me")
        }
    }
}

@Preview
@Composable
fun MyUI2() {
    Row {
        var checked by remember { mutableStateOf(false) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = !checked
            }
        )

        Spacer(modifier = Modifier.size(30.dp))

        Switch(
            checked = checked,
            onCheckedChange = {
                checked = !checked
            },
            interactionSource = NoRippleInteractionSource()
        )
    }
}

class NoRippleInteractionSource : MutableInteractionSource {
    override val interactions: Flow<Interaction> = emptyFlow()
    override suspend fun emit(interaction: Interaction) {}
    override fun tryEmit(interaction: Interaction) = true
}

@Preview
@Composable
fun MyUI3() {
    Row {
        CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
            // add your composables here

            Box(
                modifier = Modifier
                    .size(width = 72.dp, height = 36.dp)
                    .background(color = Color.Yellow)
                    .clickable {
                        // handle click events
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Click Me")
            }
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified
    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

@Preview
@Composable
fun MyUI4() {
    Button(
        onClick = {
            // handle click events
        },
        interactionSource = NoRippleInteractionSource()
    ) {
        Text(text = "Click")
    }
}

@Preview
@Composable
fun MyUI5() {
    val interactionSource = MutableInteractionSource()
    Box(
        modifier = Modifier
            .size(width = 80.dp, height = 36.dp)
            .background(
                color = Color.Magenta,
                shape = RoundedCornerShape(percent = 12)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                // handle click events
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Click Me",
            color = Color.White
        )
    }
}