package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Preview
@ExperimentalMaterial3Api
@Composable
fun FullScreenDialogExample() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        Dialog(onDismissRequest = { openDialog.value = false },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(90.dp),
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = { openDialog.value = false }) {
                        Text(text = "Закрыть")
                    }
                }
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun AlertDialogExample() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(onDismissRequest = {
            openDialog.value = false
        }) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Эта область обычно содержит вспомогательный текст в котором представлены подробности о цели диалога.",
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }, modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Подтверждать")
                    }
                }
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun AlertDialog2Example() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {

                openDialog.value = false
            },
            icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
            title = {
                Text(text = "Заголовок")
            },
            text = {
                Text(
                    text = "Эта область обычно содержит вспомогательный текст в котором представлены подробности о цели диалога.",
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Подтверждать")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Закрыть")
                }
            }
        )
    }
}