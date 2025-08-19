package com.asl.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import childedu.common.ui.generated.resources.Res
import childedu.common.ui.generated.resources.antic_slab
import childedu.common.ui.generated.resources.bungee_shade
import childedu.common.ui.generated.resources.chela_one
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.ExperimentalResourceApi

@Composable
@OptIn(ExperimentalResourceApi::class)
fun customFontFamilyBungee() = FontFamily(
    Font(Res.font.bungee_shade, weight = FontWeight.ExtraBold),
)

@Composable
@OptIn(ExperimentalResourceApi::class)
fun customFontFamilyChelaOne() = FontFamily(
    Font(Res.font.chela_one, weight = FontWeight.Light),
)

@Composable
@OptIn(ExperimentalResourceApi::class)
fun customFontFamilyAnticSlab() = FontFamily(
    Font(Res.font.antic_slab, weight = FontWeight.Light),
)

@Composable
fun MediumText(
    text: String,
    modifier: Modifier = Modifier,
    fillColor: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 35.sp,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        text = text,
        modifier = modifier,
        color = fillColor,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily = customFontFamilyAnticSlab(),
        textAlign = textAlign,
        letterSpacing = TextUnit(2f, type = TextUnitType.Sp),
    )
}

@Composable
fun OutlineText(
    text: String,
    modifier: Modifier = Modifier,
    fillColor: Color = Color.White,
    fontSize: TextUnit = 35.sp,
    textAlign: TextAlign = TextAlign.Center,
    colors: List<Color> = listOf(Color.Blue, Color.Red, Color.Magenta),
) {

    Text(
        text = text,
        modifier = modifier,
        color = fillColor,
        fontSize = fontSize,
        fontFamily = customFontFamilyBungee(),
        textAlign = textAlign,
        letterSpacing = TextUnit(2f, type = TextUnitType.Sp),
        style = TextStyle(
            brush = Brush.linearGradient(colors = colors),
        )
    )
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier.fillMaxWidth(fraction = 0.8f),
    value: String,
    placeholder: String = "",
    onValueChange: () -> Unit
) {
    TextField(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, Color.Blue, RoundedCornerShape(12.dp))
            .background(Color.Black),
        value = value,
        onValueChange = { },
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray,
                style = TextStyle(
                    fontFamily = customFontFamilyAnticSlab(),
                    fontSize = 18.sp,
                    letterSpacing = 2.sp
                )
            )
        },
        textStyle = TextStyle(
            fontFamily = customFontFamilyAnticSlab(),
            fontSize = 18.sp,
            color = Color.Blue,
            letterSpacing = 2.sp,
        ),
        singleLine = true,
    )
}