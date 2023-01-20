package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.*
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                CustomTabsWithScroll()
            }
        }
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun TabExampleWithText() {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Tab 1", "Tab 2", "Tab 3")
    Column {
        TabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                )
            }
        }
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Text tab ${state + 1} selected",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun CustomTabs() {
    var selectedIndex by remember { mutableStateOf(0) }
    val list = listOf("Active", "Completed")

    TabRow(selectedTabIndex = selectedIndex,
        containerColor = Color(0xff1E76DA),
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(50))
            .padding(1.dp),
        indicator = { tabPositions: List<TabPosition> ->
            Box {}
        }
    ) {
        list.forEachIndexed { index, text ->
            val selected = selectedIndex == index
            Tab(
                modifier = if (selected) Modifier
                    .clip(RoundedCornerShape(50))
                    .background(
                        Color.White
                    )
                else Modifier
                    .clip(RoundedCornerShape(50))
                    .background(
                        Color(
                            0xff1E76DA
                        )
                    ),
                selected = selected,
                onClick = { selectedIndex = index },
                text = { Text(text = text, color = Color(0xff6FAAEE)) })

        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Preview
@ExperimentalMaterial3Api
@Composable
fun CustomTabsWithScroll() {
    var selectedIndex by remember { mutableStateOf(0) }
    val tabList = listOf("Tab 1", "Tab 2", "Tab 3")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    Column(
    ) {
        TabRow(selectedTabIndex = selectedIndex,
            containerColor = Color(0xff1E76DA),
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .clip(RoundedCornerShape(50))
                .padding(1.dp),
            indicator = { tabPositions: List<TabPosition> ->
                Box {}
            }
        ) {
            tabList.forEachIndexed { index, text ->
                val selected = selectedIndex == index
                Tab(
                    modifier = if (selected) Modifier
                        .clip(RoundedCornerShape(50))
                        .background(
                            Color.White
                        )
                    else Modifier
                        .clip(RoundedCornerShape(50))
                        .background(
                            Color(
                                0xff1E76DA
                            )
                        ),
                    selected = selected,
                    onClick = { selectedIndex = index },
                    text = { Text(text = text, color = Color(0xff6FAAEE)) })

            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) {
            Text(
                text = "Text tab ${tabIndex + 1} selected",
                fontSize = 30.sp,
            )
        }
    }
}

@Preview
@OptIn(ExperimentalPagerApi::class)
@ExperimentalMaterial3Api
@Composable
fun TabLayoutWithScroll() {
    val tabList = listOf("Tab 1", "Tab 2", "Tab 3")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
    ) {
        TabRow(
            selectedTabIndex = tabIndex
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = text)
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) {
            Text(
                text = "Text tab ${tabIndex + 1} selected",
                fontSize = 30.sp,
            )
        }
    }
}


@Preview
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabBar() {
    val pagerState = rememberPagerState()
    val pages = listOf("kotlin", "java", "c#", "php", "golang", "rust")
    val defaultIndicator = @Composable { _: List<TabPosition> ->
        TabRowDefaults.Indicator(

        )
    }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    ScrollableTabRow(
        modifier = Modifier.height(50.dp),
        selectedTabIndex = pagerState.currentPage,
        indicator = indicator
    ) {
        pages.forEachIndexed { index, title ->
            Tab(
                modifier = Modifier.zIndex(6f),
                text = { Text(text = title) },
                selected = pagerState.currentPage == index,
                onClick = { /* TODO */ },
            )
        }
    }

    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        count = pages.size,
        state = pagerState,
    ) { page ->
        Box(Modifier.fillMaxSize()) {
            Text(modifier = Modifier.align(Alignment.Center), text = "Page $page")
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage, label = "")
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .background(color = Color(0xFFFF7455), RoundedCornerShape(50))
            .border(BorderStroke(2.dp, Color(0xFFC13D25)), RoundedCornerShape(50))
            .zIndex(1f)
    )
}

