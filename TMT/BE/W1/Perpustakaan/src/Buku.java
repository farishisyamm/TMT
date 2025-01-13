public class Buku {
    private String kodeBuku;
    private String judulBuku;
    private String penulis;
    private int stok;

    public Buku(String kodeBuku, String judulBuku, String penulis, int stok) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.stok = stok;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public boolean kurangiStok() {
        if (stok > 0) {
            stok--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Kode: " + kodeBuku + ", Judul: " + judulBuku + ", Penulis: " + penulis + ", Stok: " + stok;
    }
}
