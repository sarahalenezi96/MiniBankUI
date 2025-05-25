package com.coded.minibankui.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.coded.minibankui.R

private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFF003366),
    secondary = Color(0xFFFF5252),
    background = Color(0xFF001F3F),
    surface = Color(0xFF001F3F),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)



@Composable
fun MiniBankUITheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorPalette,
        content = content
    )
}