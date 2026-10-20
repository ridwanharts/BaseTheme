package com.ridwanharts.basetheme.ui.theme.formal

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Bentuk MODE FORMAL — lembut & dewasa:
 * - extraSmall (14dp): TextField
 * - small (pill 50%): Button — pill penuh ala Housemait
 * - medium (20dp): Card
 * - large (24dp): bottom sheet / FAB
 * - extraLarge (28dp): dialog
 */
val FormalShapes = Shapes(
    extraSmall = RoundedCornerShape(14.dp),
    small = RoundedCornerShape(percent = 50),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(28.dp),
)
