import java.util.*;

class Petugas extends User { 
    public Petugas(String nama, String role, String password) {
        super(nama, role, password);
    }

    public void tampilkanMenuPetugas(ArrayList<Buku> daftarBuku) {
        Scanner input = new Scanner(System.in);
        boolean stayInMenu = true;
        while (stayInMenu) {
        System.out.println("\n=== MENU PETUGAS ===");
        System.out.println("1. Cek Ketersediaan Buku");
        System.out.println("2. Peminjaman Buku");
        System.out.println("3. Pengembalian Buku");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
        int menu = input.nextInt();
        input.nextLine(); // membersihkan buffer

        Fungsi fungsi = new Fungsi(); // Membuat objek Fungsi untuk akses method hitungDenda
        switch (menu) {
            case 1: // Menampilkan Buku yang tersedia
                System.out.println("\n--- Daftar Semua Buku ---");
                for (Buku buku : daftarBuku) {
                    buku.tampilkanInfo();
                }
                break;

            case 2: // Menu Peminjaman Buku
                System.out.print("Pilih ID Buku: ");
                String inputPinjam = input.nextLine();
                String[] daftarIdInput = inputPinjam.split(",");

                if (daftarIdInput.length > 3) {
                System.out.println("\nMaksimal peminjaman hanya 3 buku saja! Silahkan pilih kembali.");
                } else if (daftarIdInput.length == 1) {
                // Memanggil Overloading Versi 1 (Parameter String)
                fungsi.prosesPinjam(daftarBuku, daftarIdInput[0]);
                } else {
                // Memanggil Overloading Versi 2 (Parameter String Array)
                fungsi.prosesPinjam(daftarBuku, daftarIdInput);
                }
                break;

            case 3: // Menu Pengembalian Buku
                System.out.print("Input Kode Buku: ");
                String inputKembali = input.nextLine();
                String[] daftarIdKembali = inputKembali.split(",");
                boolean statusKembali;

            // Overloading berdasarkan jumlah input
                if (daftarIdKembali.length == 1) {
                statusKembali = fungsi.prosesKembali(daftarBuku, daftarIdKembali[0]);
                } else {
                statusKembali = fungsi.prosesKembali(daftarBuku, daftarIdKembali);
                }  
            
                // Denda
                if (statusKembali) {
                System.out.print("\nApakah ada buku yang terlambat dikembalikan? (y/n): ");
                String dendaCheck = input.nextLine();

                    if (dendaCheck.equalsIgnoreCase("y")) {
                    System.out.print("Berapa buku yang terlambat dikembalikan? ");
                    int jmlBukuTelat = input.nextInt();
                    System.out.print("Berapa hari keterlambatannya? ");
                    int jmlHari = input.nextInt();
                    input.nextLine(); // clear buffer

            // Panggil fungsi hitung denda
                    int totalDenda = fungsi.hitungDenda(jmlBukuTelat, jmlHari);
        
                    System.out.println("\n--- RINCIAN DENDA ---");
                    System.out.println("Jumlah Buku : " + jmlBukuTelat);
                    System.out.println("Jumlah Hari : " + jmlHari);
                    System.out.println("Total Denda : Rp " + totalDenda);
                    }
                    } 
                    break;

            case 0: // Jalur "Keluar -> MAIN"
                stayInMenu = false;
                break;

            default:
                System.out.println("Pilihan tidak valid.");
            }
    }
}
}
