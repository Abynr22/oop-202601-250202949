# Catatan Minggu 03: Inheritance

## Yang saya kerjakan
Saya mengisi tiga subclass dari `Aset`, yaitu `Ruang`, `Laptop`, dan `AlatLab`. Setiap konstruktor memanggil `super(kode, nama)`, lalu memvalidasi field miliknya sendiri: kapasitas harus > 0, spesifikasi dan nomor inventaris tidak boleh kosong, laboratorium tidak boleh kosong, dan tingkat risiko tidak boleh null. Setiap class juga meng-override `getJenis()` dan mengembalikan nilai enum `JenisAset` yang sesuai. Hasil `Minggu03HierarkiTest`: Berhasil semuanya.

## Keputusan desain
- `kode` dan `nama` tetap di `Aset` karena semua jenis aset memilikinya. Field lain (`kapasitas`, `spesifikasi`, `nomorInventaris`, `laboratorium`, `tingkatRisiko`) hanya relevan untuk satu jenis, jadi ada di subclass.

## Kendala
awalnya saya belum tahu apakah `getJenis()` mengembalikan `String` atau enum, dan baru jelas setelah membaca file tes. Dan sedikit kesalahan syntax pada bagian laboratorium , saya mengira menggunakan huruf "L" ternyata "l" yang menyebabkan sedkit eror pada source code.

## Penggunaan AI
- Alat yang dipakai: Claude, Co pilot
- Bagian yang dibantu AI: konstruktor, getter, dan `getJenis()` pada `Ruang`, `Laptop`, `AlatLab`; penjelasan konsep inheritance; dan panduan mengisi catatan ini.
- Prompt utama:
  1. "Pada minggu ini saya disuruh ngerjain apa? dan apa itu inheritance".
  2. "Kenapa kode bagian ini eror?"
- Tidak ada yang saya tolak
- Satu hal yang saya pahami lebih baik sekarang: `super(kode, nama)` harus berada di baris pertama konstruktor karena bagian induk objek harus selesai dibuat dan divalidasi dulu sebelum subclass menambahkan field-nya sendiri. Karena itu validasi `Aset` otomatis berlaku di semua subclass tanpa ditulis ulang.