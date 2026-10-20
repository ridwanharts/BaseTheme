package com.ridwanharts.basetheme.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridwanharts.basetheme.ui.theme.WanColors

/**
 * Item daftar chunky — padanan row RecyclerView di Compose.
 * Dipakai di dalam LazyColumn (pengganti RecyclerView di Compose):
 *
 *     LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
 *         items(siswa) { s ->
 *             ChunkyListItem(
 *                 emoji = "🧒",
 *                 title = s.nama,
 *                 subtitle = s.kelas,
 *                 onClick = { /* buka detail */ },
 *             )
 *         }
 *     }
 */
@Composable
fun ChunkyListItem(
    emoji: String,
    title: String,
    subtitle: String? = null,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
) {
    val shape = RoundedCornerShape(20.dp)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Color.White)
            .border(2.dp, WanColors.Line, shape)
            .then(if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier)
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(WanColors.Brand100),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = emoji, fontSize = 22.sp)
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = WanColors.Ink,
            )
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    color = WanColors.InkFaint,
                )
            }
        }
        trailing?.invoke()
    }
}
