package com.asl.letter_and_number.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.asl.common.ui.BackgroundImg
import com.asl.common.ui.OutlineText

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    MainScreenContent(modifier = modifier)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScreenContent(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.LightGray.copy(alpha = 0.5f)
                ),
                title = {
                    Column {
                        OutlineText(
                            text = "Hello,\nLittle Star",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start,
                        )
                    }
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .clickable(onClick = {})
                    ) {
                        AsyncImage(
                            "https://img.freepik.com/premium-vector/cute-boy-face-cartoon_18591-41511.jpg?w=360",
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.matchParentSize()
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.Settings,
                            contentDescription = "Settings",
                            modifier = Modifier.size(50.dp),
                            tint = Color.Blue
                        )
                    }
                }
            )
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
        ) {
            BackgroundImg()

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                item {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(8.dp)
                                .background(
                                    color = Color.DarkGray,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clip(RoundedCornerShape(16.dp))
                        ) {
                            Text(text = "Alphabet")
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(8.dp)
                                .background(
                                    color = Color.DarkGray,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clip(RoundedCornerShape(16.dp))
                        ) {
                            Text(text = "Alphabet")
                        }
                    }
                }
            }


        }
    }

}