package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import coil.compose.rememberAsyncImagePainter
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
                    Column(
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        MyUI1()
                        MyUI2()
                        MyUI3()
                        MyUI4()
                        MyUI5()
                        MyUI6()
                        MyUI7()
                        MyUI8()
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun MyUI1() {
    val contextForToast = LocalContext.current.applicationContext

    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = "Dog Image",
        modifier = Modifier
            .size(160.dp)
            .clickable {
                Toast
                    .makeText(contextForToast, "Click!", Toast.LENGTH_SHORT)
                    .show()
            }
    )
}


@Preview
@Composable
fun MyUI2() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        modifier = Modifier
            .size(160.dp)
            .clip(CircleShape)
            .border(width = 2.dp, color = Color.Green, shape = CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyUI3() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        modifier = Modifier
            .size(size = 160.dp)
            .blur(
                radiusX = 10.dp,
                radiusY = 10.dp,
                edgeTreatment = BlurredEdgeTreatment(shape = RoundedCornerShape(percent = 5))
            ),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun MyUI4() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        modifier = Modifier
            .size(size = 160.dp)
            .blur(
                radiusX = 10.dp,
                radiusY = 10.dp,
                edgeTreatment = BlurredEdgeTreatment.Unbounded
            ),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun MyUI5() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        modifier = Modifier
            .size(size = 160.dp)
            .blur(
                radiusX = 10.dp,
                radiusY = 10.dp,
                edgeTreatment = BlurredEdgeTreatment.Rectangle
            ),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun MyUI6() {
    val asyncPainter =
        rememberAsyncImagePainter("https://semicolonspace.com/wp-content/uploads/2023/02/forest.jpg")

    Image(
        painter = asyncPainter,
        contentDescription = null,
        modifier = Modifier.size(size = 160.dp)
    )
}

@Composable
fun MyUI7() {
    Image(
        imageVector = Icons.Filled.Search,
        contentDescription = null,
        modifier = Modifier.size(size = 100.dp)
    )
}

@Composable
fun MyUI8() {
    val context = LocalContext.current.applicationContext
    val bitmap = ContextCompat.getDrawable(context, R.drawable.dog)?.toBitmap()?.asImageBitmap()!!

    Image(
        bitmap = bitmap,
        contentDescription = null,
        modifier = Modifier.size(size = 160.dp)
    )
}