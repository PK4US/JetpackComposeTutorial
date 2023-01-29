package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
                CardElevation()
            }
        }
    }
}

@Preview
@Composable
fun CardElevation() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFFDAE1E7),
            modifier = Modifier
                .height(210.dp)
                .padding(10.dp),
            shadowElevation = 10.dp
        ) {
            Column() {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(2f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier.wrapContentSize(),
                            color = Color(0xFFD1D5E1)
                        ) {
                            Text(
                                text = "Новый",
                                fontSize = 12.sp,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Степан",
                            fontSize = 24.sp,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(text = "Цена: 300$")

                        Spacer(modifier = Modifier.height(2.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "4.0",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = Color(0xFFF6B266),
                                contentDescription = null
                            )

                            Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = Color(0xFFF6B266),
                                contentDescription = null
                            )

                            Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = Color(0xFFF6B266),
                                contentDescription = null
                            )
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = Color(0xFFF6B266),
                                contentDescription = null
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        OutlinedButton(
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                containerColor = Color.White
                            ),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                text = "Читать еще ...",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.size(width = 100.dp, height = 140.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.stepan),
                            contentScale = ContentScale.Crop,
                            contentDescription = ""
                        )
                    }
                }
            }
        }
        // using card material3 design
        // * Card with content argument
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            content = {
                Text(
                    "Card with content argument",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        )

        // * Card with shape argument
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            //set shape of the card
            shape = RoundedCornerShape(16.dp),
            content = {
                Text(
                    "Card with shape argument",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        )

        // * Card with background color argument
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            //set background color of the card
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            content = {
                Text(
                    "Card with background color argument",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        )

        // * Card with elevation
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            //set card elevation of the card
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
            content = {
                Text(
                    "Card with background color argument",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        )

        // * Card with border argument
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            border = BorderStroke(2.dp, androidx.compose.ui.graphics.Color.Black),
            content = {
                Text(
                    "Card with border argument",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        )

        Card(
            //shape = MaterialTheme.shapes.medium,
            shape = RoundedCornerShape(8.dp),
            // modifier = modifier.size(280.dp, 240.dp)
            modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
            //set card elevation of the card
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
        ) {
            Column(modifier = Modifier.clickable(onClick = { })) {

                Image(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null, // decorative
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Title",
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Sub title Example code for android + composes app developers.",
                        //maxLines = 1,
                        //overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun CardExample() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Card(Modifier.size(width = 180.dp, height = 100.dp)) {
                // Card content
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = " Filled card", Modifier.align(Alignment.Center))
                }
            }

            Spacer(modifier = Modifier.size(20.dp))

            Card(
                onClick = { /* Do something */ },
                modifier = Modifier.size(width = 180.dp, height = 100.dp)
            ) {
                Box(Modifier.fillMaxSize()) {
                    Text("Clickable", Modifier.align(Alignment.Center))
                }
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row {
            ElevatedCard(Modifier.size(width = 180.dp, height = 100.dp)) {
                // Card content
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = "ElevatedCard card", Modifier.align(Alignment.Center))
                }
            }

            Spacer(modifier = Modifier.size(20.dp))

            ElevatedCard(
                onClick = { /* Do something */ },
                modifier = Modifier.size(width = 180.dp, height = 100.dp)
            ) {
                Box(Modifier.fillMaxSize()) {
                    Text("Clickable", Modifier.align(Alignment.Center))
                }
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row {
            OutlinedCard(Modifier.size(width = 180.dp, height = 100.dp)) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Outlined card", Modifier.align(Alignment.Center))
                }
            }

            Spacer(modifier = Modifier.size(20.dp))

            OutlinedCard(
                onClick = { /* Do something */ },
                modifier = Modifier.size(width = 180.dp, height = 100.dp)
            ) {
                Box(Modifier.fillMaxSize()) {
                    Text("Clickable", Modifier.align(Alignment.Center))
                }
            }
        }
    }
}