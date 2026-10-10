// 2902811940 - RISMANTO
package linkedlist;

// Implementasi Singly Linked List untuk menyimpan daftar buku.
public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Memeriksa apakah kode buku sudah digunakan.
    public boolean containsCode(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Menambahkan buku di akhir linked list.
    public boolean tambahBuku(String kodeBuku, String judul, String penulis) {
        if (containsCode(kodeBuku)) {
            return false;
        }

        Node newNode = new Node(kodeBuku, judul, penulis);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    // Menghapus buku terakhir (operasi pop).
    public Node hapusBukuTerakhir() {
        if (head == null) {
            return null;
        }

        Node deleted;
        if (head.next == null) {
            deleted = head;
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            deleted = current.next;
            current.next = null;
        }
        deleted.next = null;
        size--;
        return deleted;
    }

    // Mencari buku berdasarkan kode.
    public Node cariBuku(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Menampilkan buku sesuai urutan input beserta jumlahnya.
    public void tampilkanSemuaBuku() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            System.out.println("Total Buku: 0");
            return;
        }

        System.out.println("\nDaftar Buku:");
        Node current = head;
        while (current != null) {
            System.out.printf("Kode: %s | Judul: %s | Penulis: %s%n",
                    current.kodeBuku, current.judul, current.penulis);
            current = current.next;
        }
        System.out.println("Total Buku: " + size);
    }
}
