package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
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
                        MyUI2()
                        MyUI3()
                        MyUI4()
                    }
                }
            }
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyUI1() {
    val contextForToast = LocalContext.current.applicationContext

    TopAppBar(
        title = {
            Text(text = "Заголовок")
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(contextForToast, "Нажмите значок навигации", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Значок навигации")
            }
        }
    )
}
//__________________________________________________________________________________________________
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyUI2() {
    val contextForToast = LocalContext.current.applicationContext

    TopAppBar(
        title = {
            Text(text = "Заголовок")
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(contextForToast, "Щелчок по значку «Назад»", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Назад")
            }
        }
    )
}
//__________________________________________________________________________________________________
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyUI3() {
    val contextForToast = LocalContext.current.applicationContext

    TopAppBar(
        title = {
            Text(text = "Заголовок")
        },
        actions = {
            // значок поиска
            TopAppBarActionButton(
                imageVector = Icons.Outlined.Search,
                description = "Поиск"
            ) {
                Toast.makeText(contextForToast, "Поиск", Toast.LENGTH_SHORT).show()
            }

            // значок замка
            TopAppBarActionButton(
                imageVector = Icons.Outlined.Lock,
                description = "Замок"
            ) {
                Toast.makeText(contextForToast, "Замок", Toast.LENGTH_SHORT).show()
            }
        }
    )
}
@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

//__________________________________________________________________________________________________
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyUI4() {
    val contextForToast = LocalContext.current.applicationContext
    var dropDownMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Заголовок") },
        actions = {
            // значок параметров (вертикальные точки)
            TopAppBarActionButton2(imageVector = Icons.Outlined.MoreVert, description = "Options") {
                // показать выпадающее меню
                dropDownMenuExpanded = true
            }

            // выпадающее меню
            DropdownMenu(
                expanded = dropDownMenuExpanded,
                onDismissRequest = {
                    dropDownMenuExpanded = false
                },
                //поэкспериментируйте с этими значениями, чтобы правильно расположить меню
                offset = DpOffset(x = 10.dp, y = (-60).dp)
            ) {
                // это элементы области столбца, которые добавляются вертикально

                DropdownMenuItem(text = { Text("Обновить") }, onClick = {
                    Toast.makeText(contextForToast, "Refresh Click", Toast.LENGTH_SHORT)
                        .show()
                    dropDownMenuExpanded = false
                })

                DropdownMenuItem(text = { Text("Настройки") }, onClick = {
                    Toast.makeText(contextForToast, "Settings Click", Toast.LENGTH_SHORT)
                        .show()
                    dropDownMenuExpanded = false
                })

                DropdownMenuItem(text = { Text("Отправить отзыв") }, onClick = {
                    Toast.makeText(contextForToast, "Send Feedback Click", Toast.LENGTH_SHORT)
                        .show()
                    dropDownMenuExpanded = false
                })
            }
        }
    )
}
@Composable
fun TopAppBarActionButton2(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}