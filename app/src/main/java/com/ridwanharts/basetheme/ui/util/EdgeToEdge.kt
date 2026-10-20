package com.ridwanharts.basetheme.ui.util

import android.graphics.Color as AndroidColor
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ridwanharts.basetheme.ui.theme.WanColors

/**
 * Util edge-to-edge WanStudio.
 *
 * Pola pakai:
 * 1. Di Activity, panggil [enableWanEdgeToEdge] sebelum setContent —
 *    status bar & navigation bar jadi transparan (konten full-bleed).
 * 2. Di Compose, beri ruang aman ke konten dengan modifier
 *    [topSystemBarPadding] / [bottomSystemBarPadding] / [verticalSystemBarPadding],
 *    atau bungkus layar dengan [EdgeToEdgeBox].
 */

/**
 * Aktifkan edge-to-edge dengan ikon bar yang kontrasnya tepat:
 * tema terang -> ikon gelap, tema gelap -> ikon terang.
 * Panggil di onCreate SEBELUM setContent.
 */
fun ComponentActivity.enableWanEdgeToEdge(darkTheme: Boolean = false) {
    val style = if (darkTheme) {
        SystemBarStyle.dark(AndroidColor.TRANSPARENT)
    } else {
        SystemBarStyle.light(AndroidColor.TRANSPARENT, AndroidColor.TRANSPARENT)
    }
    enableEdgeToEdge(statusBarStyle = style, navigationBarStyle = style)
}

/** Beri padding sebesar tinggi status bar (atas saja). */
@Composable
fun Modifier.topSystemBarPadding(): Modifier =
    this.windowInsetsPadding(WindowInsets.statusBars.only(WindowInsetsSides.Top))

/** Beri padding sebesar tinggi navigation bar (bawah saja). */
@Composable
fun Modifier.bottomSystemBarPadding(): Modifier =
    this.windowInsetsPadding(WindowInsets.navigationBars.only(WindowInsetsSides.Bottom))

/** Beri padding atas (status bar) + bawah (navigation bar) sekaligus. */
@Composable
fun Modifier.verticalSystemBarPadding(): Modifier =
    this.windowInsetsPadding(
        WindowInsets.systemBars.only(
            WindowInsetsSides.Top +
                WindowInsetsSides.Bottom,
        ),
    )

/**
 * Container layar penuh edge-to-edge:
 * background digambar full-bleed sampai ke balik status/navigation bar,
 * sedangkan konten diberi padding aman di atas & bawah.
 *
 * @param topInset beri padding status bar ke konten.
 * @param bottomInset beri padding navigation bar ke konten.
 *   Matikan (false) bila di dalam konten sudah ada BottomNavigation sendiri
 *   yang menangani inset-nya.
 */
@Composable
fun EdgeToEdgeBox(
    modifier: Modifier = Modifier,
    backgroundColor: Color = WanColors.Surface,
    topInset: Boolean = true,
    bottomInset: Boolean = true,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit,
) {
    val topPadding =
        if (topInset) WindowInsets.statusBars.asPaddingValues().calculateTopPadding() else 0.dp
    val bottomPadding =
        if (bottomInset) WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() else 0.dp
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top = topPadding, bottom = bottomPadding),
        contentAlignment = contentAlignment,
        content = content,
    )
}
