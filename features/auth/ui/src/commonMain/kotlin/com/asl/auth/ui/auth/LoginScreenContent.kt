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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childedu.features.auth.ui.generated.resources.Res
import childedu.features.auth.ui.generated.resources.bg
import childedu.features.auth.ui.generated.resources.google_logo
import childedu.features.auth.ui.generated.resources.splash_bg
import com.asl.common.ui.CustomTextField
import com.asl.common.ui.GameButton
import com.asl.common.ui.MediumText
import com.asl.common.ui.OutlineText
import com.asl.common.ui.customFontFamilyAnticSlab
import com.asl.common.ui.customFontFamilyChelaOne
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    onClickLoginBtn: () -> Unit,
    onClickSignUpScreen: () -> Unit,
    onClickGoogleScreen: () -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Image(
            painterResource(Res.drawable.bg),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            OutlineText(
                "Login",
                fontSize = 35.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(fraction = 0.8f)
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
                placeholder = "123456",
                value = "",
                onValueChange = {},
            )
            MediumText(
                "Forgot Password?",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                textAlign = TextAlign.End
            )
            Spacer(Modifier.size(8.dp))

            // Define colors for the gradient and shadow
            val gradientStart = Color.Green
            val gradientEnd = Color.Red.copy(alpha = 0.8f)
            val borderColor = Color.Yellow.copy(alpha = 0.8f)
            val shadowColor = Color.Yellow.copy(alpha = 0.5f)

            GameButton(
                text = "Login", onClick = onClickLoginBtn,
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
                    "Don't have an account?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
                Spacer(Modifier.size(8.dp))
                MediumText(
                    "Sign up",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.clickable(onClick = { onClickSignUpScreen() })
                )
            }
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