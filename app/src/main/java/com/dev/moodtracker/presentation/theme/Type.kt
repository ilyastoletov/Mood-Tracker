package com.dev.moodtracker.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dev.moodtracker.R

// Set of Material typography styles to start with
val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.inter_600)
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)