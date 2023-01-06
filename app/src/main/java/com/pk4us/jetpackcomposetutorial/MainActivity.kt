package com.pk4us.jetpackcomposetutorial

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FullScreenDialog()
            }
        }

    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FullScreenDialog(
    primaryColor: Color = Color(0xFF35898F),
    context: Context = LocalContext.current.applicationContext
) {

    // store the dialog open or close state
    var dialogOpen by remember {
        mutableStateOf(false)
    }

    if (dialogOpen) {

        Dialog(
            onDismissRequest = {
                dialogOpen = false
            },
            properties = DialogProperties(
                usePlatformDefaultWidth = false // experimental
            )
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // medal icon
                    Icon(
                        painter = painterResource(id = R.drawable.medal),
                        contentDescription = "Medal icon",
                        tint = primaryColor,
                        modifier = Modifier.size(size = 150.dp)
                    )

                    Text(
                        text = "Поздравляем!",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 26.dp),
                        fontFamily = FontFamily(
                            Font(
                                resId = R.font.roboto_bold,
                                weight = FontWeight.Bold
                            )
                        )
                    )

                    Text(
                        text = "Ты выиграл медаль",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 20.dp),
                        fontFamily = FontFamily(
                            Font(
                                resId = R.font.roboto_regular,
                                weight = FontWeight.Normal
                            )
                        )
                    )

                    Button(
                        onClick = {
                            Toast.makeText(context, "Share Button", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.padding(top = 20.dp),
                        shape = RoundedCornerShape(percent = 25),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFF35898F),
                            contentColor = Color.White
                        ),
                    ) {
                        Text(
                            text = "Поделиться",
                            fontFamily = FontFamily(
                                Font(
                                    resId = R.font.roboto_medium,
                                    weight = FontWeight.Medium
                                )
                            ),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }

    Button(onClick = {
        dialogOpen = true
    }) {
        Text(text = "OPEN DIALOG")
    }

}