package com.ridwanharts.basetheme.ui.theme.formal

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Tema MODE FORMAL (dewasa) — pasangan WanStudioTheme (mode Funny).
 * Referensi: housemait.com. Tanpa dynamic color demi konsistensi brand.
 */

private val FormalLightColors = lightColorScheme(
    primary = FormalColors.Primary,
    onPrimary = Color.White,
    primaryContainer = FormalColors.PrimaryContainer,
    onPrimaryContainer = FormalColors.OnPrimaryContainer,
    secondary = FormalColors.InkSoft,
    onSecondary = Color.White,
    secondaryContainer = FormalColors.Line,
    onSecondaryContainer = FormalColors.Ink,
    tertiary = FormalColors.Bronze,
    onTertiary = Color.White,
    background = FormalColors.Surface,
    onBackground = FormalColors.Ink,
    surface = FormalColors.Surface,
    onSurface = FormalColors.Ink,
    surfaceVariant = FormalColors.PrimaryContainer,
    onSurfaceVariant = FormalColors.InkSoft,
    surfaceContainerLowest = Color.White,
    surfaceContainerLow = Color.White,
    surfaceContainer = FormalColors.Surface,
    surfaceContainerHigh = FormalColors.Surface,
    surfaceContainerHighest = FormalColors.Surface,
    outline = FormalColors.InkFaint,
    outlineVariant = FormalColors.Line,
    error = FormalColors.Error,
    onError = Color.White,
)

private val FormalDarkColors = darkColorScheme(
    primary = Color(0xFFB79CED),
    onPrimary = FormalColors.Ink,
    primaryContainer = FormalColors.DarkSurface,
    onPrimaryContainer = FormalColors.PrimaryContainer,
    secondary = FormalColors.DarkOnSurface,
    onSecondary = FormalColors.Ink,
    tertiary = FormalColors.Bronze,
    onTertiary = Color.White,
    background = FormalColors.DarkBackground,
    onBackground = FormalColors.DarkOnSurface,
    surface = FormalColors.DarkBackground,
    onSurface = FormalColors.DarkOnSurface,
    surfaceVariant = FormalColors.DarkSurface,
    onSurfaceVariant = FormalColors.PrimaryContainer,
    surfaceContainerLowest = FormalColors.Ink,
    surfaceContainerLow = FormalColors.DarkSurface,
    surfaceContainer = FormalColors.DarkSurface,
    outline = FormalColors.DarkLine,
    outlineVariant = FormalColors.DarkLine,
    error = FormalColors.Error,
    onError = Color.White,
)

@Composable
fun FormalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) FormalDarkColors else FormalLightColors
    MaterialTheme(
        colorScheme = colorScheme,
        typography = FormalTypography,
        shapes = FormalShapes,
        content = content,
    )
}
