import java.util.*;

class Main {
    static ArrayList<Buku> koleksiBuku = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        koleksiBuku.add(new Buku("N01", "Seporsi Mie Ayam Sebelum Mati", "Brian"));
        koleksiBuku.add(new Buku("N02", "Hujan", "Tere Liye"));
        koleksiBuku.add(new Buku("N03", "Lima Tanya Yang Tertinggal Saat Ibu Pergi", "Tatsyafira"));
        koleksiBuku.add(new Buku("AU04", "Every Playful Season", "Karello"));
        koleksiBuku.add(new Buku("N05", "Janji", "Tere Liye"));
        koleksiBuku.add(new Buku("AU06", "Author vs Idol", "Karello"));
        koleksiBuku.add(new Buku("AUN07", "Housemate", "Annisa"));

        boolean running = true;

        while (running) {
            System.out.println("\n\n=== SISTEM PERPUSTAKAAN MINI ===");
            System.out.println("1. Login Anggota");
            System.out.println("2. Login Petugas");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    // Alur Login Anggota
                    prosesLogin("Anggota");
                    break;
                case 2:
                    // Alur Login Petugas
                    prosesLogin("Petugas");
                    break;
                case 0:
                    // Program Berhenti
                    System.out.println("Terima kasih sudah menggunakan Sistem Perpustakaan ini!!");
                    running = false;
                    break;
                default:
                    System.out.println("Mohon masukkan input dengan benar!");
            }
        }
    }

    public static void prosesLogin(String tipeUser) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input Role: ");
    String id = input.nextLine();
    System.out.print("Input Password: ");
    String pass = input.nextLine();

    if (tipeUser.equals("Petugas")) {
        Petugas admin = new Petugas("Admin", "admin", "123"); 
        if (admin.cekLogin(id, pass)) {
            System.out.println("Autentikasi Petugas Berhasil!");
            admin.tampilkanMenuPetugas(koleksiBuku);
        } else {
            // Notifikasi gagal untuk Petugas
            System.out.println("\nLogin Petugas Gagal!");
            System.out.println("Kesalahan pada Role atau Password yang Anda input.\n");
        }
    } else if (tipeUser.equals("Anggota")) {
        // Objek contoh untuk simulasi login anggota
        Anggota mem = new Anggota("Lupi", "member", "456");

        if (mem.cekLogin(id, pass)) {
            System.out.println("\nAutentikasi Anggota Berhasil!");
            System.out.println("Selamat Datang, " + mem.getNama());
            mem.tampilkanMenuAnggota(koleksiBuku);
            // Panggil menu anggota di sini jika ada
        } else {
            // Notifikasi gagal untuk Anggota (Sesuai Flowchart)
            System.out.println("\nLogin Anggota Gagal!");
            System.out.println("Kesalahan pada Role atau Password yang Anda input.\n");
        }
    }
}
}