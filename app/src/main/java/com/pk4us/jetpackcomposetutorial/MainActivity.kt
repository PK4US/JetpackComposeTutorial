package com.pk4us.jetpackcomposetutorial

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcomposetutorial.ui.theme.Purple700
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Messages1()
            }
        }

    }
}

private lateinit var messagesList: ArrayList<MessagesData>

@Preview
@Composable
fun TopAppbarMessages(context: Context = LocalContext.current.applicationContext) {
    TopAppBar(
        title = {
            Text(
                text = "Telegram",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = Purple700,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Click Menu", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "menu",
                )
            }
        }
    )
}

@Preview
@Composable
fun Messages1() {

    // This is to check if the messagesList has data or not
    // Initially it is false
    var listPrepared by remember { mutableStateOf(false) }

    if (listPrepared) {
        TopAppbarMessages()
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(messagesList) { itemObject ->
                MessagesItemStyle(item = itemObject)
            }
        }
    }

    // This is called when the user first opens the activity
    // So, add data to messagesList here
    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            prepareMessagesList()
            listPrepared = true
        }
    }

}

@Composable
fun MessagesItemStyle(
    item: MessagesData,
    context: Context = LocalContext.current.applicationContext
) {

    Box(
        modifier = Modifier
            .clickable(
                onClick = {
                    Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
                }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Profile image
            Image(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(56.dp),
                painter = painterResource(id = item.image),
                contentDescription = item.name
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    // Text that shows the name
                    Text(
                        text = item.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    )

                    // Text that shows the time
                    Text(
                        text = item.time,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    )

                }

                // Text that shows the message
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp),
                    text = item.message,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                )

            }
        }
    }
}

private fun prepareMessagesList() {
    messagesList = ArrayList()

    messagesList.add(
        MessagesData(
            R.drawable.people_abby,
            "Abby",
            "Cool. We meet tomorrow",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_emilia,
            "Emilia",
            "Why are you not picking up my call?",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_emma,
            "Emma",
            "Tom doesn't have to help",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_grace,
            "Grace",
            "The school principal was so mean that all the children were scared of him",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_hannah,
            "Hannah",
            "I'm curious to know why they removed my name from the list",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_isabella,
            "Isabella",
            "Do you really think you'd be happy in a job like that?",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_lucy,
            "Lucy",
            "Would you like your cash in tens or twenties?",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_olivia,
            "Olivia",
            "If you hurry, there still might be some choice items left for you to buy",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_scarlett,
            "Scarlett",
            "How can she afford a multi-million dollar house?",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_victoria,
            "Victoria",
            "She found the necklace in a safe at the bottom of her parents' closet",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_natasha,
            "Наташа",
            "Азиатом короч",
            "00:46"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_katya,
            "Катя",
            "Тогда договорились встречаемся в субботу в 16:00",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_anya,
            "Аня",
            "Ахахах, очень смешно!",
            "00:30"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_masha,
            "Маша",
            "Хорошо",
            "00:15"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_lera,
            "Лера",
            "Ясно",
            "00:12"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_karina,
            "Карина",
            "Ахаха дааа!",
            "00:09"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_lesya,
            "Леся",
            "Пока! Увидимся!",
            "00:05"
        )
    )
}

data class MessagesData(
    val image: Int,
    val name: String,
    val message: String,
    val time: String
)