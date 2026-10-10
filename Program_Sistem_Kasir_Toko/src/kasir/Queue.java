package kasir;

// Queue menggunakan prinsip FIFO (First In, First Out).
public class Queue {
    private Node front;
    private Node rear;
    private int size;
    private static final int KAPASITAS_MAKSIMUM = 5;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean isFull() {
        return size >= KAPASITAS_MAKSIMUM;
    }

    // Memeriksa nomor antrian yang masih berada dalam antrian.
    public boolean containsNomor(String nomor) {
        Node current = front;
        while (current != null) {
            if (current.nomorAntrian.equalsIgnoreCase(nomor)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Menambahkan pelanggan ke belakang antrian.
    public boolean enqueue(Node pelanggan) {
        if (isFull()) {
            return false;
        }
        pelanggan.next = null;
        if (rear == null) {
            front = pelanggan;
            rear = pelanggan;
        } else {
            rear.next = pelanggan;
            rear = pelanggan;
        }
        size++;
        return true;
    }

    // Mengambil pelanggan paling depan dan melepaskan link-nya dari antrian.
    public Node dequeue() {
        if (front == null) {
            return null;
        }
        Node pelanggan = front;
        front = front.next;
        pelanggan.next = null;
        size--;
        if (front == null) {
            rear = null;
        }
        return pelanggan;
    }

    // Menampilkan pelanggan dalam urutan kedatangan.
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian saat ini kosong.");
            return;
        }
        System.out.println("\nAntrian Pelanggan (FIFO):");
        Node current = front;
        int posisi = 1;
        while (current != null) {
            System.out.printf("%d. Nomor: %s | Nama: %s | Total Belanja: Rp%,d%n",
                    posisi, current.nomorAntrian, current.namaPelanggan, current.totalBelanja);
            current = current.next;
            posisi++;
        }
        System.out.println("Jumlah pelanggan dalam antrian: " + size + "/" + KAPASITAS_MAKSIMUM);
    }
}
