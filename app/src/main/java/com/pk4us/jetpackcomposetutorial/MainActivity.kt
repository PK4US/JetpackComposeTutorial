package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Actions()
            }
        }
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun Actions() {
    Column {
        Row {
            Buttons()
            Spacer(modifier = Modifier.padding(10.dp))
            FloatingActionButtons()
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row {
            ExtendedFABs()
            Spacer(modifier = Modifier.padding(10.dp))
            IconButtons()
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun Buttons() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //1. Elevated button
        ElevatedButton(onClick = { /* Do something! */ }) { Text("Elevated Button") }

        //2. Filled button
        Button(onClick = { /* Do something! */ }) { Text("Filled Button") }

        //3. FilledTonalButton
        FilledTonalButton(onClick = { /* Do something! */ }) { Text("Filled Tonal Button") }

        //4. Outlined button
        OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }

        //5. Text button
        TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }

    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun FloatingActionButtons() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //1. FAB
        FloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(Icons.Filled.Add, "Localized description")
        }

        //2. Small FAB
        SmallFloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Localized description",
            )
        }

        //3. Large FAB
        LargeFloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Localized description",
                modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize)
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ExtendedFABs() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //1. Extended FAB with both icon and label text
        ExtendedFloatingActionButton(
            onClick = { /* do something */ },
            icon = { Icon(Icons.Filled.Add, "Localized description") },
            text = { Text(text = "Extended FAB") },
        )

        //2. Extended FAB without icon
        ExtendedFloatingActionButton(onClick = { /* do something */ }) {
            Text(text = "Extended FAB")
        }
    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun IconButtons() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            //1. Standard icon button
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }

            var checked by remember { mutableStateOf(false) }
            IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                if (checked) {
                    Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                } else {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
            }
        }

        Row {
            //2. Contained icon button (including filled, filled tonal, and outlined styles)
            var checked by remember { mutableStateOf(false) }
            var checked2 by remember { mutableStateOf(false) }

            FilledIconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }

            FilledIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                if (checked) {
                    Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                } else {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
            }

            FilledTonalIconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }

            FilledTonalIconToggleButton(checked = checked2, onCheckedChange = { checked2 = it }) {
                if (checked2) {
                    Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                } else {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
            }
        }


        Row {
            var checked by remember { mutableStateOf(false) }

            OutlinedIconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }

            OutlinedIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                if (checked) {
                    Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                } else {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")

                }
            }
        }
    }
}