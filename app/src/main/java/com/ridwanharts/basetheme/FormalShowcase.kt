package com.ridwanharts.basetheme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridwanharts.basetheme.ui.components.formal.ElegantButton
import com.ridwanharts.basetheme.ui.components.formal.ElegantCard
import com.ridwanharts.basetheme.ui.components.formal.ElegantOutlinedButton
import com.ridwanharts.basetheme.ui.components.formal.ElegantTextField
import com.ridwanharts.basetheme.ui.components.formal.FormalBottomNavigation
import com.ridwanharts.basetheme.ui.components.formal.FormalListDivider
import com.ridwanharts.basetheme.ui.components.formal.FormalListItem
import com.ridwanharts.basetheme.ui.components.formal.FormalNavItem
import com.ridwanharts.basetheme.ui.theme.formal.FormalColors
import com.ridwanharts.basetheme.ui.theme.formal.FormalTheme
import com.ridwanharts.basetheme.ui.util.topSystemBarPadding

/** Layar contoh MODE FORMAL (dewasa) — referensi housemait.com. */
@Composable
fun FormalShowcase(onSwitchMode: () -> Unit = {}) {
    var input by remember { mutableStateOf("") }
    var navIndex by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FormalColors.Surface),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .topSystemBarPadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(26.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "Kehidupan keluarga,\ntertata dengan rapi.",
                    style = MaterialTheme.typography.headlineMedium,
                    color = FormalColors.Ink,
                )
                Text(
                    text = "Mode Formal — hangat, editorial, dewasa. Referensi: Housemait.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = FormalColors.InkSoft,
                )
                ElegantOutlinedButton(
                    text = "😄 Ganti ke Mode Funny",
                    onClick = onSwitchMode,
                    modifier = Modifier.padding(top = 6.dp),
                )
            }

            FormalSectionTitle("Warna")
            val swatches = listOf(
                Triple("Primary", FormalColors.Primary, "#6D37AD"),
                Triple("Ink", FormalColors.Ink, "#24202F"),
                Triple("Lavendel", FormalColors.PrimaryContainer, "#EFE9FA"),
                Triple("Perunggu", FormalColors.Bronze, "#A97C50"),
                Triple("Surface", FormalColors.Surface, "#FAF5EF"),
                Triple("Line", FormalColors.Line, "#E9E2D9"),
                Triple("Ink Soft", FormalColors.InkSoft, "#55505F"),
                Triple("Ink Faint", FormalColors.InkFaint, "#8A8494"),
            )
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                swatches.chunked(4).forEach { row ->
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        row.forEach { (name, color, hex) ->
                            Column(modifier = Modifier.weight(1f)) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(44.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(color)
                                        .border(1.dp, FormalColors.Line, RoundedCornerShape(10.dp)),
                                )
                                Text(name, style = MaterialTheme.typography.labelSmall, color = FormalColors.Ink)
                                Text(hex, style = MaterialTheme.typography.bodySmall, color = FormalColors.InkFaint)
                            }
                        }
                    }
                }
            }

            FormalSectionTitle("Tombol")
            ElegantButton(text = "Unduh Aplikasi", onClick = {}, modifier = Modifier.fillMaxWidth())
            ElegantOutlinedButton(text = "Lihat Cara Kerja", onClick = {}, modifier = Modifier.fillMaxWidth())
            ElegantButton(text = "Nonaktif", onClick = {}, enabled = false, modifier = Modifier.fillMaxWidth())

            FormalSectionTitle("Kartu")
            ElegantCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Ringkasan Minggu Ini",
                    style = MaterialTheme.typography.titleMedium,
                    color = FormalColors.Ink,
                )
                Text(
                    text = "Kartu elegan: putih, sudut 20dp, garis tipis hangat, dan bayangan yang sangat lembut.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = FormalColors.InkSoft,
                    modifier = Modifier.padding(top = 6.dp),
                )
            }

            FormalSectionTitle("Input")
            ElegantTextField(
                value = input,
                onValueChange = { input = it },
                label = "Nama lengkap",
                placeholder = "mis. Sarah Wijaya",
                modifier = Modifier.fillMaxWidth(),
            )

            FormalSectionTitle("Daftar")
            val menu = listOf(
                Triple("Kalender Keluarga", "3 acara minggu ini", "📅"),
                Triple("Daftar Belanja", "12 item belum dibeli", "🛒"),
                Triple("Tugas Rumah", "2 tugas menunggu", "🧹"),
                Triple("Menu Makan", "Rencana 7 hari", "🍽️"),
                Triple("Pengingat", "Tagihan listrik besok", "🔔"),
                Triple("Catatan", "5 catatan tersimpan", "📝"),
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(FormalColors.Raised)
                    .border(1.dp, FormalColors.Line, RoundedCornerShape(20.dp)),
            ) {
                items(menu) { (judul, deskripsi, emoji) ->
                    FormalListItem(
                        title = judul,
                        subtitle = deskripsi,
                        leading = { Text(emoji, fontSize = 20.sp) },
                        trailing = {
                            Text("›", fontSize = 22.sp, color = FormalColors.InkFaint)
                        },
                        onClick = {},
                    )
                    FormalListDivider()
                }
            }
        }

        FormalBottomNavigation(
            items = listOf(
                FormalNavItem("Beranda") {
                    Text("🏠", fontSize = 20.sp, color = LocalContentColor.current)
                },
                FormalNavItem("Jadwal") {
                    Text("📅", fontSize = 20.sp, color = LocalContentColor.current)
                },
                FormalNavItem("Pesan") {
                    Text("💬", fontSize = 20.sp, color = LocalContentColor.current)
                },
                FormalNavItem("Profil") {
                    Text("👤", fontSize = 20.sp, color = LocalContentColor.current)
                },
            ),
            selectedIndex = navIndex,
            onSelect = { navIndex = it },
        )
    }
}

@Composable
private fun FormalSectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        color = FormalColors.Ink,
    )
}

@Preview(showBackground = true)
@Composable
fun FormalShowcasePreview() {
    FormalTheme {
        FormalShowcase()
    }
}
