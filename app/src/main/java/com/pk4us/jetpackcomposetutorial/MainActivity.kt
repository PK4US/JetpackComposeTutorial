package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Column {
                    MainContent()
                }
            }
        }
    }
}


@Composable
fun MainContent() {

    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {

        Text(
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.TopStart),
            text = "TopStart"
        )
        Text(
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.TopCenter),
            text = "TopCenter"
        )
        Text(
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.TopEnd),
            text = "TopEnd"
        )

        Text(
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.CenterStart),
            text = "CenterStart"
        )

        Text(
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.Center),
            text = "Center"
        )
        Text(
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.CenterEnd),
            text = "CenterEnd"
        )

        Text(
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.BottomStart),
            text = "BottomStart"
        )
        Text(
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.BottomCenter),
            text = "BottomCenter"
        )
        Text(
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .align(Alignment.BottomEnd),
            text = "BottomEnd"
        )
    }
}