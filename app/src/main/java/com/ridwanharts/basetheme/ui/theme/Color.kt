package com.ridwanharts.basetheme.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * WanStudio Chunky — design tokens (sumber: theme.json).
 * Dipakai semua aplikasi WanStudio agar konsisten dengan web (Edu Fia Map, DokuFia).
 */
object WanColors {
    // Brand (biru Edu Fia Map)
    val Brand100 = Color(0xFFD8EFFE)
    val Brand200 = Color(0xFFAEDEFF)
    val Brand300 = Color(0xFF5CCCFC)
    val Brand400 = Color(0xFF38A9F0)
    val Brand500 = Color(0xFF1C91EC) // primary
    val Brand600 = Color(0xFF1A7FD0)
    val Brand700 = Color(0xFF1C6CB4)
    val Brand800 = Color(0xFF14568C)
    val Brand900 = Color(0xFF026996) // outline & hard shadow

    // Tinta (teks)
    val Ink = Color(0xFF1B2B3A)
    val InkSoft = Color(0xFF3D5266)
    val InkFaint = Color(0xFF7D93A8)

    // Permukaan
    val Surface = Color(0xFFF5F5F2) // krem hangat
    val Raised = Color(0xFFFFFFFF)
    val Line = Color(0xFFE3E8EE)

    // Aksen & error
    val Leaf = Color(0xFF629959)
    val Error = Color(0xFFD64545)

    // Shadow kartu (hard shadow lembut)
    val ShadowCard = Color(0xFFD7DEE6)

    // Dark mode
    val DarkBackground = Color(0xFF121F2A)
    val DarkSurface = Color(0xFF1B2B3A)
    val DarkOnSurface = Color(0xFFE8EFF5)
    val DarkLine = Color(0xFF2E4257)
}
