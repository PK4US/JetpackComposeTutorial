package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

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
                            .fillMaxSize()
                    ) {
                        MyUI1()
                        MyUI2()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MyUI1() {

    val contextForToast = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()) {

        FloatingActionButton(
            modifier = Modifier
                .padding(all = 16.dp)
                .align(alignment = Alignment.BottomEnd),
            onClick = {
                Toast.makeText(contextForToast, "Click", Toast.LENGTH_SHORT)
                    .show()
            }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }
    }
}

@Preview
@Composable
fun MyUI2() {
    val contextForToast = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()) {

        ExtendedFloatingActionButton(
            modifier = Modifier
                .padding(all = 16.dp)
                .align(alignment = Alignment.BottomEnd),
            onClick = {
                Toast.makeText(contextForToast, "Click", Toast.LENGTH_SHORT)
                    .show()
            },
            text = { Text(text = "Add") },
            icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "Add") })
    }
}