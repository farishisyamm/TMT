
public class Main {
    public static void main(String[] args) {
        // Membuat objek Barang
        Barang barang1 = new Barang("B001", "Pensil", 2000);
        Barang barang2 = new Barang("B002", "Buku Tulis", 5000);

        // Membuat objek Transaksi
        Transaksi transaksi1 = new Transaksi(barang1, 10); // 10 pensil
        Transaksi transaksi2 = new Transaksi(barang2, 0);  // Jumlah 0
        Transaksi transaksi3 = new Transaksi(null, 5);     // Barang null

        // Menampilkan detail transaksi
        System.out.println("Detail Transaksi 1:");
        transaksi1.tampilkanDetail();

        System.out.println("Detail Transaksi 2:");
        transaksi2.tampilkanDetail();

        System.out.println("Detail Transaksi 3:");
        transaksi3.tampilkanDetail();
    }
}
