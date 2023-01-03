package com.pk4us.jetpackcomposetutorial

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                NormalButton()

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButtonExp()

                Spacer(modifier = Modifier.height(16.dp))

                TextButtonExp()

                Spacer(modifier = Modifier.height(16.dp))

                IconButtonExp()

                Spacer(modifier = Modifier.height(16.dp))

                IconToggleButtonExp()
            }

        }
    }
}


@Preview
@Composable
fun NormalButton() {
    var count by remember {
        mutableStateOf(0)
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = {
            count++
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = "Clicked $count time(s)",
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            )
        )
    }
}


@Preview
@Composable
fun OutlinedButtonExp() {

    var enabled by remember {
        mutableStateOf(true)
    }

    OutlinedButton(
        enabled = enabled,
        onClick = {
            enabled = false
        }
    ) {
        Text(
            text = if (enabled) "Disable Me" else "I'm Disabled",
            style = TextStyle(
                color = if (enabled) Color.Cyan else Color.LightGray,
                fontSize = 20.sp
            )
        )
    }
}


@Preview
@Composable
fun TextButtonExp(context: Context = LocalContext.current.applicationContext) {

    TextButton(
        onClick = {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
        }) {
        Text(text = "Text Button")
    }

}


@Preview
@Composable
fun IconButtonExp(context: Context = LocalContext.current.applicationContext) {

    IconButton(
        onClick = {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
        }
    ) {
        Icon(
            imageVector = Icons.Outlined.Share,
            contentDescription = "Click to share",
            tint = Color.Red
        )
    }

}


@Preview
@Composable
fun IconToggleButtonExp() {

    var checked by remember {
        mutableStateOf(false)
    }

    // This is used to disable the ripple effect
    val interactionSource = remember {
        MutableInteractionSource()
    }

    IconToggleButton(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    ) {

        val tint by animateColorAsState(
            targetValue = if (checked) Color.Magenta else Color.LightGray
        )

        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite Item",
            modifier = Modifier
                .clickable(
                    indication = null, // Assign null to disable the ripple effect
                    interactionSource = interactionSource
                ) {
                    checked = !checked
                }
                .size(48.dp),
            tint = tint
        )
    }
}