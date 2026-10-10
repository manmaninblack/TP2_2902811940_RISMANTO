// 2902811940 - RISMANTO
package linkedlist;

import java.util.Scanner;

// Program utama menu pengelolaan daftar buku perpustakaan.
public class Main {
    private static final int MINIMUM_BUKU = 5;

    private static int bacaMenu(Scanner input) {
        while (true) {
            System.out.print("Pilih menu: ");
            String line = input.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    private static String bacaTeks(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input tidak boleh kosong.");
        }
    }

    private static boolean tambahBuku(Scanner input, LinkedList daftarBuku) {
        String kode;
        while (true) {
            kode = bacaTeks(input, "Masukkan Kode Buku (maksimal 5 karakter): ");
            if (kode.length() > 5) {
                System.out.println("Kode buku maksimal 5 karakter. Silakan coba lagi.");
            } else if (daftarBuku.containsCode(kode)) {
                System.out.println("Kode buku sudah digunakan. Masukkan kode lain.");
            } else {
                break;
            }
        }

        String judul = bacaTeks(input, "Masukkan Judul: ");
        String penulis = bacaTeks(input, "Masukkan Penulis: ");

        if (daftarBuku.tambahBuku(kode, judul, penulis)) {
            System.out.println("Data berhasil ditambahkan!");
            System.out.println("Total buku saat ini: " + daftarBuku.getSize());
            return true;
        } else {
            // Pemeriksaan kode ganda juga dilakukan di class LinkedList.
            System.out.println("Data gagal ditambahkan karena kode sudah digunakan.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList daftarBuku = new LinkedList();
        boolean berjalan = true;
        int totalBukuBerhasilDitambahkan = 0;

        System.out.println("===== PROGRAM KELOLA DAFTAR BUKU =====");
        while (berjalan) {
            System.out.println("\n1. Tambah Buku");
            System.out.println("2. Hapus Buku Terakhir");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");

            int pilihan = bacaMenu(input);
            switch (pilihan) {
                case 1:
                    if (tambahBuku(input, daftarBuku)) {
                        totalBukuBerhasilDitambahkan++;
                    }
                    break;
                case 2:
                    Node dihapus = daftarBuku.hapusBukuTerakhir();
                    if (dihapus == null) {
                        System.out.println("Tidak ada data untuk dihapus.");
                    } else {
                        System.out.println("Buku terakhir berhasil dihapus: "
                                + dihapus.kodeBuku + " - " + dihapus.judul);
                    }
                    break;
                case 3:
                    String kodeCari = bacaTeks(input, "Masukkan Kode Buku: ");
                    Node ditemukan = daftarBuku.cariBuku(kodeCari);
                    if (ditemukan != null) {
                        System.out.println("Buku ditemukan:");
                        System.out.println("Kode: " + ditemukan.kodeBuku);
                        System.out.println("Judul: " + ditemukan.judul);
                        System.out.println("Penulis: " + ditemukan.penulis);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;
                case 4:
                    daftarBuku.tampilkanSemuaBuku();
                    break;
                case 5:
                    if (totalBukuBerhasilDitambahkan < MINIMUM_BUKU) {
                        System.out.printf("Belum bisa keluar. Tambahkan minimal %d buku terlebih dahulu. Data berhasil ditambahkan: %d.%n",
                                MINIMUM_BUKU, totalBukuBerhasilDitambahkan);
                        break;
                    }
                    berjalan = false;
                    System.out.println("Program selesai. Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Pilih menu 1 sampai 5.");
            }
        }
        input.close();
    }
}
