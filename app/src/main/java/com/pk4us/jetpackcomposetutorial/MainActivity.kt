package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                BottomSheets4()
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


data class BottomSheetItem(val title: String, val icon: ImageVector)

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun BottomSheets4() {
    val bottomSheetItems = listOf(
        BottomSheetItem(title = "Notification", icon = Icons.Default.Notifications),
        BottomSheetItem(title = "Mail", icon = Icons.Default.MailOutline),
        BottomSheetItem(title = "Scan", icon = Icons.Default.Search),
        BottomSheetItem(title = "Edit", icon = Icons.Default.Edit),
        BottomSheetItem(title = "Favorite", icon = Icons.Default.Favorite),
        BottomSheetItem(title = "Settings", icon = Icons.Default.Settings)
    )
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Column(
                content = {
                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(
                        text = "Create New",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp,
                        color = Color.White
                    )
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3)
                    ) {
                        items(bottomSheetItems.size, itemContent = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 24.dp)
                            ) {
                                Spacer(modifier = Modifier.padding(8.dp))
                                Icon(
                                    bottomSheetItems[it].icon,
                                    "",
                                    tint = Color.White
                                )
                                Spacer(modifier = Modifier.padding(8.dp))
                                Text(text = bottomSheetItems[it].title, color = Color.White)
                            }

                        })
                    }
                }, modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color(0xFF6650a4))
                    .padding(16.dp)
            )
        },
        sheetPeekHeight = 0.dp,
        topBar = {
            TopAppBar(
                title = { Text("Bottom Sheet Demo") },
                backgroundColor = Color.White,
                contentColor = Color.Blue
            )
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier
                    .padding(20.dp),
                onClick = {
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                }
            ) {
                Text(
                    text = "Click to show Bottom Sheet"
                )
            }
        }
    }
}