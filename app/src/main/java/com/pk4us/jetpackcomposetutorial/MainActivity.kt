package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Preview
@Composable
fun TopBar() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Top App Bar") }) },
        content = { Text("Content") })
}

//--------------------------------------------------------------------------------------------------

@Preview
@Composable
fun BottomBar() {
    Scaffold(
        content = { Text("Content") },
        bottomBar = { BottomAppBar() { Text("Bottom App Bar") } })
}

//--------------------------------------------------------------------------------------------------

@Preview
@Composable
fun FloatingButton() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "fab icon"
                )
            }
        },
        content = { Text("Content") },
    )
}

//--------------------------------------------------------------------------------------------------

@Preview
@Composable
fun Drawer() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButtonPosition = FabPosition.End,
        drawerContent = { Text(text = "Drawer Menu 1") },
        content = { Text("Content") },
    )
}

//--------------------------------------------------------------------------------------------------

@Preview
@Composable
fun ScaffoldSample() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Top App Bar") },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
            }
        },
        drawerContent = { Text(text = "Drawer Menu 1") },
        content = { Text("Content") },
        bottomBar = { BottomAppBar(backgroundColor = MaterialTheme.colors.primary) { Text("Bottom App Bar") } }
    )
}

//--------------------------------------------------------------------------------------------------

@Preview
@Composable
fun ScaffoldWithTopBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Top App Bar") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon"
                        )
                    }
                }
            )
        },
        content = {
            Text(text = "Content of the page")
        })
}

//--------------------------------------------------------------------------------------------------

@Preview
@Composable
fun TitleCustomization() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row() {
                    Text(text = "Title 1", fontSize = 30.sp, color = Color.Red)
                    Text(text = "Title 2", fontSize = 30.sp, color = Color.White)
                }
            },
            navigationIcon = { IconButton(onClick = {}) { Icon(Icons.Filled.Home, "backIcon") } },
        )
    }, content = { Text(text = "Content of the page") })
}

//--------------------------------------------------------------------------------------------------

@Preview
@Composable
fun ScaffoldWithBottomMenu() {
    val selectedIndex = remember { mutableStateOf(0) }
    Scaffold(bottomBar = {
        BottomNavigation(elevation = 10.dp) {

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Home, "")
            },
                label = { Text(text = "Home") },
                selected = (selectedIndex.value == 0),
                onClick = {
                    selectedIndex.value = 0
                })

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Favorite, "")
            },
                label = { Text(text = "Favorite") },
                selected = (selectedIndex.value == 1),
                onClick = {
                    selectedIndex.value = 1
                })

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Person, "")
            },
                label = { Text(text = "Profile") },
                selected = (selectedIndex.value == 2),
                onClick = {
                    selectedIndex.value = 2
                })
        }
    }) {}
}
//--------------------------------------------------------------------------------------------------