public class Transaksi {
    Barang barang;
    int jumlah;
    double totalHarga;

    public Transaksi(Barang barang, int jumlah) {
        if (barang == null) {
            System.out.println("Barang tidak boleh null. Transaksi tidak valid.");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("Jumlah barang harus lebih dari 0.");
            this.jumlah = 1;
        } else {
            this.jumlah = jumlah;
        }
        this.barang = barang;
        hitungTotal();
    }

    public void hitungTotal() {
        if (barang != null) {
            this.totalHarga = this.jumlah * this.barang.harga;
        }
    }

    public void tampilkanDetail() {
        if (barang == null) {
            System.out.println("Transaksi tidak valid.");
            return;
        }
        System.out.println("Kode Barang: " + barang.kodeBarang);
        System.out.println("Nama Barang: " + barang.namaBarang);
        System.out.println("Harga per Unit: Rp" + barang.harga);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Total Harga: Rp" + totalHarga);
        System.out.println("-------------------------");
    }
}
