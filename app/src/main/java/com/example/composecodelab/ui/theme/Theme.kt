package com.example.composecodelab.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Red900Dark,
    primaryVariant = Red900,
    secondary = DeepPurple900Dark,
    background = BlueGray900,
    onBackground = Pink50,
    surface = BlueGray800,
    onSurface = Indigo50
)

private val LightColorPalette = lightColors(
    primary = Red900,
    primaryVariant = Red900Dark,
    secondary = DeepPurple900,
    onPrimary = Pink50,
    onSecondary = Indigo50


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ComposeCodeLabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}