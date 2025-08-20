package com.asl.auth.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childedu.features.auth.ui.generated.resources.Res
import childedu.features.auth.ui.generated.resources.bg
import childedu.features.auth.ui.generated.resources.female_kids
import childedu.features.auth.ui.generated.resources.google_logo
import childedu.features.auth.ui.generated.resources.male_kids
import childedu.features.auth.ui.generated.resources.splash_bg
import com.asl.common.ui.AnimatedKids
import com.asl.common.ui.BackgroundImg
import com.asl.common.ui.GameButton
import com.asl.common.ui.MediumText
import com.asl.common.ui.OutlineText
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    onClickLoginScreen: () -> Unit,
    onClickSignUpScreen: () -> Unit,
    onClickGoogleScreen: () -> Unit,
) {

    var isViewSplashScreen by rememberSaveable { mutableStateOf(false) }
    var isAnimated by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(4000)
        isViewSplashScreen = true
    }

    LaunchedEffect(Unit) {
        delay(1500)
        isAnimated = true
    }

    if (isViewSplashScreen) {

        AuthScreenContent(
            modifier = modifier,
            onClickLoginScreen = onClickLoginScreen,
            onClickSignUpScreen = onClickSignUpScreen,
            onClickGoogleScreen = onClickGoogleScreen
        )

    } else {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painterResource(Res.drawable.splash_bg),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

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
                    texts = listOf("অ", "আ", "ই", "ক", "খ", "গ", "১", "২", "৩"),
                    modifier = Modifier
                        .padding(bottom = 80.dp)
                        .align(Alignment.BottomCenter),
                )

            /*   CircularProgressIndicator(
                   modifier = Modifier
                       .padding(bottom = 100.dp)
                       .size(50.dp)
                       .align(Alignment.BottomCenter),
                   strokeWidth = 8.dp,
                   color = Color(0xffd93e85),
                   strokeCap = StrokeCap.Round,
                   trackColor = Color(0xff34aede)
               )*/

        }
    }
}

@Composable
private fun AuthScreenContent(
    modifier: Modifier = Modifier,
    onClickLoginScreen: () -> Unit,
    onClickSignUpScreen: () -> Unit,
    onClickGoogleScreen: () -> Unit,
) {

    var isAnimated by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(1000)
        isAnimated = true
    }


    Scaffold {
        Box(
            modifier = modifier.padding(it),
            contentAlignment = Alignment.Center
        ) {

            BackgroundImg()

            AnimatedKids(
                modifier = Modifier.align(Alignment.TopStart),
                isAnimated = isAnimated,
                drawableResource = Res.drawable.male_kids
            )

            AnimatedKids(
                modifier = Modifier.align(Alignment.TopEnd),
                isAnimated = isAnimated,
                drawableResource = Res.drawable.female_kids
            )

            if (isAnimated)
                AnimatedTextList(
                    fontSize = 60.sp,
                    texts = listOf("অ", "আ", "ই", "ক", "খ", "গ", "১", "২", "৩", "A", "B", "C"),
                    modifier = Modifier
                        .align(Alignment.TopCenter),
                )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .align(Alignment.BottomCenter)
            ) {

                OutlineText(
                    "Hello,",
                    fontSize = 35.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(fraction = 0.8f)
                )

                Spacer(Modifier.size(16.dp))

                MediumText(
                    "Welcome to kids learning platform. Where you manage your kids learning progress.",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(fraction = 0.8f)
                )

                Spacer(Modifier.size(16.dp))

                GameButton(
                    text = "Login", onClick = onClickLoginScreen,
                    modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                    gradientStart = Color.Green,
                    gradientEnd = Color.Red.copy(alpha = 0.8f),
                    borderColor = Color.Yellow.copy(alpha = 0.8f),
                    shadowColor = Color.Yellow.copy(alpha = 0.5f)
                )

                Spacer(Modifier.size(8.dp))

                GameButton(
                    text = "Sign up", onClick = onClickSignUpScreen,
                    modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                    gradientStart = Color.Green,
                    gradientEnd = Color.Red.copy(alpha = 0.8f),
                    borderColor = Color.Yellow.copy(alpha = 0.8f),
                    shadowColor = Color.Yellow.copy(alpha = 0.5f)
                )

                Spacer(Modifier.size(16.dp))

                MediumText(
                    "Sign up using", fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 6.dp)
                )

                GameButton(
                    text = "Google", onClick = onClickGoogleScreen,
                    modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                    gradientStart = Color.Green,
                    gradientEnd = Color.Red.copy(alpha = 0.8f),
                    borderColor = Color.Yellow.copy(alpha = 0.8f),
                    shadowColor = Color.Yellow.copy(alpha = 0.5f),
                    drawableResource = Res.drawable.google_logo
                )

            }
        }
    }
}


