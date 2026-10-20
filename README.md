# 🎨 WanStudio BaseTheme (Android)

> **Satu tema untuk semua aplikasi Android WanStudio** — gaya *chunky* ala kizupi.com dengan palet biru Edu Fia Map. 💙

Tema dasar Jetpack Compose (Material 3) yang menjadi sumber kebenaran desain untuk aplikasi-aplikasi Android WanStudio.

---

## 🎭 Dua Mode Template

Repo ini berisi **dua template tema** — pilih sesuai target pengguna aplikasimu:

| | 😄 Mode FUNNY (anak-anak) | 🎩 Mode FORMAL (dewasa) |
|---|---|---|
| Tema | `WanStudioTheme` | `FormalTheme` |
| Paket | `ui.theme`, `ui.components` | `ui.theme.formal`, `ui.components.formal` |
| Gaya | Chunky ala kizupi.com: border tebal 2dp, hard shadow tegas, sudut sangat bulat | Elegan ala [Housemait](https://onepagelove.com/housemait): krem gading, serif, shadow lembut |
| Warna utama | Biru `#1C91EC` | Ungu `#6D37AD` |
| Font heading | Sans extra-bold | Serif semi-bold |
| Tombol | Kotak bulat 18dp + efek tertekan | Pill penuh + soft shadow |
| Token | [`theme.json`](theme.json) — sama dengan versi web ([Edu Fia Map](https://edufia-map.wanstudio.my.id/), [DokuFia](https://dokufia.wanstudio.my.id/), [WanStudio](https://wanstudio.my.id/)) | [`theme-formal.json`](theme-formal.json) |

Kedua mode punya komponen sejajar: tombol utama/sekunder, kartu, text field, bottom navigation, dan item daftar — jadi berpindah mode tidak mengubah struktur layar, hanya paket import-nya.

Catatan font Formal: di situs aslinya heading memakai **Recoleta**. Di Android, `FontFamily.Serif` bawaan dipakai sebagai pengganti; bila punya file font Recoleta, taruh di `res/font/` dan ganti di `FormalType.kt`.

---

## 🎨 Token Mode Funny

| Token | Nilai |
|---|---|
| Primary | `#1C91EC` (Brand 500) |
| Outline & hard shadow | `#026996` (Brand 900) |
| Surface | `#F5F5F2` (krem hangat) |
| Raised / kartu | `#FFFFFF` |
| Line | `#E3E8EE` |
| Teks | `#1B2B3A` (Ink) |
| Aksen | `#629959` (Leaf) |
| Radius tombol | 18dp |
| Radius kartu | 24dp |
| Radius input | 16dp |

Prinsip gaya: **border tebal 2dp**, **hard shadow tanpa blur** (offset tegas 4dp), **sudut sangat membulat**, heading **extra-bold**.

Bentuk dipetakan ke slot Material 3 (`ChunkyShapes`), jadi komponen bawaan (Button, Card, TextField, Dialog) otomatis ikut gaya chunky. Dynamic color sengaja dimatikan agar brand konsisten.

---

## 🧩 Komponen

Di `ui/components/Chunky.kt`:

```kotlin
// Tombol utama — saat ditekan bayangan menghilang (efek tertekan)
ChunkyButton(text = "💾 Simpan", onClick = { /* ... */ })

// Tombol sekunder (putih)
ChunkySecondaryButton(text = "Batal", onClick = { /* ... */ })

// Kartu
ChunkyCard {
    Text("📚 Judul kartu")
    Text("Isi kartu...")
}

// Input
ChunkyTextField(value = nama, onValueChange = { nama = it }, label = "Nama")
```

Plus modifier `Modifier.chunkyShadow(offset, color, radius)` untuk bayangan tegas di komponen kustom.

---

## 🧭 Navigasi Bawah & Daftar

**Bottom navigation chunky** (`ui/components/ChunkyNavigation.kt`) — model melayang, kartu putih radius 24dp + hard shadow:

```kotlin
var tab by remember { mutableIntStateOf(0) }

ChunkyBottomNavigation(
    items = listOf(
        ChunkyNavItem("🏠", "Beranda"),
        ChunkyNavItem("📋", "Absensi"),
        ChunkyNavItem("🧾", "Tagihan"),
        ChunkyNavItem("⚙️", "Setelan"),
    ),
    selectedIndex = tab,
    onSelect = { tab = it },
    modifier = Modifier.bottomSystemBarPadding(), // dari ui/util/EdgeToEdge.kt
)
```

**Daftar (LazyColumn)** (`ui/components/ChunkyList.kt`) — padanan RecyclerView di Compose:

```kotlin
LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
    items(siswa) { s ->
        ChunkyListItem(
            emoji = "🧒",
            title = s.nama,
            subtitle = s.kelas,
            onClick = { /* buka detail */ },
        )
    }
}
```

---

## 📐 Util Edge-to-Edge

Di `ui/util/EdgeToEdge.kt` — konten full-bleed sampai ke balik status bar & navigation bar, tapi tetap aman tidak tertutup:

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableWanEdgeToEdge() // bar transparan + ikon kontras otomatis
        setContent { WanStudioTheme { /* ... */ } }
    }
}
```

Modifier padding inset untuk konten:

```kotlin
Modifier.topSystemBarPadding()       // ruang sebesar status bar (atas)
Modifier.bottomSystemBarPadding()    // ruang sebesar navigation bar (bawah)
Modifier.verticalSystemBarPadding()  // atas + bawah sekaligus
```

Atau bungkus layar dengan container — background full-bleed, konten diberi padding aman:

```kotlin
EdgeToEdgeBox {
    // konten layarmu
}
```

---

## 🎩 Komponen Mode Formal

Di `ui/components/formal/`:

```kotlin
ElegantButton(text = "Unduh Aplikasi", onClick = { })
ElegantOutlinedButton(text = "Lihat Cara Kerja", onClick = { })

ElegantCard {
    Text("Ringkasan Minggu Ini")
}

ElegantTextField(value = nama, onValueChange = { nama = it }, label = "Nama lengkap")

FormalBottomNavigation(
    items = listOf(
        FormalNavItem("Beranda") { Icon(/* ... */) },
        FormalNavItem("Profil") { Icon(/* ... */) },
    ),
    selectedIndex = tab,
    onSelect = { tab = it },
)

FormalListItem(title = "Kalender Keluarga", subtitle = "3 acara minggu ini", onClick = { })
FormalListDivider()
```

---

## 🚀 Cara Pakai di Aplikasi Lain

1. Pilih mode: salin folder tema yang sesuai ke package aplikasimu.
   - Funny: `ui/theme/` + `ui/components/`
   - Formal: `ui/theme/formal/` + `ui/components/formal/`
   - Keduanya juga memakai `ui/util/` (edge-to-edge).
2. Sesuaikan `package` di tiap file.
3. Bungkus UI dengan tema mode pilihanmu:

```kotlin
setContent {
    WanStudioTheme {   // mode Funny
        // UI aplikasimu
    }
    // atau
    FormalTheme {      // mode Formal
        // UI aplikasimu
    }
}
```

4. (Opsional) Samakan juga `res/values/colors.xml` & `themes.xml` untuk splash/window background.

---

## 📱 Aplikasi Demo

Module `app` berisi layar **showcase** (`MainActivity`) — pameran warna, tombol, kartu, input, tipografi, daftar, dan navigasi bawah untuk **kedua mode**, lengkap dengan tombol saklar untuk berpindah mode Funny ↔ Formal. Jalankan untuk melihat tema secara langsung sebelum dipakai.

---

**WanStudio BaseTheme** — *dibuat dengan 💛 di Surabaya.*
