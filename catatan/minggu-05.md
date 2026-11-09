# Catatan Minggu 05: Abstraction

## Yang saya kerjakan
Saya mengisi `Aset.bisaDipinjam()` (true hanya jika status TERSEDIA dan kondisi bukan RUSAK_BERAT),
lalu menjadikan `Aset` kelas abstrak dengan `hitungDenda` abstrak. Saya juga mengimplementasikan
interface `AturanDenda` lewat `DendaFlat` (sama dengan `aset.hitungDenda(hari)`) dan
`DendaProgresif` (flat ditambah persentase untuk hari di atas 7).

## Keputusan desain
- Logika hari x tarif dipindah ke `protected dendaDasar(int)` di `Aset`, karena `hitungDenda`
  sudah abstrak dan tidak bisa dipanggil lewat `super`. Subclass memanggil `dendaDasar` lalu
  mengalikan multiplier jenis (1x, 2x, 4x).
-Rumus progresif: flat + 10% x flat x (hari - 7) untuk hari > 7 (lihat docs/asumsi.md, A-08).

## Kendala
`hitungDenda` dan `getJenis` sempat terdefinisi dua kali dan `super.hitungDenda`
error setelah Aset abstrak, lalu diatasi dengan `dendaDasar`

## Penggunaan AI
- Alat yang dipakai: Claude, co pilot
- Bagian yang dibantu AI: memperbaiki dan membantu codingan`Aset` (abstrak + dendaDasar), `DendaFlat`, `DendaProgresif`
- Prompt utama: apa yang akan saya lakukan minggu ini? apa itu abstrac class dan interface ? contoh codenya seperti apa?
- Yang saya ubah atau tolak dari saran AI, dan alasannya: tidak ada
- Satu hal yang saya pahami lebih baik sekarang: `Abstract class` induk setengah jadi yang boleh punya data, constructor, dan method berisi. Hubungannya “adalah” (Ruang adalah Aset). Subclass hanya bisa extends satu.
`Interface` kontrak kemampuan tanpa data. Hubungannya “bisa” (Aset bisa dipinjam). Satu kelas boleh implements banyak.