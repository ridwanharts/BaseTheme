package com.ridwanharts.basetheme.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Tema WanStudio Chunky.
 *
 * Sengaja TIDAK memakai dynamic color agar identitas brand konsisten
 * di semua perangkat & semua aplikasi WanStudio.
 */

private val WanLightColors = lightColorScheme(
    primary = WanColors.Brand500,
    onPrimary = Color.White,
    primaryContainer = WanColors.Brand100,
    onPrimaryContainer = WanColors.Brand900,
    secondary = WanColors.Brand700,
    onSecondary = Color.White,
    secondaryContainer = WanColors.Brand200,
    onSecondaryContainer = WanColors.Brand800,
    tertiary = WanColors.Leaf,
    onTertiary = Color.White,
    background = WanColors.Surface,
    onBackground = WanColors.Ink,
    surface = WanColors.Surface,
    onSurface = WanColors.Ink,
    surfaceVariant = WanColors.Brand100,
    onSurfaceVariant = WanColors.InkSoft,
    surfaceContainerLowest = Color.White,
    surfaceContainerLow = Color.White,
    surfaceContainer = WanColors.Surface,
    surfaceContainerHigh = WanColors.Surface,
    surfaceContainerHighest = WanColors.Surface,
    outline = WanColors.Brand900,
    outlineVariant = WanColors.Line,
    error = WanColors.Error,
    onError = Color.White,
)

private val WanDarkColors = darkColorScheme(
    primary = WanColors.Brand300,
    onPrimary = WanColors.Ink,
    primaryContainer = WanColors.Brand800,
    onPrimaryContainer = WanColors.Brand100,
    secondary = WanColors.Brand300,
    onSecondary = WanColors.Ink,
    tertiary = WanColors.Leaf,
    onTertiary = Color.White,
    background = WanColors.DarkBackground,
    onBackground = WanColors.DarkOnSurface,
    surface = WanColors.DarkBackground,
    onSurface = WanColors.DarkOnSurface,
    surfaceVariant = WanColors.DarkSurface,
    onSurfaceVariant = WanColors.Brand200,
    surfaceContainerLowest = WanColors.Ink,
    surfaceContainerLow = WanColors.DarkSurface,
    surfaceContainer = WanColors.DarkSurface,
    outline = WanColors.Brand300,
    outlineVariant = WanColors.DarkLine,
    error = WanColors.Error,
    onError = Color.White,
)

@Composable
fun WanStudioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) WanDarkColors else WanLightColors
    MaterialTheme(
        colorScheme = colorScheme,
        typography = WanTypography,
        shapes = ChunkyShapes,
        content = content,
    )
}
