package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.GreenGrey60
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Badge3()
            }
        }
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun Badge1() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(30.dp),
        Arrangement.SpaceAround,
        Alignment.CenterVertically
    ) {
        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(text = "11")
                    },
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            }
        ) {
            Icon(
                tint = GreenGrey60,
                imageVector = Icons.Filled.Email,
                contentDescription = "Email",
                modifier = Modifier.size(45.dp)
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(text = "4")
                    },
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            }
        ) {
            Icon(
                tint = GreenGrey60,
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "ShoppingCart",
                modifier = Modifier.size(45.dp)
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(text = "8")
                    },
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            }
        ) {
            Icon(
                tint = GreenGrey60,
                imageVector = Icons.Filled.Settings,
                contentDescription = "Settings",
                modifier = Modifier.size(45.dp)
            )
        }
    }
}


@Preview
@ExperimentalMaterial3Api
@Composable
fun Badge2() {
    var count by remember { mutableStateOf(0) }
    NavigationBar {
        NavigationBarItem(icon = {
            BadgedBox(badge = {
                androidx.compose.material3.Badge {
                    val badgeNumber = count.toString()
                    Text(badgeNumber, modifier = Modifier.semantics {
                        contentDescription = "$badgeNumber new notifications"
                    })
                }
            }) {
                Icon(
                    Icons.Filled.Star, contentDescription = "Favorite"
                )
            }
        }, selected = false, onClick = { count++ })
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun Badge3() {
    var count by remember { mutableStateOf(995) }
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(30.dp),
        Arrangement.SpaceAround,
        Alignment.CenterVertically
    ) {
        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(text = count.toString())
                    },
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            }
        ) {
            FloatingActionButton(onClick = { count++ }) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    }
}