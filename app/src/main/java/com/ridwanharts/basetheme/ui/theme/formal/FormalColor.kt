package com.ridwanharts.basetheme.ui.theme.formal

import androidx.compose.ui.graphics.Color

/**
 * Token warna MODE FORMAL (dewasa) — referensi: housemait.com.
 * Hangat, editorial, tenang: krem gading, ink ungu-gelap, aksen ungu.
 * Sumber token: theme-formal.json di root repo.
 */
object FormalColors {
    // Aksen utama (ungu Housemait, diambil dari tombol CTA aslinya)
    val Primary = Color(0xFF6D37AD)
    val PrimaryDark = Color(0xFF5A2B93) // keadaan tertekan
    val PrimaryContainer = Color(0xFFEFE9FA) // lavendel lembut
    val OnPrimaryContainer = Color(0xFF3B1F5C)

    // Tinta (teks)
    val Ink = Color(0xFF24202F)
    val InkSoft = Color(0xFF55505F)
    val InkFaint = Color(0xFF8A8494)

    // Permukaan
    val Surface = Color(0xFFFAF5EF) // krem gading hangat
    val Raised = Color(0xFFFFFFFF)
    val Line = Color(0xFFE9E2D9) // garis hangat tipis

    // Aksen sekunder hangat
    val Bronze = Color(0xFFA97C50)
    val Error = Color(0xFFB3261E)

    // Dark mode
    val DarkBackground = Color(0xFF1B1724)
    val DarkSurface = Color(0xFF262032)
    val DarkOnSurface = Color(0xFFF2EDE6)
    val DarkLine = Color(0xFF3A334A)
}
