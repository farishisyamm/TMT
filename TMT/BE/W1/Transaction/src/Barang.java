public class Barang {
    String kodeBarang;
    String namaBarang;
    double harga;

    public Barang(String kodeBarang, String namaBarang, double harga) {
        if (harga <= 0) {
            System.out.println("Harga barang harus lebih dari 0.");
            this.harga = 1;
        } else {
            this.harga = harga;
        }
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
    }
}