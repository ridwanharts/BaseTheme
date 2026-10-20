package com.ridwanharts.basetheme.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Bentuk chunky — sudut sangat membulat.
 *
 * Dipetakan ke slot Material 3 agar komponen bawaan otomatis ikut gaya:
 * - extraSmall (16dp): TextField, chip
 * - small (18dp): Button
 * - medium (24dp): Card
 * - large (28dp): FAB, bottom sheet
 * - extraLarge (32dp): dialog
 */
val ChunkyShapes = Shapes(
    extraSmall = RoundedCornerShape(16.dp),
    small = RoundedCornerShape(18.dp),
    medium = RoundedCornerShape(24.dp),
    large = RoundedCornerShape(28.dp),
    extraLarge = RoundedCornerShape(32.dp),
)

/** Radius standar komponen chunky kustom. */
object ChunkyRadius {
    val Button = 18.dp
    val Card = 24.dp
    val Input = 16.dp
    val IconBox = 16.dp
}
