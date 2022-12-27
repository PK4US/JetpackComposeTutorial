package com.pk4us.jetpackcomposetutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            listView()
        }
    }
}

@Preview
@Composable
fun ListListScopeSample() {
    LazyColumn {
        item {
            Text(text = "Header")
        }

        items(3) { index ->
            Text(text = "First List items : $index")
        }

        items(2) { index ->
            Text(text = "Second List Items: $index")
        }

        item {
            Text(text = "Footer")
        }
    }
}
//--------------------------------------------------------------------------------------------------

private val countryList = mutableListOf("India", "Pakistan", "China", "United States")
private val listModifier = Modifier
private val textStyle = TextStyle(fontSize = 20.sp)

@Preview
@Composable
fun SimpleListView() {
    LazyColumn(modifier = listModifier) {
        items(countryList) { country ->
            Text(text = country, style = textStyle)
        }
    }
}

//--------------------------------------------------------------------------------------------------
@Composable
fun ListRow(model: FruitModel) {
    val mContext = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .selectable(
                selected = false,
                onClick = {
                    mContext.startActivity(Intent(mContext, SecondActivity::class.java))
                }
            )
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            Modifier.padding(32.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}


@Preview
@Composable
fun listView() {
    val fruitsList = mutableListOf<FruitModel>()
    fruitsList.add(FruitModel("Apple", R.drawable.apple))
    fruitsList.add(FruitModel("Orange", R.drawable.orange))
    fruitsList.add(FruitModel("Banana", R.drawable.banana))
    fruitsList.add(FruitModel("Strawberry", R.drawable.strawberry))
    fruitsList.add(FruitModel("Eggplant", R.drawable.eggplant))
    fruitsList.add(FruitModel("Cucumber", R.drawable.cucumber))
    fruitsList.add(FruitModel("Tomato", R.drawable.tomato))
    fruitsList.add(FruitModel("Avocado", R.drawable.avocado))
    fruitsList.add(FruitModel("Beet", R.drawable.beet))
    fruitsList.add(FruitModel("Bell pepper", R.drawable.bell_pepper))
    fruitsList.add(FruitModel("Broccoli", R.drawable.broccoli))
    fruitsList.add(FruitModel("Carrot", R.drawable.carrot))
    fruitsList.add(FruitModel("Cherry", R.drawable.cherry))
    fruitsList.add(FruitModel("Corn", R.drawable.corn))
    fruitsList.add(FruitModel("Kiwi", R.drawable.kiwi_))
    fruitsList.add(FruitModel("Lemon", R.drawable.lemon))
    fruitsList.add(FruitModel("Pear", R.drawable.pear))
    fruitsList.add(FruitModel("Peas", R.drawable.peas))
    fruitsList.add(FruitModel("Pineapple", R.drawable.pineapple))
    fruitsList.add(FruitModel("Pomegranate", R.drawable.pomegranate))
    fruitsList.add(FruitModel("Watermelon", R.drawable.watermelon))
    fruitsList.add(FruitModel("Peach", R.drawable.peach))

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(fruitsList) { model ->
            ListRow(model = model)
        }
    }
}
