package com.asl.auth.ui.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childedu.features.auth.ui.generated.resources.Res
import childedu.features.auth.ui.generated.resources.bg
import childedu.features.auth.ui.generated.resources.female_kids
import childedu.features.auth.ui.generated.resources.male_kids
import com.asl.common.ui.AnimatedKids
import com.asl.common.ui.BackgroundImg
import com.asl.common.ui.CustomTextField
import com.asl.common.ui.GameButton
import com.asl.common.ui.MediumText
import com.asl.common.ui.OutlineText
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCreateScreen(
    modifier: Modifier = Modifier,
    onClickAvatarCreateScreen: () -> Unit
) {

    var isAnimated by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(1000)
        isAnimated = true
    }

    var selectedAge by rememberSaveable { mutableStateOf(3) }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    "Create Profile",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(it),
        ) {
            BackgroundImg()

            AnimatedKids(
                modifier = Modifier.align(Alignment.BottomStart),
                isAnimated = isAnimated,
                drawableResource = Res.drawable.male_kids
            )

            AnimatedKids(
                modifier = Modifier.align(Alignment.BottomEnd),
                isAnimated = isAnimated,
                drawableResource = Res.drawable.female_kids
            )

            if (isAnimated)
                AnimatedTextList(
                    fontSize = 60.sp,
                    texts = listOf("অ", "আ", "ই", "ক", "খ", "গ", "১", "২", "৩", "A", "B", "C"),
                    modifier = Modifier
                        .padding(bottom = 80.dp)
                        .align(Alignment.BottomCenter),
                )


            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.size(16.dp))

                MediumText(
                    "Enter Your Child Name",
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                )

                CustomTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                    placeholder = "Child's Name"
                )

                MediumText(
                    "Select Age",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    item {
                        AgeSelectionBox(
                            age = 3,
                            isSelected = 3 == selectedAge,
                            selectedAge = { age ->
                                selectedAge = age
                            })
                    }
                    item {
                        AgeSelectionBox(
                            age = 4,
                            isSelected = 4 == selectedAge,
                            selectedAge = { age ->
                                selectedAge = age
                            })
                    }
                    item {
                        AgeSelectionBox(
                            age = 5,
                            isSelected = 5 == selectedAge,
                            selectedAge = { age ->
                                selectedAge = age
                            })
                    }
                    item {
                        AgeSelectionBox(
                            age = 6,
                            isSelected = 6 == selectedAge,
                            selectedAge = { age ->
                                selectedAge = age
                            })
                    }

                }

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    item {
                        AgeSelectionBox(
                            age = 7,
                            isSelected = 7 == selectedAge,
                            selectedAge = { age ->
                                selectedAge = age
                            })
                    }
                    item {
                        AgeSelectionBox(
                            age = 8,
                            isSelected = 8 == selectedAge,
                            selectedAge = { age ->
                                selectedAge = age
                            })
                    }
                    item {
                        AgeSelectionBox(
                            age = 9,
                            isSelected = 9 == selectedAge,
                            selectedAge = { age ->
                                selectedAge = age
                            })
                    }
                    item {
                        AgeSelectionBox(
                            age = 10,
                            isSelected = 10 == selectedAge,
                            selectedAge = { age ->
                                selectedAge = age
                            })
                    }

                }

                // Define colors for the gradient and shadow
                val gradientStart = Color.Green
                val gradientEnd = Color.Red.copy(alpha = 0.8f)
                val borderColor = Color.Yellow.copy(alpha = 0.8f)
                val shadowColor = Color.Yellow.copy(alpha = 0.5f)
                GameButton(
                    text = "Continue", onClick = onClickAvatarCreateScreen,
                    modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                    gradientStart = gradientStart,
                    gradientEnd = gradientEnd,
                    borderColor = borderColor,
                    shadowColor = shadowColor
                )
            }
        }
    }


}

@Composable
private fun AgeSelectionBox(
    age: Int,
    isSelected: Boolean = false,
    selectedAge: (Int) -> Unit
) {

    val ageCircleContainerColor = if (isSelected) Color.Blue else Color.White
    val ageContentColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Yellow, Color.Yellow.copy(alpha = 0.6f))
                ), CircleShape
            )
            .border(width = 2.dp, color = ageCircleContainerColor, CircleShape)
            .clickable(onClick = { selectedAge(age) }),
        contentAlignment = Alignment.Center
    ) {
        OutlineText(
            text = "$age",
            fontSize = 35.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }

}