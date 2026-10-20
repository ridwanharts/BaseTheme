package com.ridwanharts.basetheme.ui.components.formal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridwanharts.basetheme.ui.theme.formal.FormalColors

/**
 * Item daftar MODE FORMAL — polos & rapi (tanpa kartu), dipisahkan
 * garis tipis. Padanan elegan dari row daftar. Pola pakai:
 *
 *     LazyColumn {
 *         items(menu) { m ->
 *             FormalListItem(title = m.judul, subtitle = m.deskripsi, onClick = { ... })
 *             HorizontalDivider(color = FormalColors.Line) // atau pakai FormalListItem terpisah
 *         }
 *     }
 *
 * Sisipkan [FormalListDivider] di antara item untuk garis pemisah.
 */
@Composable
fun FormalListItem(
    title: String,
    subtitle: String? = null,
    modifier: Modifier = Modifier,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier,
            )
            .padding(horizontal = 20.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        leading?.invoke()
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = FormalColors.Ink,
            )
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    color = FormalColors.InkFaint,
                )
            }
        }
        trailing?.invoke()
    }
}

/** Garis pemisah standar antar item daftar formal. */
@Composable
fun FormalListDivider() {
    HorizontalDivider(
        color = FormalColors.Line,
        thickness = 1.dp,
        modifier = Modifier.padding(start = 20.dp),
    )
}
