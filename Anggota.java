import java.util.ArrayList;

class Anggota extends User {
    private int kuota = 3; 
    Fungsi alat = new Fungsi(); 

    public Anggota(String nama, String role, String password) {
        super(nama, role, password);
    }

    public void tampilkanMenuAnggota(ArrayList<Buku> daftarBuku) {
        // Panggil fungsi yang sama dengan petugas
        alat.tampilkanSemuaBuku(daftarBuku); 
    }
}