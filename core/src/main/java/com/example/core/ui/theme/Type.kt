package com.example.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.core.R

val DecaFontFamily = FontFamily(
    Font(R.font.deca_regular, FontWeight.Normal),
    Font(R.font.deca_semibold, FontWeight.SemiBold)
)

val AppTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = DecaFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = DecaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)