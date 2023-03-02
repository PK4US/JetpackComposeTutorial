package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Column(
                   Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally,
                   ) {
                   MyUI1()
                   MyUI2()
                   MyUI3()
               }
            }
        }
    }
}



@Preview
@Composable
fun MyUI1() {
    Icon(
        modifier = Modifier.size(size = 120.dp),
        imageVector = Icons.Default.Person,
        contentDescription = "Person Icon",
        tint = Color.LightGray
    )
}



@Preview
@Composable
fun MyUI2() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.Verified,
            contentDescription = null,
            tint = Color.Green,
            modifier = Modifier.size(28.dp)
        )

        // gap between icon and text
        Spacer(modifier = Modifier.width(width = 6.dp))

        Text(
            text = "Проверено",
            color = Color.Green,
            fontSize = 20.sp
        )
    }
}



@Preview
@Composable
fun MyUI3() {
    Icon(
        painter = painterResource(id = R.drawable.baseline_fingerprint_24),
        contentDescription = null,
        tint = Color.Green,
        modifier = Modifier.size(size = 60.dp)
    )
}