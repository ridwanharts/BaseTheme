package com.ridwanharts.basetheme.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridwanharts.basetheme.ui.theme.WanColors

/** Satu item bottom navigation — ikon berupa emoji, sesuai bahasa desain WanStudio. */
data class ChunkyNavItem(
    val emoji: String,
    val label: String,
)

/**
 * Bottom navigation chunky model melayang (floating):
 * kartu putih radius 24dp + border garis + hard shadow lembut.
 *
 * Tempatkan di bawah layar (mis. Modifier.align(Alignment.BottomCenter)
 * di dalam Box, atau bottomBar Scaffold) dan beri padding bawah sendiri,
 * mis. .padding(horizontal = 16.dp) + Modifier.bottomSystemBarPadding()
 * dari util EdgeToEdge bila perlu ruang navigation bar sistem.
 */
@Composable
fun ChunkyBottomNavigation(
    items: List<ChunkyNavItem>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val barShape = RoundedCornerShape(24.dp)
    Row(
        modifier = modifier
            .chunkyShadow(offset = 4.dp, color = WanColors.ShadowCard, radius = 24.dp)
            .clip(barShape)
            .background(Color.White)
            .border(2.dp, WanColors.Line, barShape)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items.forEachIndexed { index, item ->
            val selected = index == selectedIndex
            val pillColor by animateColorAsState(
                targetValue = if (selected) WanColors.Brand500 else Color.Transparent,
                label = "navPill",
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(pillColor)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ) { onSelect(index) }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                ) {
                    Text(text = item.emoji, fontSize = 20.sp)
                    Text(
                        text = item.label,
                        fontSize = 11.sp,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                        color = if (selected) Color.White else WanColors.InkFaint,
                    )
                }
            }
        }
    }
}
