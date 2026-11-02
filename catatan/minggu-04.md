# Catatan Minggu 04: Polymorphism

## Yang saya kerjakan
Saya meng-override `hitungDenda(int)` di tiga subclass `Aset` (Ruang, Laptop, AlatLab)
dengan multiplier masing-masing 1x, 2x, dan 4x. Versi induk di `Aset` menghitung
hari x tarif dari `Varian.aktif().dendaPerHari` dan menolak hari negatif dengan
`IllegalArgumentException`. Di `KatalogAset` saya membuat dua overload `cari(kata)`
dan `cari(kata, jenis)` yang mencocokkan nama tanpa membedakan huruf besar atau kecil.

## Keputusan desain
Keputusan teknis saya:
- Subclass memanggil `super.hitungDenda(...)` lalu mengalikan multiplier, supaya validasi
  hari negatif dan pembacaan tarif cukup ditulis sekali di `Aset`.
- `hariTerlambat` di-cast ke `long` sebelum dikali tarif agar tidak overflow pada `int`.
- `cari(kata, jenis)` memakai `cari(kata)` lalu menyaring berdasarkan `getJenis()`,
  sehingga logika pencocokan nama tidak ditulis dua kali.
- Pencarian memakai `toLowerCase(Locale.ROOT)` agar hasilnya konsisten.

## Kendala
Awalnya saya bingung kenapa ada `* 1`, `* 2`, dan `* 4` di tiap subclass. Setelah
ditelusuri, itu adalah multiplier jenis dari aturan denda, sedangkan hari x tarif
dikerjakan di versi induk. Selain itu, `cari(kata, jenis)` bergantung pada `getJenis()`
yang merupakan tugas minggu 3, jadi saya memastikan ketiga subclass sudah
meng-override-nya.

## Penggunaan AI
- Alat yang dipakai: Claude (Penjelasan, catatan), Co pilot (code)
- Bagian yang dibantu AI: `Aset.hitungDenda`, override `hitungDenda` di Ruang/Laptop/AlatLab,
  dan `KatalogAset.cari` (dua overload).

- Prompt utama:
  1. "Pada Week 4 ini apa yang saya harus kerjakan?" (disertai isi docs minggu 4)
  2. "ini kurang apa" (disertai kode `Aset.java`)
  3. "coba bantu saya sesuaikan dengan code ini" (disertai `Minggu04PolimorfismeTest`)

- Yang saya ubah atau tolak dari saran AI, dan alasannya: Tidak ada yang saya tolak
- Satu hal yang saya pahami lebih baik sekarang: perbedaan overriding dan overloading.
  Overriding dipilih saat runtime berdasarkan objek aslinya (dynamic binding), sehingga
  `aset.hitungDenda(3)` menghasilkan nilai berbeda untuk tiap jenis. Overloading dipilih
  saat compile time berdasarkan daftar parameter, seperti `cari(kata)` dan `cari(kata, jenis)`.