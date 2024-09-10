package edu.android_security.ui.theme

import android.window.SplashScreen
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val SplashScreenHeading = TextStyle(
    fontFamily = FontFamily.Default, // Replace with FontFamily("Inter") if you have it
    fontWeight = FontWeight.W400, // Equivalent to font-weight: 400
    fontSize = 32.sp, // Equivalent to font-size: 32px
    lineHeight = 38.73.sp, // Set line-height
    textAlign = TextAlign.Center // Align text to the center
)