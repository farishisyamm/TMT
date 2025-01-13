import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perpustakaan {
    private List<Buku> daftarBuku;
    private List<Peminjaman> daftarPeminjaman;

    public Perpustakaan() {
        daftarBuku = new ArrayList<>();
        daftarPeminjaman = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tampilkanBuku() {
        System.out.println("Daftar Buku:");
        for (Buku buku : daftarBuku) {
            System.out.println(buku);
        }
    }

    public void pinjamBuku(String kodeBuku, String namaPeminjam, String tanggalPinjam, String tanggalKembali) {
        for (Buku buku : daftarBuku) {
            if (buku.getKodeBuku().equalsIgnoreCase(kodeBuku)) {
                if (buku.kurangiStok()) {
                    String idPeminjaman = "P" + (daftarPeminjaman.size() + 1);
                    Peminjaman peminjaman = new Peminjaman(idPeminjaman, namaPeminjam, buku, tanggalPinjam, tanggalKembali);
                    daftarPeminjaman.add(peminjaman);
                    System.out.println("Buku berhasil dipinjam. ID Peminjaman: " + idPeminjaman);
                } else {
                    System.out.println("Stok buku habis.");
                }
                return;
            }
        }
        System.out.println("Buku dengan kode " + kodeBuku + " tidak ditemukan.");
    }

    public void kembalikanBuku(String idPeminjaman) {
        for (Peminjaman peminjaman : daftarPeminjaman) {
            if (peminjaman.getIdPeminjaman().equals(idPeminjaman)) {
                daftarPeminjaman.remove(peminjaman);
                peminjaman.getBukuDipinjam().tambahStok(1);
                System.out.println("Buku berhasil dikembalikan.");
                return;
            }
        }
        System.out.println("Tidak ditemukan peminjaman dengan ID " + idPeminjaman + ".");
    }


    public void tampilkanPeminjaman() {
        System.out.println("Daftar Peminjaman:");
        for (Peminjaman peminjaman : daftarPeminjaman) {
            System.out.println(peminjaman);
        }
    }

    public static boolean validasiKode(String kode, List<Buku> daftarBuku) {
        for (Buku buku : daftarBuku) {
            if (buku.getKodeBuku().equals(kode)) {
                return true;
            }
        }
        return false;
    }

    public static String validasiInputString(String input) {
        while (input == null || input.trim().isEmpty()) {
            System.out.print("Input tidak boleh kosong atau hanya spasi. Masukkan ulang: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        }
        return input.trim();
    }

    public static String validasiTanggal(Scanner scanner, boolean isTanggalPinjam) {
        while (true) {
            if (isTanggalPinjam) {
                System.out.print("Masukkan tanggal pinjam (dd/mm/yyyy): ");
            } else {
                System.out.print("Masukkan tanggal kembali (dd/mm/yyyy): ");
            }
            String tanggal = scanner.nextLine().trim().replace("-", "/").replace(".", "/");
            if (tanggal.matches("\\d{2}/\\d{2}/\\d{4}")) {
                return tanggal;
            }
            System.out.println("Format tanggal harus dd/mm/yyyy. Silakan input ulang.");
        }
    }


    public static int validasiStok(Scanner scanner) {
        while (true) {
            System.out.print("Masukkan stok buku (angka): ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+") && Integer.parseInt(input) > 0) {
                return Integer.parseInt(input);
            }
            System.out.println("Stok harus berupa angka dan lebih dari 0. Silakan input ulang.");
        }
    }
    public static void main(String[] args) {
        Perpustakaan perpustakaan = new Perpustakaan();

        perpustakaan.tambahBuku(new Buku("B001", "Java Programming", "James Gosling", 3));
        perpustakaan.tambahBuku(new Buku("B002", "Clean Code", "Robert C. Martin", 2));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan daftar buku");
            System.out.println("2. Tambah buku baru");
            System.out.println("3. Pinjam buku");
            System.out.println("4. Kembalikan buku");
            System.out.println("5. Tampilkan daftar peminjaman");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();scanner.nextLine();

            switch (pilihan) {
                case 1:
                    perpustakaan.tampilkanBuku();
                    break;
                case 2:
                    System.out.print("Masukkan kode buku: ");
                    String kode = validasiInputString(scanner.nextLine()).toUpperCase();
                    if (validasiKode(kode, perpustakaan.daftarBuku)) {
                        System.out.println("Gagal, Kode buku sudah ada.");
                        break;
                    }
                    System.out.print("Masukkan judul buku: ");
                    String judul = validasiInputString(scanner.nextLine());
                    System.out.print("Masukkan penulis buku: ");
                    String penulis = validasiInputString(scanner.nextLine());
                    int stok = validasiStok(scanner);
                    perpustakaan.tambahBuku(new Buku(kode, judul, penulis, stok));
                    break;
                case 3:
                    System.out.print("Masukkan kode buku yang ingin dipinjam: ");
                    String kodePinjam = validasiInputString(scanner.nextLine()).toUpperCase();
                    System.out.print("Masukkan nama peminjam: ");
                    String namaPeminjam = validasiInputString(scanner.nextLine());
                    String tanggalPinjam = validasiTanggal(scanner, true);
                    String tanggalKembali = validasiTanggal(scanner, false);

                    if (tanggalKembali.compareTo(tanggalPinjam) < 0) {
                        System.out.println("Gagal, Tanggal kembali tidak boleh lebih awal dari tanggal pinjam.");
                        break;
                    }
                    perpustakaan.pinjamBuku(kodePinjam, namaPeminjam, tanggalPinjam, tanggalKembali);
                    break;

                case 4:
                    System.out.print("Masukkan ID peminjaman yang ingin dikembalikan: ");
                    String idPeminjaman = validasiInputString(scanner.nextLine()).toUpperCase();
                    perpustakaan.kembalikanBuku(idPeminjaman);
                    break;
                case 5:
                    perpustakaan.tampilkanPeminjaman();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}