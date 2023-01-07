package com.pk4us.jetpackcomposetutorial

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        MyTopAppBar()
                    }
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Rest of the UI")
                    }
                }
            }
        }
    }
}

@Composable
fun MyTopAppBar(
    iconAndTextColor: Color = Color.DarkGray
) {
    val listItems = getMenuItemsList()

    val contextForToast = LocalContext.current.applicationContext

    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {
            Text(text = "SemicolonSpace")
        },
        actions = {

            // 3 vertical dots icon
            IconButton(onClick = {
                expanded = true
            }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Open Options"
                )
            }

            // drop down menu
            DropdownMenu(
                modifier = Modifier.width(width = 150.dp),
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                // adjust the position
                offset = DpOffset(x = (-102).dp, y = (-64).dp),
                properties = PopupProperties()
            ) {

                // adding each menu item
                listItems.forEach { menuItemData ->
                    DropdownMenuItem(
                        onClick = {
                            Toast.makeText(contextForToast, menuItemData.text, Toast.LENGTH_SHORT)
                                .show()
                            expanded = false
                        },
                        enabled = true
                    ) {

                        Icon(
                            imageVector = menuItemData.icon,
                            contentDescription = menuItemData.text,
                            tint = iconAndTextColor
                        )

                        Spacer(modifier = Modifier.width(width = 8.dp))

                        Text(
                            text = menuItemData.text,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = iconAndTextColor
                        )
                    }
                }
            }
        }
    )
}

fun getMenuItemsList(): ArrayList<MenuItemData> {
    val listItems = ArrayList<MenuItemData>()

    listItems.add(MenuItemData(text = "Home", icon = Icons.Outlined.Home))
    listItems.add(MenuItemData(text = "Call", icon = Icons.Outlined.Call))
    listItems.add(MenuItemData(text = "Mail", icon = Icons.Outlined.Email))
    listItems.add(MenuItemData(text = "Info", icon = Icons.Outlined.Info))

    return listItems
}

data class MenuItemData(val text: String, val icon: ImageVector)