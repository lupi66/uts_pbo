import java.util.ArrayList; 

class Fungsi {
    // Method tunggal yang akan dipakai bersama dalam Petugas dan Anggota untuk menampilkan semua buku
    public void tampilkanSemuaBuku(ArrayList<Buku> daftar) {
        System.out.println("\n--- Daftar Koleksi Perpustakaan ---");
        for (Buku b : daftar) {
            b.tampilkanInfo(); 
        }
    }

    // Method Overloading versi 1 untuk peminjaman dengan 1 buku
public void prosesPinjam(ArrayList<Buku> daftar, String kode) {
    for (Buku b : daftar) {
        if (b.getKode().equalsIgnoreCase(kode.trim())) {
            if (b.cekStatus()) {
                b.setStatus(false);
                System.out.println("ID [" + kode.trim() + "]: Berhasil dipinjam. Selamat membaca");
            } else {
                System.out.println("ID [" + kode.trim() + "]: Buku sedang dipinjam. Silahkan cari buku yang lain");
            }
            return; 
        }
    }
    System.out.println("ID [" + kode.trim() + "]: GAGAL (Kode buku tidak ditemukan).");
}

   // Method Overloading versi 2 untuk peminjaman dengan banyak buku
public void prosesPinjam(ArrayList<Buku> daftar, String[] banyakKode) {
    System.out.println("\n--- Memproses Peminjaman ---");
    for (String k : banyakKode) {
        prosesPinjam(daftar, k); 
    }
}

    // Method untuk menghitung denda
    public int hitungDenda(int jmlBuku, int jmlHari) {
        int tarifPerHari = 3000; 
        return (jmlBuku * jmlHari) * tarifPerHari;
    }

// Method Overloading versi 1 untuk proses pengembalian 1 buku
public boolean prosesKembali(ArrayList<Buku> daftar, String kode) {
    for (Buku b : daftar) {
        if (b.getKode().equalsIgnoreCase(kode.trim())) {
            if (!b.cekStatus()) { //cekStatus buku dari class Buku
                b.kembalikanBuku(); 
                System.out.println("ID [" + kode.trim() + "]: Berhasil dikembalikan.");
                return true;
            } else {
                System.out.println("ID [" + kode.trim() + "]: Buku masih tersedia di perpustakaan.");
            return false; 
        }
        }
    }
    System.out.println("ID [" + kode.trim() + "]: GAGAL (Kode buku tidak ditemukan).");
    return false;
}
    
// Method Overloading versi 2 untuk proses pengembalian banyak buku
public boolean prosesKembali(ArrayList<Buku> daftar, String[] banyakKode) {
    System.out.println("\n--- Memproses Pengembalian ---");
    boolean adaYangBerhasil = false;
    for (String k : banyakKode) {
        if (prosesKembali(daftar, k)) {
            adaYangBerhasil = true;
        }
    }
    return adaYangBerhasil;
}
}
