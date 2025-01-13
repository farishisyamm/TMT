import java.util.ArrayList;
import java.util.List;

public class Universitas {
    private List<Mahasiswa> mahasiswaList;

    public Universitas() {
        this.mahasiswaList = new ArrayList<>();
    }

    public void tambahMahasiswa(Mahasiswa m) {
        for (Mahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.getNim().equals(m.getNim())) {
                System.out.println("Mahasiswa dengan NIM " + m.getNim() + " sudah terdaftar.");
                return;
            }
        }
        mahasiswaList.add(m);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    public void cariMahasiswa(String nim) {
        for (Mahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.getNim().equals(nim)) {
                System.out.println("Data Mahasiswa: " + mahasiswa);
                return;
            }
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
    }

    public void tampilkanSemuaMahasiswa() {
        if (mahasiswaList.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("Daftar Mahasiswa:");
            for (Mahasiswa mahasiswa : mahasiswaList) {
                System.out.println("NIM: " + mahasiswa.getNim() + ", Nama: " + mahasiswa.getNama() + ", Jurusan: " + mahasiswa.getJurusan() + ", IPK: " + mahasiswa.getIpk());
            }
        }
    }
}