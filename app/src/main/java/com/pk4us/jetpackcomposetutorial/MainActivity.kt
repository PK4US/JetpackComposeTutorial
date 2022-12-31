package com.pk4us.jetpackcomposetutorial

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Preview
@Composable
fun NoState() {
    var clickCount = 0
    Log.d("TAG", "NoState: create()")
    Column {
        Button(onClick = {
            clickCount++
            Log.d("TAG", "NoState: " + clickCount)
        }) {
            Text(text = "$clickCount times clicked")
        }
    }
}


@Preview
//Not recommended. Use with remember()
@SuppressLint("UnrememberedMutableState")
@Composable
fun MutableStateClick() {
    var clickCount by mutableStateOf(0)
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "$clickCount times clicked")
        }
    }
}


@Preview
@Composable
fun RememberSample() {
    var clickCount by rememberSaveable { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "$clickCount times clicked")
        }
    }
}


@Preview
@Composable
fun RememberSaveableClickCount() {
    var clickCount by rememberSaveable { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "$clickCount times clicked")
        }
    }
}