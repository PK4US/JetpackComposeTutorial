package com.pk4us.jetpackcomposetutorial

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {

                    // NoState()
                    // MutableStateClick()
                    //RememberSample()
                    RememberSaveableClickCount()

                }
            }
        }
    }
}

@Composable
fun NoState() {
    var clickCount = 0
    Log.d("TAG", "NoState: create()")
    Column {
        Button(onClick = {
            clickCount++
            Log.d("TAG", "NoState: " + clickCount)
        }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}

//Not recommended. Use with remember()
@SuppressLint("UnrememberedMutableState")
@Composable
fun MutableStateClick() {
    var clickCount by mutableStateOf(0)
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}


@Composable
fun RememberSample() {
    var clickCount by remember { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}

@Composable
fun RememberSaveableClickCount() {
    val clickCount = rememberSaveable { mutableStateOf(0) }
    ClickCount(label = "Remember Savable", totalClicks = clickCount.value) {
        clickCount.value++
    }
}

@Composable
private fun ClickCount(label: String, totalClicks: Int, onClickEvent: () -> Unit) {
    val context = LocalContext.current
    Toast.makeText(context, "recomposition happened for " + label, Toast.LENGTH_SHORT).show()
    Column() {
        Button(onClick = onClickEvent) {
            Text(text = label + "\n" + totalClicks + " times clicked")
        }
        Spacer(modifier = Modifier.padding(10.dp))
    }
}