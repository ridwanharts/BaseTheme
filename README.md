# 🎨 WanStudio BaseTheme (Android)

> **Satu tema untuk semua aplikasi Android WanStudio** — gaya *chunky* ala kizupi.com dengan palet biru Edu Fia Map. 💙

Tema dasar Jetpack Compose (Material 3) yang menjadi sumber kebenaran desain untuk semua aplikasi Android WanStudio, konsisten dengan versi web: [Edu Fia Map](https://edufia-map.wanstudio.my.id/), [DokuFia](https://dokufia.wanstudio.my.id/), dan [WanStudio](https://wanstudio.my.id/).

Token desain lengkap ada di [`theme.json`](theme.json) — file yang sama juga dipakai versi web.

---

## 🎨 Token

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

## 🚀 Cara Pakai di Aplikasi Lain

1. Salin folder `ui/theme/`, `ui/components/`, dan `ui/util/` ke package aplikasimu.
2. Sesuaikan `package` di tiap file.
3. Bungkus UI dengan tema:

```kotlin
setContent {
    WanStudioTheme {
        // UI aplikasimu
    }
}
```

4. (Opsional) Samakan juga `res/values/colors.xml` & `themes.xml` untuk splash/window background.

---

## 📱 Aplikasi Demo

Module `app` berisi layar **showcase** (`MainActivity`) — pameran warna, tombol, kartu, input, dan tipografi. Jalankan untuk melihat tema secara langsung sebelum dipakai.

---

**WanStudio BaseTheme** — *dibuat dengan 💛 di Surabaya.*
