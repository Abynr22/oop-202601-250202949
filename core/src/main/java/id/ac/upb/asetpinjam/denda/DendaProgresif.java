package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 5: denda yang makin berat bila makin lama terlambat.
 *
 * <p>Rumus progresifnya KEPUTUSAN ANDA (catat di docs/asumsi.md). Syarat minimal yang diuji:
 * 0 hari = 0; tidak pernah lebih murah dari DendaFlat; tidak pernah turun saat hari bertambah.
 */
public class DendaProgresif implements AturanDenda {
    private static final int BATAS_HARI = 7;
    private static final int PERSEN_TAMBAHAN = 10;  
    
@Override
public long hitung(Aset aset, int hari) {
    long flat = aset.hitungDenda(hari);   // validasi hari negatif tetap dari Aset
    if (hari <= 0) {
        return 0;
    }
    long hariLewat = Math.max(0, hari - BATAS_HARI);
    return flat + (flat * hariLewat * PERSEN_TAMBAHAN) / 100;
}
    }
    
    


