package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Row(
                    Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MyUI()
                }
            }
        }
    }
}

private enum class ImageState {
    Small, Large
}

@Preview
@Composable
fun MyUI() {

    var imageState by remember {
        mutableStateOf(ImageState.Small)
    }

    val transition = updateTransition(targetState = imageState, label = "BoxState Transition")

    val borderColor by
    transition.animateColor(label = "BoxState Color Transition") {
        when (it) {
            ImageState.Small -> Color.Green
            ImageState.Large -> Color.Magenta
        }
    }

    val size by transition.animateDp(label = "BoxState Size Transition") {
        when (it) {
            ImageState.Small -> 90.dp
            ImageState.Large -> 130.dp
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .size(size = size)
                .clip(shape = CircleShape)
                .border(color = borderColor, shape = CircleShape, width = 3.dp),
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "Dog"
        )

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                imageState =
                    if (imageState == ImageState.Small)
                        ImageState.Large
                    else
                        ImageState.Small
            }
        ) {
            Text(text = "Toggle State")
        }
    }
}
