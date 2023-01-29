package com.pk4us.jetpackcomposetutorial

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MainContent1()
                        MainContent2()
                    }
                }
            }
        }
    }
}


@Composable
fun MainContent1() {
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.Center
    ) {
        // * Toast Sample
        Button(
            onClick = {
                // * Toast
                Toast.makeText(
                    context,
                    "Hi i am toast",
                    Toast.LENGTH_LONG
                ).show()
            },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "Toast 1")
        }
    }
}


@Composable
fun MainContent2() {
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                // * Toast extension function
                context.showToast("Hi i am extension toast", Toast.LENGTH_LONG)
            },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "Toast 2 ")
        }
    }
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}