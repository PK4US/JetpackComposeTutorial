package com.pk4us.jetpackcomposetutorial

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {

                val contextForToast = LocalContext.current.applicationContext

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    MyTopAppBar(contextForToast = contextForToast)

                    Spacer(modifier = Modifier.height(height = 8.dp))

                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "Выбери собаку",
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold))
                    )

                    Spacer(modifier = Modifier.height(height = 8.dp))

                    CustomRadioButtons()
                }
            }
        }
    }
}

@Composable
private fun MyTopAppBar(contextForToast: Context) {

    TopAppBar(
        title = { Text(text = "Собаки") },
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(
                onClick = {
                    Toast.makeText(
                        contextForToast,
                        "Nav Icon Click",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        }
    )
}

@Composable
private fun CustomRadioButtons() {

    val dogsList = returnDogsList()

    var selectedItem by remember {
        mutableStateOf(dogsList[0].name)
    }

    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
            .selectableGroup()
    ) {

        CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {

            dogsList.forEach { dogDetails ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (selectedItem == dogDetails.name),
                            onClick = { selectedItem = dogDetails.name },
                            role = Role.RadioButton
                        )
                        .padding(vertical = 8.dp)
                ) {
                    RadioButtonStyle(selectedItem = selectedItem, dogDetails = dogDetails)
                }
            }
        }
    }
}

@Composable
private fun RadioButtonStyle(selectedItem: String, dogDetails: DogsData) {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color =
                if (selectedItem == dogDetails.name)
                    MaterialTheme.colors.primary
                else
                    Color.LightGray,
                shape = RoundedCornerShape(percent = 10)
            )
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            // dog's image
            Image(
                modifier = Modifier
                    .size(size = 94.dp)
                    .clip(shape = CircleShape),
                painter = painterResource(id = dogDetails.image),
                contentScale = ContentScale.Crop,
                contentDescription = "Dog Image"
            )

            // dog's details
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 6.dp, bottom = 6.dp)
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    // dog's name
                    Text(
                        text = dogDetails.name,
                        fontSize = 22.sp,
                        fontFamily = FontFamily(
                            Font(
                                R.font.roboto_bold,
                                weight = FontWeight.Bold
                            )
                        )
                    )

                    // check icon
                    Icon(
                        imageVector =
                        if (selectedItem == dogDetails.name)
                            Icons.Outlined.CheckCircle
                        else
                            Icons.Outlined.CheckCircle,
                        contentDescription = null,
                        tint =
                        if (selectedItem == dogDetails.name)
                            MaterialTheme.colors.primary
                        else
                            Color.Gray
                    )
                }

                // dog's age
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = dogDetails.age,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(
                        Font(
                            R.font.roboto_regular,
                            weight = FontWeight.Normal
                        )
                    )
                )

                // dog's price
                Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = "$${dogDetails.price}",
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium, weight = FontWeight.Medium)),
                    color = Color.DarkGray
                )
            }
        }
    }
}

private fun returnDogsList(): ArrayList<DogsData> {
    val dogsList = arrayListOf<DogsData>()

    dogsList.add(
        DogsData(
            image = R.drawable.dog4,
            name = "Марни",
            age = "3-года",
            price = "200"
        )
    )

    dogsList.add(
        DogsData(
            image = R.drawable.dog3,
            name = "Принц",
            age = "3-года",
            price = "250"
        )
    )

    dogsList.add(
        DogsData(
            image = R.drawable.dog2,
            name = "Марсель",
            age = "2-года",
            price = "500"
        )
    )

    dogsList.add(
        DogsData(
            image = R.drawable.dog1,
            name = "Лакки",
            age = "5-лет",
            price = "300"
        )
    )

    return dogsList
}


object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

data class DogsData(val image: Int, val name: String, val age: String, val price: String)