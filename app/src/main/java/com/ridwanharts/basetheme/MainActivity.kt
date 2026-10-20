package com.ridwanharts.basetheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ridwanharts.basetheme.ui.components.ChunkyButton
import com.ridwanharts.basetheme.ui.components.ChunkyCard
import com.ridwanharts.basetheme.ui.components.ChunkySecondaryButton
import com.ridwanharts.basetheme.ui.components.ChunkyTextField
import com.ridwanharts.basetheme.ui.theme.WanColors
import com.ridwanharts.basetheme.ui.theme.WanStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WanStudioTheme {
                ThemeShowcase()
            }
        }
    }
}

/** Layar contoh: pameran semua token & komponen tema. */
@Composable
fun ThemeShowcase() {
    var input by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WanColors.Surface)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Column {
            Text(
                text = "🛠️ WanStudio BaseTheme",
                style = MaterialTheme.typography.headlineSmall,
                color = WanColors.Ink,
            )
            Text(
                text = "Tema chunky untuk semua aplikasi WanStudio",
                style = MaterialTheme.typography.bodyMedium,
                color = WanColors.InkFaint,
            )
        }

        SectionTitle("🎨 Warna")
        val swatches = listOf(
            Triple("Brand 100", WanColors.Brand100, "#D8EFFE"),
            Triple("Brand 300", WanColors.Brand300, "#5CCCFC"),
            Triple("Brand 500", WanColors.Brand500, "#1C91EC"),
            Triple("Brand 700", WanColors.Brand700, "#1C6CB4"),
            Triple("Brand 900", WanColors.Brand900, "#026996"),
            Triple("Ink", WanColors.Ink, "#1B2B3A"),
            Triple("Leaf", WanColors.Leaf, "#629959"),
            Triple("Line", WanColors.Line, "#E3E8EE"),
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            swatches.chunked(4).forEach { row ->
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    row.forEach { (name, color, hex) ->
                        Column(modifier = Modifier.weight(1f)) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(44.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(color)
                                    .border(2.dp, WanColors.Line, RoundedCornerShape(12.dp)),
                            )
                            Text(name, style = MaterialTheme.typography.labelSmall, color = WanColors.Ink)
                            Text(hex, style = MaterialTheme.typography.bodySmall, color = WanColors.InkFaint)
                        }
                    }
                }
            }
        }

        SectionTitle("🔘 Tombol")
        ChunkyButton(text = "💾 Tombol Utama", onClick = {}, modifier = Modifier.fillMaxWidth())
        ChunkySecondaryButton(text = "Tombol Sekunder", onClick = {}, modifier = Modifier.fillMaxWidth())
        ChunkyButton(text = "Nonaktif", onClick = {}, enabled = false, modifier = Modifier.fillMaxWidth())

        SectionTitle("🃏 Kartu")
        ChunkyCard(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "📚 Contoh Kartu",
                style = MaterialTheme.typography.titleMedium,
                color = WanColors.Ink,
            )
            Text(
                text = "Kartu chunky: putih, border garis 2dp, sudut 24dp, hard shadow lembut.",
                style = MaterialTheme.typography.bodyMedium,
                color = WanColors.InkSoft,
                modifier = Modifier.padding(top = 6.dp),
            )
        }

        SectionTitle("⌨️ Input")
        ChunkyTextField(
            value = input,
            onValueChange = { input = it },
            label = "Nama siswa",
            placeholder = "mis. Budi Santoso",
            modifier = Modifier.fillMaxWidth(),
        )

        SectionTitle("✍️ Tipografi")
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text("Headline — ExtraBold", style = MaterialTheme.typography.headlineSmall, color = WanColors.Ink)
            Text("Title — Bold", style = MaterialTheme.typography.titleLarge, color = WanColors.Ink)
            Text(
                "Body — teks isi biasa dengan warna InkSoft agar nyaman dibaca.",
                style = MaterialTheme.typography.bodyMedium,
                color = WanColors.InkSoft,
            )
            Text("Label — Bold kecil", style = MaterialTheme.typography.labelMedium, color = WanColors.InkFaint)
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold),
        color = WanColors.Ink,
    )
}

@Preview(showBackground = true)
@Composable
fun ThemeShowcasePreview() {
    WanStudioTheme {
        ThemeShowcase()
    }
}
