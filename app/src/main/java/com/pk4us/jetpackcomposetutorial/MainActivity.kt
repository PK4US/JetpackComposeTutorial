package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.pk4us.jetpackcomposetutorial.ui.theme.MyAppTheme
import com.pk4us.jetpackcomposetutorial.ui.theme.customTitle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = remember { mutableStateOf(false) }
            if (isDarkTheme.value) {
                this.window.statusBarColor = ContextCompat.getColor(this, R.color.black)
            } else {
                this.window.statusBarColor = ContextCompat.getColor(this, R.color.purple_700)
            }
            MyAppTheme(darkTheme = isDarkTheme.value) {
                Scaffold(topBar = { ThemeAppBar(darkThemeState = isDarkTheme) }) {
                }
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun DefaultPreview() {
        Column() {
            Text(
                text = "Customized TextStyle (Body1) ",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Custom",
                style = MaterialTheme.typography.customTitle
            )
            Text(
                text = "Nexa bold",
                style = MaterialTheme.typography.subtitle1
            )//bold
            Text(
                text = "Nexa regular",
                style = MaterialTheme.typography.subtitle2
            )//regular
        }
    }
}

@Composable
fun ThemeAppBar(darkThemeState: MutableState<Boolean>) {
    TopAppBar(title = {
        Row() {
            Text(text = "Themes", modifier = Modifier.weight(8f))
            Switch(
                checked = darkThemeState.value,
                onCheckedChange = { darkThemeState.value = it },
                modifier = Modifier.weight(2f)
            )
        }
    })
}