package com.asl.auth.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childedu.features.auth.ui.generated.resources.Res
import childedu.features.auth.ui.generated.resources.bg
import childedu.features.auth.ui.generated.resources.splash_bg
import com.asl.common.ui.BackgroundImg
import com.asl.common.ui.CustomTextField
import com.asl.common.ui.GameButton
import com.asl.common.ui.MediumText
import com.asl.common.ui.OutlineText
import org.jetbrains.compose.resources.painterResource

@Composable
fun SignUpScreenContent(
    modifier: Modifier = Modifier,
    onClickSignUpBtn: () -> Unit,
    onClickLoginScreen: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        BackgroundImg()

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            OutlineText(
                "Sign up",
                fontSize = 35.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(fraction = 0.8f)
            )
            Spacer(Modifier.size(8.dp))
            MediumText(
                "User Name",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(fraction = 0.8f)
            )

            CustomTextField(
                value = "",
                placeholder = "John Doe",
                onValueChange = {},
            )

            Spacer(Modifier.size(8.dp))
            MediumText(
                "Email Address",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(fraction = 0.8f)
            )
            CustomTextField(
                value = "",
                placeholder = "example@gmail.com",
                onValueChange = {},
            )
            Spacer(Modifier.size(8.dp))
            MediumText(
                "Password",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(fraction = 0.8f)
            )
            CustomTextField(
                value = "",
                placeholder = "123456",
                onValueChange = {},
            )
            Spacer(Modifier.size(8.dp))
            MediumText(
                "Confirm Password",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(fraction = 0.8f)
            )
            CustomTextField(
                value = "",
                placeholder = "123456",
                onValueChange = {},
            )
            Spacer(Modifier.size(8.dp))

            // Define colors for the gradient and shadow
            val gradientStart = Color.Green
            val gradientEnd = Color.Red.copy(alpha = 0.8f)
            val borderColor = Color.Yellow.copy(alpha = 0.8f)
            val shadowColor = Color.Yellow.copy(alpha = 0.5f)

            GameButton(
                text = "Sign up", onClick = onClickSignUpBtn,
                modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                gradientStart = gradientStart,
                gradientEnd = gradientEnd,
                borderColor = borderColor,
                shadowColor = shadowColor
            )

            Spacer(Modifier.size(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                horizontalArrangement = Arrangement.Center
            ) {
                MediumText(
                    text = "have an account?",
                    fontSize = 18.sp,
                    fillColor = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                )
                Spacer(Modifier.size(8.dp))
                MediumText(
                    fillColor = Color.White,
                    text = "Login",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.clickable(onClick = onClickLoginScreen)
                )
            }
        }
    }
}