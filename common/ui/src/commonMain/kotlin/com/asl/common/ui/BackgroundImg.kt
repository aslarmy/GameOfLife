package com.asl.common.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import childedu.common.ui.generated.resources.Res
import childedu.common.ui.generated.resources.bg
import org.jetbrains.compose.resources.painterResource

@Composable
fun BackgroundImg(
    modifier: Modifier = Modifier
) {
    Image(
        painterResource(Res.drawable.bg),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}