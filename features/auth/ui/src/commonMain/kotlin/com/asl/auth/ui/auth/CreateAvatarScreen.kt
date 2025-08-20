package com.asl.auth.ui.auth

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInOutQuad
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childedu.features.auth.ui.generated.resources.Res
import childedu.features.auth.ui.generated.resources.avatar_1
import childedu.features.auth.ui.generated.resources.avatar_10
import childedu.features.auth.ui.generated.resources.avatar_11
import childedu.features.auth.ui.generated.resources.avatar_12
import childedu.features.auth.ui.generated.resources.avatar_2
import childedu.features.auth.ui.generated.resources.avatar_3
import childedu.features.auth.ui.generated.resources.avatar_4
import childedu.features.auth.ui.generated.resources.avatar_5
import childedu.features.auth.ui.generated.resources.avatar_6
import childedu.features.auth.ui.generated.resources.avatar_7
import childedu.features.auth.ui.generated.resources.avatar_8
import childedu.features.auth.ui.generated.resources.avatar_9
import childedu.features.auth.ui.generated.resources.bg
import childedu.features.auth.ui.generated.resources.female_kids
import childedu.features.auth.ui.generated.resources.male_kids
import com.asl.common.ui.AnimatedKids
import com.asl.common.ui.BackgroundImg
import com.asl.common.ui.GameButton
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAvatarScreen(
    modifier: Modifier = Modifier,
    onClickMainScreen: () -> Unit,
    onBackClick: () -> Unit
) {

    var isAnimated by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(1000)
        isAnimated = true
    }

    var selectedAvatar by rememberSaveable { mutableStateOf("avatar_1") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Select Avatar",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                },
                navigationIcon = {
                    IconButton(onClick = onBackClick, content = {
                        Icon(Icons.Default.ArrowBack, contentDescription = "")
                    })
                })
        },
        content = {
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
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    avatarFourItem.forEachIndexed { index, resources ->
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            itemsIndexed(resources) { childIndex, drawable ->
                                AvatarLogo(
                                    drawable = drawable.resource,
                                    onClickAvatar = {
                                        selectedAvatar = drawable.resourceName
                                    },
                                    isSelected = selectedAvatar == drawable.resourceName
                                )
                            }
                        }
                    }

                    // Define colors for the gradient and shadow
                    val gradientStart = Color.Green
                    val gradientEnd = Color.Red.copy(alpha = 0.8f)
                    val borderColor = Color.Yellow.copy(alpha = 0.8f)
                    val shadowColor = Color.Yellow.copy(alpha = 0.5f)
                    GameButton(
                        text = "Continue", onClick = onClickMainScreen,
                        modifier = Modifier.fillMaxWidth(fraction = 0.9f),
                        gradientStart = gradientStart,
                        gradientEnd = gradientEnd,
                        borderColor = borderColor,
                        shadowColor = shadowColor
                    )
                }
            }
        })


}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedTextList(
    texts: List<String>,
    fontSize: TextUnit = 120.sp,
    modifier: Modifier = Modifier
) {
    var index by remember { mutableStateOf(0) }

    // Timer for changing text automatically
    LaunchedEffect(Unit) {
        while (true) {
            delay(200) // 1 second per text (you can make it smaller)
            index = (index + 1) % texts.size
        }
    }

    AnimatedContent(
        modifier = modifier,
        targetState = texts[index],
        transitionSpec = {
            fadeIn(animationSpec = tween(200)) with fadeOut(animationSpec = tween(200))
        },
        label = "textAnimation"
    ) { text ->
        Text(
            text = text,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(32.dp),
            style = TextStyle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Magenta, Color.Cyan, Color.White),
                    radius = 400f
                ),
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.5f),
                    offset = Offset(8f, 8f),
                    blurRadius = 12f
                )
            )
        )
    }
}


@Composable
fun BalloonTextK(
    fontSize: TextUnit = 100.sp,
    text: String = "ক",
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "colorAnim")

    // অ্যানিমেটেড কালার গ্রেডিয়েন্ট
    val color1 by infiniteTransition.animateColor(
        initialValue = Color(0xFFFF4081), // গোলাপি
        targetValue = Color(0xFF448AFF), // নীল
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color1"
    )

    val color2 by infiniteTransition.animateColor(
        initialValue = Color(0xFFFFEB3B), // হলুদ
        targetValue = Color(0xFF4CAF50), // সবুজ
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color2"
    )

    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = FontWeight.ExtraBold,
        modifier = modifier
            .padding(32.dp),
        style = TextStyle(
            color = Color.Blue,
            shadow = Shadow(
                color = Color.Black.copy(alpha = 0.5f),
                offset = Offset(8f, 8f),
                blurRadius = 12f
            )
        )
    )
}

@Composable
fun BouncingBalloonK() {
    val infiniteTransition = rememberInfiniteTransition(label = "bounceAnim")

    // লাফানোর জন্য offset অ্যানিমেশন
    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -40f, // উপরে উঠবে
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = EaseInOutQuad),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offsetY"
    )

    // কালার গ্রেডিয়েন্ট পরিবর্তন
    val color1 by infiniteTransition.animateColor(
        initialValue = Color(0xFFFF4081),
        targetValue = Color(0xFF448AFF),
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color1"
    )

    val color2 by infiniteTransition.animateColor(
        initialValue = Color(0xFFFFEB3B),
        targetValue = Color(0xFF4CAF50),
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color2"
    )

    Text(
        text = "ক",
        fontSize = 140.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(32.dp)
            .graphicsLayer {
                translationY = offsetY // লাফানো effect
            },
        style = TextStyle(
            brush = Brush.radialGradient(
                colors = listOf(color1, color2, Color.White),
                radius = 400f
            ),
            shadow = Shadow(
                color = Color.Black.copy(alpha = 0.5f),
                offset = Offset(8f, 8f),
                blurRadius = 12f
            )
        )
    )
}


@Composable
private fun AvatarLogo(
    drawable: DrawableResource,
    isSelected: Boolean = false,
    onClickAvatar: () -> Unit
) {

    val selectedBorderColor =
        if (isSelected) Color.Green else Color.LightGray

    Box(
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .border(4.dp, color = selectedBorderColor, CircleShape)
            .clickable(onClick = onClickAvatar)
    ) {
        Image(
            painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
    }

}

val avatarResList = listOf(
    Avatar("avatar_1", Res.drawable.avatar_1),
    Avatar("avatar_2", Res.drawable.avatar_2),
    Avatar("avatar_3", Res.drawable.avatar_3),
    Avatar("avatar_4", Res.drawable.avatar_4),
    Avatar("avatar_5", Res.drawable.avatar_5),
    Avatar("avatar_6", Res.drawable.avatar_6),
    Avatar("avatar_7", Res.drawable.avatar_7),
    Avatar("avatar_8", Res.drawable.avatar_8),
    Avatar("avatar_9", Res.drawable.avatar_9),
    Avatar("avatar_10", Res.drawable.avatar_10),
    Avatar("avatar_11", Res.drawable.avatar_11),
    Avatar("avatar_12", Res.drawable.avatar_12),
)

data class Avatar(val resourceName: String, val resource: DrawableResource)

val avatarFourItem = avatarResList.chunked(4)