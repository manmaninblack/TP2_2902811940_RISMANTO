package kasir;

// Stack menggunakan prinsip LIFO (Last In, First Out).
public class Stack {
    private Node top;
    private int size;

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    // Menyimpan transaksi terbaru di bagian atas stack.
    public void push(Node transaksi) {
        transaksi.next = top;
        top = transaksi;
        size++;
    }

    // Menampilkan transaksi dari yang terbaru ke yang terlama.
    public void tampilkanRiwayat() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("\nRiwayat Transaksi (terbaru ke terlama):");
        Node current = top;
        int nomor = 1;
        while (current != null) {
            System.out.printf("%d. Nomor: %s | Nama: %s | Total Belanja: Rp%,d%n",
                    nomor, current.nomorAntrian, current.namaPelanggan, current.totalBelanja);
            current = current.next;
            nomor++;
        }
        System.out.println("Total transaksi tersimpan: " + size);
    }
}
