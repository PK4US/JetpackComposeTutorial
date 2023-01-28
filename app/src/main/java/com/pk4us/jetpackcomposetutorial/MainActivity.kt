package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                CardExample()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun CardExample() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Card(Modifier.size(width = 180.dp, height = 100.dp)) {
                // Card content
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = " Filled card", Modifier.align(Alignment.Center))
                }
            }

            Spacer(modifier = Modifier.size(20.dp))

            Card(
                onClick = { /* Do something */ },
                modifier = Modifier.size(width = 180.dp, height = 100.dp)
            ) {
                Box(Modifier.fillMaxSize()) {
                    Text("Clickable", Modifier.align(Alignment.Center))
                }
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row {
            ElevatedCard(Modifier.size(width = 180.dp, height = 100.dp)) {
                // Card content
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = "ElevatedCard card", Modifier.align(Alignment.Center))
                }
            }

            Spacer(modifier = Modifier.size(20.dp))

            ElevatedCard(
                onClick = { /* Do something */ },
                modifier = Modifier.size(width = 180.dp, height = 100.dp)
            ) {
                Box(Modifier.fillMaxSize()) {
                    Text("Clickable", Modifier.align(Alignment.Center))
                }
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row {
            OutlinedCard(Modifier.size(width = 180.dp, height = 100.dp)) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Outlined card", Modifier.align(Alignment.Center))
                }
            }

            Spacer(modifier = Modifier.size(20.dp))

            OutlinedCard(
                onClick = { /* Do something */ },
                modifier = Modifier.size(width = 180.dp, height = 100.dp)
            ) {
                Box(Modifier.fillMaxSize()) {
                    Text("Clickable", Modifier.align(Alignment.Center))
                }
            }
        }
    }
}