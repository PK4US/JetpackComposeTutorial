package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDecoration.Companion.LineThrough
import androidx.compose.ui.text.style.TextDecoration.Companion.Underline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Preview
@Composable
fun Text() {
    Text(
        text = "Hello World",
        style = TextStyle(
            color = Color.Red,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W800,
            fontStyle = Italic,
            letterSpacing = 0.5.em,
            background = Color.LightGray,
            textDecoration = Underline
        )
    )
}


@Preview
@Composable
fun TextColor() {
    Text(
        text = "Text with Color",
        style = TextStyle(color = Color.Red)
    )

}

@Preview
@Composable
fun BackgroundColor() {
    Text(
        text = "Text with Background Color",
        style = TextStyle(background = Color.Yellow)
    )
}


@Preview
@Composable
fun Shadow() {
    Text(
        text = "Text with Shadow",
        style = TextStyle(
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(5f, 5f),
                blurRadius = 5f
            )
        )
    )
}


@Preview
@Composable
fun FontFamily() {
    Text(
        text = "Text with custom font",
        style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Cursive)
    )
}


@Preview
@Composable
fun FontSize() {
    Text(
        text = "Text with big font size",
        style = TextStyle(fontSize = 30.sp)
    )
}


@Preview
@Composable
fun FontStyle() {
    Text(
        text = "Text with Italic text",
        style = TextStyle(fontSize = 20.sp, fontStyle = Italic)
    )
}


@Preview
@Composable
fun TextDecorationUnderline() {
    Text(
        text = "Text with Underline",
        style = TextStyle(
            color = Color.Black, fontSize = 24.sp,
            textDecoration = Underline
        )
    )
}


@Preview
@Composable
fun TextDecorationLineThrough() {
    Text(
        text = "Text with Strike",
        style = TextStyle(
            color = Color.Blue, fontSize = 24.sp,
            textDecoration = LineThrough
        )
    )
}


@Preview
@Composable
fun TextHeadingStyle() {
    Column() {

        Text(
            text = "Heading 1",
            style = MaterialTheme.typography.h1
        )
        Text(
            text = "Heading 2",
            style = MaterialTheme.typography.h2
        )
        Text(
            text = "Heading 3",
            style = MaterialTheme.typography.h3
        )
        Text(
            text = "Heading 4",
            style = MaterialTheme.typography.h4
        )
        Text(
            text = "Heading 5",
            style = MaterialTheme.typography.h5
        )
        Text(
            text = "Heading 6",
            style = MaterialTheme.typography.h6
        )
        Text(
            text = "subtitle 1",
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "subtitle 2",
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = "body 1",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "body 2",
            style = MaterialTheme.typography.body2
        )
        Text(
            text = "button",
            style = MaterialTheme.typography.button
        )
        Text(
            text = "caption",
            style = MaterialTheme.typography.caption
        )
        Text(
            text = "overline",
            style = MaterialTheme.typography.overline
        )
    }
}
