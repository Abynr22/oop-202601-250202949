# Asumsi dan Keputusan Desain

Isi bagian ini sendiri. Satu entri per keputusan. Dinilai dari kejelasan alasan dan konsistensi dengan kode dan tes Anda,
bukan dari jawaban "benar".

Format tiap entri:

```
## A-NN: judul singkat
- Pertanyaan: ...
- Keputusan: ...
- Alasan: ...
- Dampak ke kode: ... (kelas/metode)
- Tes yang membuktikan: ... (nama tes di folder mahasiswa/)
```

## Aturan ambigu dari docs/aturan-bisnis.md

Salin setiap pertanyaan ambigu (nomor 1 sampai 7) ke sini dan jawab. Contoh:
## A-01: batas waktu bentrok
- Pertanyaan: 09:00-11:00 dan 11:00-13:00 pada aset yang sama bentrok atau tidak?
- Keputusan: Tidak bentrok. 
- Alasan: Aset dikembalikan tepat pukul 11:00, jadi peminjam berikutnya wajar langsung memakainya pada 11:00. Aturan pasti nomor 4 hanya menyebut rentang yang "jelas tumpang tindih", dan dua rentang yang hanya bersentuhan di satu titik waktu tidak tumpang tindih. 
- Dampak ke kode: Pemeriksaan bentrok di `JadwalPeminjaman` memakai pembanding `<` (bukan `<=`). Aset yang berbeda tidak pernah dibandingkan.
- Tes yang membuktikan: `BatasBentrokTest.selesaiSamaDenganMulai` (folder mahasiswa/, hapus `@Disabled` setelah diisi).

## A-02: kode tetap, tanpa setter
- Pertanyaan: Bolehkah kode aset diubah setelah objek dibuat?
- Keputusan: Tidak.
- Alasan: Kode adalah identitas aset. Kalau identitas berubah, referensi dari peminjaman dan katalog bisa menunjuk ke aset yang salah.
- Dampak ke kode: Aset.kode (`final`), tidak ada `setKode`.
- Tes yang membuktikan: Minggu02AsetTest.semuaFieldPrivatDanKodeTidakBisaDiubah

## A-03: rumus denda progresif
- Pertanyaan: Bagaimana denda bertambah bila makin lama terlambat?
- Keputusan: Sampai hari ke-7 sama dengan flat. Setelah itu denda = flat + 10% x flat x (hari - 7). 0 hari = 0.
- Alasan: Ada toleransi seminggu, lalu denda naik bertahap dan mudah diprediksi. Rumus memenuhi syarat tes: tidak pernah di bawah flat, tidak turun saat hari bertambah, dan pada hari ke-30 lebih mahal dari flat (flat > 0 karena tarif varian 6.000).
- Dampak ke kode: DendaProgresif.hitung (BATAS_HARI = 7, PERSEN_TAMBAHAN = 10).
- Tes yang membuktikan: Minggu05AbstraksiTest.dendaProgresifMemenuhiSyaratMinimal



## Asumsi lain

Tambahkan di sini keputusan lain yang Anda ambil: rumus denda progresif, perubahan skema database, format error API, dan seterusnya.
