package com.pk4us.jetpackcomposetutorial

import android.content.Context
import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatchScreenDatingApp()
        }
    }
}

@Composable
private fun MatchScreenDatingApp(
    primaryColor: Color = Color(0xFFF518A0),
    backgroundColors: List<Color> =
        listOf(
            primaryColor,
            Color(0xFFB232BD)
        )
) {

    // change status bar color
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = primaryColor)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(backgroundColors))
            .padding(vertical = 64.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MatchScreenTopText()
        }

        MatchScreenImagesBox(primaryColor = primaryColor)

        Row(
            modifier = Modifier.fillMaxWidth(),
            // Gap between two buttons = 24.dp
            horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally)
        ) {
            MatchScreenButtons(primaryColor = primaryColor)
        }

    }
}

@Composable
private fun MatchScreenTopText() {

    Text(
        text = "It’s a Match!", style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
    )

    Text(
        text = "You and Grace like each other", style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        )
    )
}

@Composable
private fun MatchScreenImagesBox(primaryColor: Color) {
    Box(contentAlignment = Alignment.Center) {

        Row {
            MatchScreenImageStyle(imageId = R.drawable.people_john)
            MatchScreenImageStyle(imageId = R.drawable.people_grace_1)
        }

        Icon(
            modifier = Modifier
                .background(color = primaryColor, shape = CircleShape)
                .border(width = 3.dp, color = Color.White, shape = CircleShape)
                .padding(12.dp),
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Match",
            tint = Color.White
        )

    }
}

@Composable
private fun MatchScreenImageStyle(imageId: Int) {
    Image(
        modifier = Modifier
            .size(120.dp)
            .shadow(
                elevation = 4.dp,
                shape = CircleShape,
                clip = true
            )
            .clip(CircleShape)
            .border(width = 3.dp, color = Color.White, shape = CircleShape),
        painter = painterResource(id = imageId),
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun MatchScreenButtons(primaryColor: Color) {
    ButtonStyles(
        imageVector = Icons.Outlined.Email,
        text = "Message Her",
        primaryColor = primaryColor
    )
    ButtonStyles(
        imageVector = Icons.Outlined.Info,
        text = "Info",
        primaryColor = primaryColor
    )
}

@Composable
private fun ButtonStyles(
    context: Context = LocalContext.current.applicationContext,
    imageVector: ImageVector,
    text: String,
    primaryColor: Color
) {
    OutlinedButton(
        modifier = Modifier.size(56.dp),
        shape = CircleShape,
        border = BorderStroke(0.dp, Color.Transparent),
        contentPadding = PaddingValues(6.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
        onClick = {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = imageVector,
            contentDescription = text,
            tint = primaryColor
        )
    }
}