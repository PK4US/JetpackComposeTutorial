package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListExample()
                }
            }
        }
    }
}


@Composable
@Preview
@ExperimentalMaterial3Api
fun ListExample() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ListItem(
            headlineText = { Text("One line list item with 24x24 icon") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            }
        )
        Divider()
        ListItem(
            headlineText = { Text("Two line list item with trailing") },
            supportingText = { Text("Secondary text") },
            trailingContent = { Text("meta") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            }
        )
        Divider()
        ListItem(
            headlineText = { Text("Three line list item") },
            overlineText = { Text("OVERLINE") },
            supportingText = { Text("Secondary text") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            },
            trailingContent = { Text("meta") }
        )
        Divider()
    }
}