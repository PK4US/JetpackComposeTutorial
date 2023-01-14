package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircleProgress()
                LinerProgress()
            }
        }
    }
}

@Preview
@Composable
fun CircleProgress() {
    var progress by remember { mutableStateOf(0.0f) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Card(Modifier.size(width = 300.dp, height = 200.dp)) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Статус: $progress", fontSize = 22.sp)
                OutlinedButton(
                    onClick = {
                        scope.launch {
                            while (progress < 1f) {
                                progress += 0.1f
                                delay(1000L)
                            }
                        }
                    }
                ) {
                    Text("Запустить", fontSize = 22.sp)
                }
                CircularProgressIndicator(progress = progress)
            }
        }
    }
}

@Preview
@Composable
fun LinerProgress() {
    var progress by remember { mutableStateOf(0.0f) }
    val scope = rememberCoroutineScope()

    Column(
    ) {
        Card(Modifier.size(width = 300.dp, height = 200.dp)) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Статус: $progress", fontSize = 22.sp)
                OutlinedButton(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        scope.launch {
                            while (progress < 1f) {
                                progress += 0.1f
                                delay(1000L)
                            }
                        }
                    }
                ) {
                    Text("Запустить", fontSize = 22.sp)
                }
                LinearProgressIndicator(progress = progress)
            }
        }
    }
}