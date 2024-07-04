package com.kunal.chateo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kunal.chateo.R

// Set of Material typography styles to start with

val mulishFontFamily = FontFamily(
    Font(R.font.mulish_regular, weight = FontWeight.Normal),
    Font(R.font.mulish_semibold, weight = FontWeight.SemiBold),
    Font(R.font.mulish_bold, weight = FontWeight.Bold)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = mulishFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    displayMedium = TextStyle(
        fontFamily = mulishFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = mulishFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = mulishFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = mulishFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = mulishFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    labelLarge = TextStyle(
        fontFamily = mulishFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    labelMedium = TextStyle(
        fontFamily = mulishFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),

    labelSmall = TextStyle(
        fontFamily = mulishFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp
    ),

    )

