# Catatan Minggu 02: Struktur OOP: Class, Object, Encapsulation


## Yang saya kerjakan
Yang saya kerjakan minggu ini yaitu membuat/melengkapi class `aset` di `Aset.java` dengan field private : `kode, nama, status, dan kondisi`, kemudian saya menulis konstruktor `Aset(kode, nama)` yang akan menolak kode atau nama yang null/kosong dengan `IllegalArgumentException`, dan juga membuat getter untuk semua field (`getKode() , getNama(), getStatus(), getKondisi()`), serta juga membuat setter (`setNama(), setStatus(), setKondisi()`).

Kemudian di `core/src/test/java/id/ac/upb/asetpinjam/Minggu02AsetTest.java` saya menjalankan `.\scripts\uji.ps1` di PowerShell
dan hasil nya semua kode lulus.

## Keputusan desain
Field `kode` saya buat `private final`, jadi nilainya hanya bisa diisi sekali lewat konstruktor. Ini cocok dengan aturan bahwa kode tidak boleh punya setter, karena kode itu pengenal aset yang seharusnya tidak boleh berubah.
- Saya memakai `isBlank()` dan bukan `isEmpty()`, supaya nama atau kode yang hanya berisi spasi juga ditolak.

## Kendala
Masih perlu memperlajari bahasa pemrograman java lebih serius, dan masih perlu memahami lebih dalam lagi program yang sedang saya buat.

## Penggunaan AI
- Alat yang dipakai: Claude Ai 
- Bagian yang dibantu AI: Penjelasan tugas yang akan saya kerjakan, Source code, konstruktor, getter, dan setter pada class `Aset`, serta penjelasan konsep class, object, dan encapsulation.
- Prompt utama: 
  1. "Tolong jelaskan ke saya pada minggu ini saya harus apa?"
  2. "Ini kodenya harus dilengkapi, apa saja yang harus saya isi?"
  3. "kenapa kode tidak ada setter?"
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Tidak ada
- Satu hal yang saya pahami lebih baik sekarang: encapsulation tidak hanya membuat field private, tapi memastikan data hanya bisa berubah lewat method yang memeriksanya dulu. Jadi object `Aset` tidak akan pernah berada dalam keadaan tidak valid, misalnya tanpa nama atau dengan status null. Jadi yang saya pahami encapsulation itu seperti Analogi sebuah mesin ATM. Uang = data (private), tombol ATM = method (getter/setter), pengecekan PIN dan saldo = validasi.
