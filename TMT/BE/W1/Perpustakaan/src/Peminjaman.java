public class Peminjaman {
    private String idPeminjaman;
    private String namaPeminjam;
    private Buku bukuDipinjam;
    private String tanggalPinjam;
    private String tanggalKembali;

    public Peminjaman(String idPeminjaman, String namaPeminjam, Buku bukuDipinjam, String tanggalPinjam, String tanggalKembali) {
        this.idPeminjaman = idPeminjaman;
        this.namaPeminjam = namaPeminjam;
        this.bukuDipinjam = bukuDipinjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public Buku getBukuDipinjam() {
        return bukuDipinjam;
    }

    @Override
    public String toString() {
        return  "ID: " + idPeminjaman + ", Nama: " + namaPeminjam + ", Buku: " + bukuDipinjam.getJudulBuku() +
                ", Tanggal Pinjam: " + tanggalPinjam + ", Tanggal Kembali: " + tanggalKembali;
    }
}

