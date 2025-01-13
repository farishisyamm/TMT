import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;

    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    public void tampilkanData() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + ipk);
    }

    public boolean isCumlaude() {
        return ipk >= 3.50;
    }
//    public static void main(String[] args) {
//
//        Mahasiswa mahasiswa1 = new Mahasiswa("Gilang", "9099090", "Teknik Informatika", 3.20);
//        Mahasiswa mahasiswa2 = new Mahasiswa("Adil", "90909099", "Teknik Informatika", 3.75);
//
//        System.out.println("Data Mahasiswa 1:");
//        mahasiswa1.tampilkanData();
//        System.out.println("Cumlaude: " + (mahasiswa1.isCumlaude() ? "Ya" : "Tidak"));
//        System.out.println();
//
//        System.out.println("Data Mahasiswa 2:");
//        mahasiswa2.tampilkanData();
//        System.out.println("Cumlaude: " + (mahasiswa2.isCumlaude() ? "Ya" : "Tidak"));
//    }
}