TP2 - DATA STRUCTURES AND ALGORITHM ANALYSIS
Nama: Rismanto
NIM: 2902811940

ISI FOLDER
1. Program_Kelola_Daftar_Buku
   Package: linkedlist
   File: Node.java, LinkedList.java, Main.java
   Fungsi: mengelola daftar buku menggunakan Singly Linked List.
   Menu: tambah buku, hapus buku terakhir, cari buku, tampilkan semua buku, keluar.

2. Program_Sistem_Kasir_Toko
   Package: kasir
   File: Node.java, Queue.java, Stack.java, Main.java
   Fungsi: sistem kasir toko menggunakan Queue untuk antrian pelanggan dan Stack untuk riwayat transaksi.
   Menu: tambah antrian, layani pelanggan, tampilkan antrian, lihat riwayat transaksi, keluar.

3. Screenshoot

CARA MEMBUKA DI ECLIPSE
1. Extract ZIP ke folder yang mudah ditemukan.
2. Buka Eclipse, pilih File > Import.
3. Pilih General > Existing Projects into Workspace, lalu Next.
4. Pilih Select root directory dan arahkan ke folder hasil extract, yaitu TP2_2902811940_RISMANTO.
5. Centang Program_Kelola_Daftar_Buku dan Program_Sistem_Kasir_Toko, lalu klik Finish.
6. Untuk program buku, buka src > linkedlist > Main.java.
7. Untuk program kasir, buka src > kasir > Main.java.
8. Klik kanan Main.java, pilih Run As > Java Application.

CARA MENJALANKAN DARI TERMINAL
Jalankan perintah dari folder project masing-masing.

Program Kelola Daftar Buku:
  javac -d bin src/linkedlist/Node.java src/linkedlist/LinkedList.java src/linkedlist/Main.java
  java -cp bin linkedlist.Main

Program Sistem Kasir Toko:
  javac -d bin src/kasir/Node.java src/kasir/Queue.java src/kasir/Stack.java src/kasir/Main.java
  java -cp bin kasir.Main