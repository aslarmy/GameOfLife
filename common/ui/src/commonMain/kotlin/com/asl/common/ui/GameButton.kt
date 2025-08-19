package com.asl.common.ui

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun GameButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    gradientStart: Color = Color.Green,
    gradientEnd: Color = Color.Red.copy(alpha = 0.8f),
    borderColor: Color = Color.Yellow.copy(alpha = 0.8f),
    shadowColor: Color = Color.Yellow.copy(alpha = 0.5f),
    drawableResource: DrawableResource? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    // Animate the scale of the button on press
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Box(
        modifier = modifier
            .padding(top = 10.dp, bottom = 10.dp, start = 16.dp, end = 16.dp)
            .height(56.dp)
            .graphicsLayer {
                // Apply a large, dark shadow to create a 3D elevated effect
                shadowElevation = 8.dp.toPx()
                shape = RoundedCornerShape(16.dp)
                clip = true
            }
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(gradientStart, gradientEnd)
                )
            )
            .border(
                width = 3.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .scale(scale)
            .clickable(
                interactionSource = interactionSource,
                indication = null, // Disable the default ripple
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        // Text with a shadow to give it a "pop" effect
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            drawableResource?.let {
                Image(
                    painterResource(drawableResource),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                )
            }
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    shadow = Shadow(
                        color = shadowColor,
                        offset = Offset(2f, 2f),
                        blurRadius = 4f
                    )
                )
            )
        }

    }
}