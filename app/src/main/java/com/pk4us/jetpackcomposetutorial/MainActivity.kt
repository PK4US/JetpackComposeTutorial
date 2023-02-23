package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Row {
                    MyUI1()
                    MyUI2()
                }
            }
        }
    }
}


@Composable
fun MyUI1() {
    var dialogOpen by remember { mutableStateOf(false) }

    if (dialogOpen) {
        AlertDialog(
            onDismissRequest = {
//                Закрыть диалоговое окно, когда пользователь щелкает за пределами диалогового окна или на кнопке «Назад».
//                Если вы хотите отключить эту функцию, просто оставьте этот блок пустым.
                dialogOpen = false
            },
            confirmButton = {
                Button(onClick = {
                    dialogOpen = false
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                Button(onClick = {
                    dialogOpen = false
                }) {
                    Text(text = "Dismiss")
                }
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Text(text = "Description")
            },
            modifier = Modifier // Set the width and padding
                .fillMaxWidth()
                .padding(32.dp),
            shape = RoundedCornerShape(5.dp),
            containerColor = Color.White,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }

    Button(onClick = { dialogOpen = true }) {
        Text(text = "OPEN")
    }
}

@Composable
@Preview
fun MyUI2() {

    var dialogOpen by remember {
        mutableStateOf(false)
    }

    if (dialogOpen) {
        Dialog(onDismissRequest = {
            dialogOpen = false
        }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(size = 10.dp)
            ) {
                Column(modifier = Modifier.padding(all = 16.dp)) {
                    Text(text = "Your Dialog UI Here")
                }
            }
        }
    }

    Button(onClick = { dialogOpen = true }) {
        Text(text = "OPEN")
    }
}