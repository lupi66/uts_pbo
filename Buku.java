class Buku {
    private String kodeBuku;
    private String judulBuku;
    private String penulis;
    private String peminjam;
    private boolean isTersedia = true; 

    public Buku(String kode, String judul, String penulis) { 
        this.kodeBuku = kode;
        this.judulBuku = judul;
        this.penulis = penulis;
    }

    // Getter untuk akses data (Encapsulation)
    public String getKode() { 
        return kodeBuku; }
    public String getJudul() { 
        return judulBuku; }
    public boolean cekStatus() { 
        return isTersedia; }

    // Method untuk merubah status saat dipinjam
    public void setStatus(boolean status) {
        this.isTersedia = status;
    }

    public void kembalikanBuku() {
        this.isTersedia = true; // Status kembali tersedia
        this.peminjam = "-";    // Menghapus data peminjam
    }

    public void tampilkanInfo() {
        String status = isTersedia ? "Tersedia" : "Sedang Dipinjam";
        System.out.println("[" + kodeBuku + "] " + judulBuku + " - " + penulis + " (" + status + ")");
    }
}