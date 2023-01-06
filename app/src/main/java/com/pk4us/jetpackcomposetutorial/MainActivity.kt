package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    var openDialog by remember {
                        mutableStateOf(false) // Initially dialog is closed
                    }

                    ButtonClick(buttonText = "Жмяк!") {
                        openDialog = true
                    }

                    if (openDialog) {
                        DialogBox2FA {
                            openDialog = false
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DialogBox2FA(onDismiss: () -> Unit) {
    val contextForToast = LocalContext.current.applicationContext

    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 4.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(color = Color(0xFF35898f)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 16.dp),
                        painter = painterResource(id = R.drawable.security),
                        contentDescription = "Двухэтапная проверка",
                        alignment = Alignment.Center
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                    text = "Двухэтапная проверка",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
                        fontSize = 20.sp
                    )
                )

                Text(
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    text = "Настройте двухэтапную аутентификацию, чтобы добавить дополнительные уровни безопасности вашей учетной записи.",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                        fontSize = 14.sp
                    )
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 36.dp, start = 36.dp, end = 36.dp, bottom = 8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF35898f)),
                    onClick = {
                        onDismiss()
                        Toast.makeText(
                            contextForToast,
                            "Нажмите: Настроить сейчас",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                    Text(
                        text = "Настроить сейчас",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = FontFamily(
                                Font(
                                    R.font.roboto_medium,
                                    FontWeight.Medium
                                )
                            ),
                            fontSize = 16.sp
                        )
                    )
                }

                TextButton(
                    onClick = {
                        onDismiss()
                        Toast.makeText(
                            contextForToast,
                            "Нажмите: я сделаю это позже",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                    Text(
                        text = "Я сделаю это позже",
                        color = Color(0xFF35898f),
                        style = TextStyle(
                            fontFamily = FontFamily(
                                Font(
                                    R.font.roboto_regular,
                                    FontWeight.Normal
                                )
                            ),
                            fontSize = 14.sp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonClick(
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        onClick = {
            onButtonClick()
        }) {
        Text(
            text = buttonText,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}