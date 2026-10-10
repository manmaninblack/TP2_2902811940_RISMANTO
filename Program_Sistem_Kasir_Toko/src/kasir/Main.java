// 2902811940 - RISMANTO
package kasir;

import java.util.Scanner;

// Program utama sistem kasir berbasis Queue dan Stack.
public class Main {
    private static final int MINIMUM_PELANGGAN_PENGUJIAN = 5;

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

    private static long bacaTotalBelanja(Scanner input) {
        while (true) {
            System.out.print("Masukkan Total Belanja: ");
            String line = input.nextLine().trim();
            try {
                long total = Long.parseLong(line);
                if (total < 0) {
                    System.out.println("Total belanja tidak boleh negatif.");
                } else {
                    return total;
                }
            } catch (NumberFormatException e) {
                System.out.println("Total belanja harus berupa bilangan bulat, contoh: 125000.");
            }
        }
    }

    private static void tambahAntrian(Scanner input, Queue antrian) {
        if (antrian.isFull()) {
            System.out.println("Antrian penuh. Maksimal 5 pelanggan dalam antrian.");
            return;
        }

        String nomor;
        while (true) {
            nomor = bacaTeks(input, "Masukkan Nomor Antrian: ");
            if (antrian.containsNomor(nomor)) {
                System.out.println("Nomor tersebut sudah ada dalam antrian.");
            } else {
                break;
            }
        }
        String nama = bacaTeks(input, "Masukkan Nama Pelanggan: ");
        long total = bacaTotalBelanja(input);
        Node pelanggan = new Node(nomor, nama, total);

        if (antrian.enqueue(pelanggan)) {
            System.out.println("Data pelanggan ditambahkan ke antrian!");
            System.out.println("Jumlah pelanggan dalam antrian: " + antrian.getSize());
            if (antrian.getSize() < MINIMUM_PELANGGAN_PENGUJIAN) {
                System.out.println("Catatan: masukkan hingga 5 pelanggan untuk memenuhi skenario minimum pengujian tugas.");
            }
        }
    }

    private static void layaniPelanggan(Queue antrian, Stack riwayat) {
        Node pelanggan = antrian.dequeue();
        if (pelanggan == null) {
            System.out.println("Tidak ada pelanggan dalam antrian.");
            return;
        }
        System.out.printf("Melayani pelanggan %s (%s)%n", pelanggan.nomorAntrian, pelanggan.namaPelanggan);
        System.out.printf("Total belanja: Rp%,d%n", pelanggan.totalBelanja);
        riwayat.push(pelanggan);
        System.out.println("Transaksi disimpan ke riwayat.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        boolean berjalan = true;
        int totalPelangganBerhasilDitambahkan = 0;

        System.out.println("=== SISTEM KASIR TOKO ===");
        while (berjalan) {
            System.out.println("\n1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");

            int pilihan = bacaMenu(input);
            switch (pilihan) {
                case 1:
                    int jumlahSebelumTambah = antrian.getSize();
                    tambahAntrian(input, antrian);
                    if (antrian.getSize() > jumlahSebelumTambah) {
                        totalPelangganBerhasilDitambahkan++;
                    }
                    break;
                case 2:
                    if (totalPelangganBerhasilDitambahkan < MINIMUM_PELANGGAN_PENGUJIAN) {
                        System.out.printf("Masukkan minimal %d pelanggan terlebih dahulu sebelum mulai melayani.%n",
                                MINIMUM_PELANGGAN_PENGUJIAN);
                    } else {
                        layaniPelanggan(antrian, riwayat);
                    }
                    break;
                case 3:
                    antrian.tampilkanAntrian();
                    break;
                case 4:
                    riwayat.tampilkanRiwayat();
                    break;
                case 5:
                    berjalan = false;
                    System.out.println("Program kasir selesai. Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Pilih menu 1 sampai 5.");
            }
        }
        input.close();
    }
}
