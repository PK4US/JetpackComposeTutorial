package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertDialog()
        }
    }
}

@Composable
fun AlertDialog() {
    val openDialog = remember { mutableStateOf(false) }
    Button(
        onClick = { openDialog.value = true }
    ) {
        Text("Удалить", fontSize = 22.sp)
    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Подтверждение действия") },
            text = { Text("Вы действительно хотите удалить выбранный элемент?") },
            buttons = {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { openDialog.value = false }
                    ) {
                        Text("Удалить")
                    }
                    Button(
                        onClick = { openDialog.value = false }
                    ) {
                        Text("Отмена")
                    }
                }
            }
        )
    }
}