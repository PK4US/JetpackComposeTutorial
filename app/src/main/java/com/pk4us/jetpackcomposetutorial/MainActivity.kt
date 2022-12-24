package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleRow()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleRow() {
    Row {
        Text(text = "Row Text 1", Modifier.background(Color.Red))
        Text(text = "Row Text 2", Modifier.background(Color.Yellow))
        Text(text = "Row Text 3", Modifier.background(Color.Green))
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleColumn() {
    Column {
        Text(text = "Column Text 1", Modifier.background(Color.Red))
        Text(text = "Column Text 2", Modifier.background(Color.Yellow))
        Text(text = "Column Text 3", Modifier.background(Color.Green))
    }
}

@Preview
@Composable
fun RowArrangement() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Text 1", Modifier.background(Color.Red))
        Text(text = "Text 2", Modifier.background(Color.White))
        Text(text = "Text 3", Modifier.background(Color.Green))
    }
}

@Preview
@Composable
fun ColumnArrangement() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.End
    ) {
        Text(text = " Text 1", Modifier.background(Color.Red))
        Text(text = " Text 2", Modifier.background(Color.White))
        Text(text = " Text 3", Modifier.background(Color.Green))
    }
}


@Composable
fun LayoutContainer() {
    Column {
        Text(
            text = "Simple Row Example ",
            modifier = Modifier.padding(top = 10.dp),
            fontSize = 30.sp
        )
        SimpleRow()

        Text(
            text = "Simple Column Example ",
            modifier = Modifier.padding(top = 30.dp),
            fontSize = 30.sp
        )
        SimpleColumn()

        RowArrangement()

        ColumnArrangement()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LayoutPreview() {
    LayoutContainer()
}