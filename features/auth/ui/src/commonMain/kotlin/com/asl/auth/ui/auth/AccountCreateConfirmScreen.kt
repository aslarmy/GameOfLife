package com.asl.auth.ui.auth

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.FactCheck
import androidx.compose.material.icons.automirrored.filled.ScheduleSend
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ScheduleSend
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childedu.features.auth.ui.generated.resources.Res
import childedu.features.auth.ui.generated.resources.bg
import com.asl.common.ui.GameButton
import com.asl.common.ui.OutlineText
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random

@Composable
fun AccountCreateConfirmScreen(
    modifier: Modifier = Modifier,
    onClickProfileScreen: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painterResource(Res.drawable.bg),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {

            AnimatedKidsConfirmationLogo()

            OutlineText(
                text = "Your Account has been created successfully",
                fontSize = 30.sp
            )

            GameButton(
                text = "Continue", onClick = onClickProfileScreen,
                modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                gradientStart = Color.Green,
                gradientEnd = Color.Red.copy(alpha = 0.8f),
                borderColor = Color.Yellow.copy(alpha = 0.8f),
                shadowColor = Color.Yellow.copy(alpha = 0.5f)
            )

            /*  Row {
                  //অ আ ই ক  খ গ ১  ২  ৩
                  BalloonTextK(
                      fontSize = 50.sp,
                      text = "১"
                  )
                  BalloonTextK(
                      fontSize = 50.sp,
                      text = "২"
                  )
                  BalloonTextK(
                      fontSize = 50.sp,
                      text = "৩"
                  )
              }*/

        }
    }
}

@Composable
fun KidsConfirmationLogo(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(120.dp)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFF4CAF50), Color(0xFF81C784), Color.White),
                    radius = 200f
                ),
                shape = CircleShape
            )
            .border(4.dp, Color.Yellow, CircleShape)
            .shadow(8.dp, CircleShape)
    ) {
        // Cartoonish Check Mark
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Confirmed",
            modifier = Modifier.size(64.dp),
            tint = Color.White
        )

        // Fun sparkles around (stars)
        Canvas(modifier = Modifier.fillMaxSize()) {
            val starColor = listOf(Color.Yellow, Color.Cyan, Color.Magenta, Color.Red)
            for (i in 0..6) {
                drawCircle(
                    color = starColor.random(),
                    radius = 6f,
                    center = Offset(
                        x = size.width * (0.2f + 0.6f * Random.nextFloat()),
                        y = size.height * (0.2f + 0.6f * Random.nextFloat())
                    )
                )
            }
        }
    }
}

@Composable
fun AnimatedKidsConfirmationLogo(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "sparkle")

    // ✅ Zoom animation for check mark
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(800, easing = OvershootInterpolatorEasing),
        label = "scale",
    )

    // ✨ Twinkling effect for sparkles
    val alpha1 by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha1"
    )
    val alpha2 by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.3f,
        animationSpec = infiniteRepeatable(
            tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha2"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(140.dp)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFF4CAF50), Color(0xFF81C784), Color.White),
                    radius = 300f
                ),
                shape = CircleShape
            )
            .border(4.dp, Color.Yellow, CircleShape)
            .shadow(12.dp, CircleShape)
    ) {
        // ✅ Cartoonish check mark
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Confirmed",
            modifier = Modifier
                .size(80.dp)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                },
            tint = Color.White
        )

        // ✨ Sparkles around
        Canvas(modifier = Modifier.fillMaxSize()) {
            val starColors = listOf(Color.Yellow, Color.Cyan, Color.Magenta, Color.Red)

            // Few sparkles with twinkle effect
            drawCircle(
                color = starColors.random().copy(alpha = alpha1),
                radius = 10f,
                center = Offset(size.width * 0.2f, size.height * 0.3f)
            )
            drawCircle(
                color = starColors.random().copy(alpha = alpha2),
                radius = 12f,
                center = Offset(size.width * 0.8f, size.height * 0.7f)
            )
            drawCircle(
                color = starColors.random().copy(alpha = alpha1),
                radius = 8f,
                center = Offset(size.width * 0.5f, size.height * 0.15f)
            )
        }
    }
}

// Small custom easing for bounce/overshoot effect
val OvershootInterpolatorEasing = Easing { fraction ->
    val tension = 2.0f
    ((fraction - 1).let { it * it * ((tension + 1) * it + tension) } + 1)
}


