package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

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
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        MyUI1()
//                        MyUI2()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MyUI1() {
    val bottomMenuItemsList = prepareBottomMenu()
    val contextForToast = LocalContext.current.applicationContext
    var selectedItem by remember { mutableStateOf("Home") }

    Box(modifier = Modifier.fillMaxSize()) {
        NavigationBar(
            modifier = Modifier.align(alignment = Alignment.BottomCenter)
        ) {
            // this is a row scope
            // all items are added horizontally

            bottomMenuItemsList.forEach { menuItem ->
                // adding each item
                NavigationBarItem(
                    selected = (selectedItem == menuItem.label),
                    onClick = {
                        selectedItem = menuItem.label
                        Toast.makeText(
                            contextForToast,
                            menuItem.label, Toast.LENGTH_SHORT
                        ).show()
                    },
                    icon = {
                        Icon(
                            imageVector = menuItem.icon,
                            contentDescription = menuItem.label
                        )
                    },
                    label = {
                        Text(text = menuItem.label)
                    },
                    enabled = true
                )
            }
        }
    }
}

private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()
    // add menu items
    bottomMenuItemsList.add(BottomMenuItem(label = "Home", icon = Icons.Filled.Home))
    bottomMenuItemsList.add(BottomMenuItem(label = "Profile", icon = Icons.Filled.Person))
    bottomMenuItemsList.add(BottomMenuItem(label = "Cart", icon = Icons.Filled.ShoppingCart))
    bottomMenuItemsList.add(BottomMenuItem(label = "Settings", icon = Icons.Filled.Settings))
    return bottomMenuItemsList
}

data class BottomMenuItem(val label: String, val icon: ImageVector)