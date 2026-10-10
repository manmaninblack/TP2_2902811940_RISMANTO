package kasir;

// Node menyimpan data pelanggan dan referensi ke node berikutnya.
public class Node {
    String nomorAntrian;
    String namaPelanggan;
    long totalBelanja;
    Node next;

    public Node(String nomorAntrian, String namaPelanggan, long totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}
