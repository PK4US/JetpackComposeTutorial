package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme
import com.pk4us.jetpackcomposetutorial.ui.theme.Violet30
import com.pk4us.jetpackcomposetutorial.ui.theme.Violet80
import com.pk4us.jetpackcomposetutorial.ui.theme.Violet90
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {

            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun BottomSheets1() {
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val sheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = sheetScaffoldState,
        sheetElevation = 0.dp,
        sheetBackgroundColor = Color.Transparent,
        sheetPeekHeight = 50.dp,
        sheetContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = {
                    scope.launch {
                        if (sheetState.isCollapsed) {
                            sheetState.expand()
                        } else if (sheetState.isExpanded) {
                            sheetState.collapse()
                        }
                    }
                }) {
                    Icon(
                        imageVector = if (sheetState.isExpanded) {
                            Icons.Filled.KeyboardArrowDown
                        } else {
                            Icons.Filled.KeyboardArrowUp
                        },
                        contentDescription = "Icon button"
                    )
                }
                Surface(
                    modifier = Modifier.height(300.dp),
                    color = Color(0xff9c7ca5)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Нижний модальный лист",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(10.dp),
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Divider(modifier = Modifier.padding(5.dp), color = Color.White)
                        Text(
                            text = "Модальные нижние листы представляют собой набор вариантов, блокируя взаимодействие с остальной частью экрана. Они являются альтернативой встроенным меню и простым диалоговым окнам на мобильных устройствах, предоставляя дополнительное пространство для контента, значков и действий.",
                            fontSize = 15.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.White,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }) {
    }
}


@ExperimentalMaterialApi
@Preview
@Composable
fun BottomSheets2() {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Bottom sheet",
                    fontSize = 60.sp
                )
            }
        },
        sheetBackgroundColor = Color.White,
        sheetPeekHeight = 0.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                scope.launch {
                    if (sheetState.isCollapsed) {
                        sheetState.expand()
                    } else {
                        sheetState.collapse()
                    }
                }
            }) {
                Text(text = "Bottom sheet fraction: ${sheetState.progress.fraction}")
            }
        }
    }
}


@ExperimentalMaterialApi
@Preview
@Composable
fun BottomSheets3() {
    val contextForToast = LocalContext.current.applicationContext
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 50.dp,
        sheetContent = {

            LazyColumn {

                // the first item that is visible
                item {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .background(color = Violet90)
                    ) {
                        Text(
                            text = "Проведите вверх, чтобы развернуть лист",
                            modifier = Modifier.align(alignment = Alignment.Center),
                            color = Color.White
                        )
                    }
                }

                // remaining items
                items(count = 10) {
                    ListItem(
                        modifier = Modifier.clickable {

                            Toast.makeText(contextForToast, "Item $it", Toast.LENGTH_SHORT)
                                .show()

                            coroutineScope.launch {
                                scaffoldState.bottomSheetState.collapse()
                            }
                        },
                        text = {
                            Text(text = "Item $it")
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.Favorite,
                                contentDescription = "Favorite",
                                tint = Violet80
                            )
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(contextForToast, "FAB Click", Toast.LENGTH_SHORT).show()
            }, contentColor = Violet30, backgroundColor = Violet90) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                )
            }
        }) {
        // app UI
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "UI", fontSize = 50.sp)
        }
    }
}