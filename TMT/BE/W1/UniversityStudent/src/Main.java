import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Universitas universitas = new Universitas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Cari Mahasiswa berdasarkan NIM");
            System.out.println("3. Tampilkan Semua Mahasiswa");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            // Validasi input menu
            if (!scanner.hasNextInt()) {
                System.out.println("Masukkan menu angka yang valid!");scanner.nextLine();
                continue;
            }

            //Menu
            int pilihan = scanner.nextInt();scanner.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    if (!nama.matches("[a-zA-Z\\s]+")) {
                        System.out.println("Nama hanya boleh berisi huruf dan spasi. Silakan coba lagi.");
                        break;
                    }

                    System.out.print("Masukkan Jurusan: ");
                    String jurusan = scanner.nextLine();
                    System.out.print("Masukkan IPK: ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("IPK harus berupa angka desimal menggunakan koma(,) Silakan coba lagi.");
                        scanner.nextLine();
                        break;
                    }

                    double ipk = scanner.nextDouble();scanner.nextLine();
                    if (ipk < 0.0 || ipk > 4.0) {
                        System.out.println("IPK harus berada di antara 0,0 sampai 4,0. Silakan coba lagi.");
                        break;
                    }

                    Mahasiswa mahasiswa = new Mahasiswa(nim, nama, jurusan, ipk);
                    universitas.tambahMahasiswa(mahasiswa);
                    break;

                case 2:
                    System.out.print("Masukkan NIM yang ingin dicari: ");
                    String cariNim = scanner.nextLine();
                    universitas.cariMahasiswa(cariNim);
                    break;

                case 3:
                    universitas.tampilkanSemuaMahasiswa();
                    break;

                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

}