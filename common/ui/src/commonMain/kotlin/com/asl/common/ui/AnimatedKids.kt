package com.asl.common.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AnimatedKids(
    modifier: Modifier = Modifier,
    isAnimated: Boolean = false,
    drawableResource: DrawableResource
) {
    AnimatedVisibility(
        isAnimated,
        enter = scaleIn(
            initialScale = 0.3f, // start very small
            animationSpec = tween(durationMillis = 1000) // smooth expand
        ) + fadeIn(),
        exit = scaleOut(
            targetScale = 0.3f, // shrink back
            animationSpec = tween(durationMillis = 1000)
        ) + fadeOut(),
        modifier = modifier
            .padding(bottom = 80.dp)
            .size(200.dp),
    ) {
        Image(
            painterResource(drawableResource),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .size(200.dp),
        )
    }
}