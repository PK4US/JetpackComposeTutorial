package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        MyUI1()
                        MyUI2()
                    }
                }
            }
        }
    }
}

//___________
//    implementation "androidx.compose.material:material-icons-extended:1.3.1"
//___________


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyUI1() {

    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    TextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        label = { Text("Пароль") },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                // Please provide localized description for accessibility services
                val description = if (passwordHidden) "Show password" else "Hide password"
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )
}


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyUI2() {

    var value by remember { mutableStateOf("") }
    var isUserBelow18 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column {

            TextField(
                value = value,
                onValueChange = { newText ->
                    value = newText
                    isUserBelow18 = false
                },
                label = { Text(text = "Возраст") },
                placeholder = { Text(text = "Введите свой возраст") },
                isError = isUserBelow18,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // validate here
                        isUserBelow18 = validateAge(inputText = value)
                    }
                )
            )

            if (isUserBelow18) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "Вам должно быть 18+",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

private fun validateAge(inputText: String): Boolean {
    return inputText.toInt() < 18
}