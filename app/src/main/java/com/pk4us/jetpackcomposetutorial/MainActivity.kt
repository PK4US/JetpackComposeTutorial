package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme
import com.pk4us.jetpackcomposetutorial.ui.theme.Shapes

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Column {
                    ChipExample()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ChipExample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AssistChip(onClick = { },
            label = { Text("Assist Chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            })


        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            repeat(20) { positons ->
                AssistChip(onClick = {  },
                    modifier = Modifier.padding(horizontal = 5.dp),
                    label = { Text("Chip $positons") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Settings,
                            contentDescription = "Localized description",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    })
            }
        }


        var selected by remember { mutableStateOf(false) }
        FilterChip(selected = selected,
            onClick = { selected = !selected },
            label = { Text(text = "Filter chip") },
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            })


        var selectedValue by remember { mutableStateOf(false) }
        InputChip(selected = selectedValue,
            onClick = { selectedValue = !selectedValue },
            label = { Text(text = "Input chip") },
            avatar = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            })


        SuggestionChip(onClick = { },
            label = { Text(text = "Suggestion Chip") })


        val textChipRememberOneState = remember { mutableStateOf(false) }
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    vertical = 2.dp, horizontal = 4.dp
                )
                .border(
                    width = 1.dp,
                    color = if (textChipRememberOneState.value) DarkGray else LightGray,
                    shape = Shapes.medium
                )
                .background(
                    color = if (textChipRememberOneState.value) DarkGray else Transparent,
                    shape = Shapes.medium
                )
                .clip(shape = Shapes.medium)
                .clickable {
                    textChipRememberOneState.value = (!textChipRememberOneState.value)
                }
                .padding(4.dp)) {
            Text(
                text = "Fries", color = if (textChipRememberOneState.value) White else Unspecified
            )
        }


        val textChipRememberOneState2 = remember { mutableStateOf(false) }
        val shape = CircleShape
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    vertical = 2.dp, horizontal = 4.dp
                )
                .border(
                    width = 1.dp,
                    color = if (textChipRememberOneState2.value) Color.Red else LightGray,
                    shape = shape
                )
                .background(
                    color = if (textChipRememberOneState2.value) Color.Red else Transparent,
                    shape = shape
                )
                .clip(shape = shape)
                .clickable {
                    textChipRememberOneState2.value = (!textChipRememberOneState2.value)
                }
                .padding(4.dp)) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = if (textChipRememberOneState2.value) White else Color.Red,
                contentDescription = null
            )
            Text(
                text = "Pizza", color = if (textChipRememberOneState2.value) White else Unspecified
            )
        }


        val textChipRememberOneState3 = remember { mutableStateOf(false) }
        val shape2 = RoundedCornerShape(8.dp)
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    vertical = 2.dp, horizontal = 4.dp
                )
                .border(
                    width = 1.dp, color = LightGray, shape = shape2
                )
                .background(
                    color = LightGray, shape = shape2
                )
                .clip(shape = shape2)
                .clickable {
                    textChipRememberOneState3.value = (!textChipRememberOneState3.value)
                }
                .padding(4.dp)) {
            if (textChipRememberOneState3.value) {
                Icon(
                    imageVector = Icons.Filled.Done, tint = DarkGray, contentDescription = null
                )
            }
            Text(
                text = "Pizza", color = Unspecified
            )
        }


        val textChipRememberOneState4 = remember { mutableStateOf(false) }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    vertical = 1.dp,
                    horizontal = 2.dp
                )
                .border(
                    width = 1.dp,
                    color = if (textChipRememberOneState4.value) Color.Blue else LightGray,
                    shape = Shapes.small
                )
                .background(
                    color = if (textChipRememberOneState4.value) Color.Blue else Transparent,
                    shape = Shapes.small
                )
                .clip(shape = Shapes.small)
                .clickable {
                    textChipRememberOneState4.value = (!textChipRememberOneState4.value)
                }
                .padding(2.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = if (textChipRememberOneState4.value) White else Color.Blue,
                contentDescription = null
            )
        }
    }
}