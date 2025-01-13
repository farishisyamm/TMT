import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contact {

    public static void showContacts(Map<String, String> contacts){
        System.out.println("\nDaftar Kontak:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println("Nama: " + entry.getKey() + ", Nomor Telepon: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, String> contacts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        // Penanda menu 3
        boolean isFirstTimeAdd = true;

        // Menu
        while (true) {
            System.out.println("\n--- Menu Kontak ---");
            System.out.println("1. Tampilkan semua kontak");
            System.out.println("2. Cari kontak berdasarkan nama");
            System.out.println("3. Tambah kontak");
            System.out.println("4. Hapus kontak berdasarkan nama");
            System.out.println("5. Update nomor telepon kontak");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            // Validasi input menu
            if (!scanner.hasNextInt()) {
                System.out.println("Masukkan angka 1-6 untuk memilih menu!");
                scanner.nextLine();
                continue;
            }

            int menu = scanner.nextInt();scanner.nextLine();

            switch (menu) {
                case 1: // Menampilkan semua kontak
                    if (contacts.isEmpty()) {
                        System.out.println("Tidak ada kontak yang tersimpan.");
                    } else {
                        showContacts(contacts);
                    }
                    break;

                case 2: // Mencari kontak berdasarkan nama
                    System.out.print("\nMasukkan nama yang ingin dicari: ");
                    String searchName = scanner.nextLine();
                    if (contacts.containsKey(searchName)) {
                        System.out.println("Nama: " + searchName + ", Nomor Telepon: " + contacts.get(searchName));
                    } else {
                        System.out.println("Kontak dengan nama " + searchName + " tidak ditemukan.");
                    }
                    break;

                case 3: // Menambahkan kontak
                    if ((contacts.size() < 5) && (isFirstTimeAdd == true)) {
                        System.out.print("\nBerapa kontak yang ingin ditambahkan? (minimal 5): ");
                        int n = scanner.nextInt();scanner.nextLine();
                        if (n >= 5) {
                            for (int i = 0; i < n; i++) {
                                System.out.println("\nKontak #" + (i + 1) + ":");
                                System.out.print("Masukkan nama: ");
                                String name = scanner.nextLine();

                                // Validasi apakah nama sudah ada
                                if (contacts.containsKey(name)) {
                                    System.out.println("Kontak dengan nama ini sudah ada. Gunakan nama lain.");
                                    i--;
                                    continue;
                                }

                                System.out.print("Masukkan nomor telepon: ");
                                String phone = scanner.nextLine();

                                //Validasi nomor telepon
                                if (!phone.matches("\\d+")) {
                                    System.out.println("Nomor telepon harus hanya berisi angka. Silakan coba lagi.");
                                    continue;
                                }

                                contacts.put(name, phone);
                                isFirstTimeAdd = false;
                            }
                        } else {
                            System.out.println("Gagal, Kontak yang ditambahkan untuk pertama kali minimal 5");
                        }
                    } else {
                        System.out.print("\nBerapa kontak yang ingin ditambahkan?: ");
                        int n = scanner.nextInt();scanner.nextLine();
                            for (int i = 0; i < n; i++) {
                                System.out.println("\nKontak #" + (i + 1) + ":");
                                System.out.print("Masukkan nama: ");
                                String name = scanner.nextLine();

                                // Validasi apakah nama sudah ada
                                if (contacts.containsKey(name)) {
                                    System.out.println("Kontak dengan nama ini sudah ada. Gunakan nama lain.");
                                    i--;
                                    continue;
                                }

                                System.out.print("Masukkan nomor telepon: ");
                                String phone = scanner.nextLine();

                                //Validasi nomor telepon
                                if (!phone.matches("\\d+")) {
                                    System.out.println("Nomor telepon harus hanya berisi angka. Silakan coba lagi.");
                                    continue;
                                }
                                contacts.put(name, phone);
                            }
                    }
                    break;

                case 4: // Menghapus kontak berdasarkan nama
                    System.out.print("\nMasukkan nama kontak yang ingin dihapus: ");
                    String deleteName = scanner.nextLine();
                    if (contacts.remove(deleteName) != null) {
                        System.out.println("Kontak dengan nama " + deleteName + " berhasil dihapus.");
                        showContacts(contacts);
                    } else {
                        System.out.println("Kontak dengan nama " + deleteName + " tidak ditemukan.");
                    }
                    break;

                case 5: // Mengupdate nomor telepon kontak
                    System.out.print("\nMasukkan nama kontak yang ingin diupdate: ");
                    String updateName = scanner.nextLine();
                    if (contacts.containsKey(updateName)) {
                        System.out.print("Masukkan nomor telepon baru: ");
                        String updatedPhone = scanner.nextLine();
                        contacts.put(updateName, updatedPhone);
                        System.out.println("Nomor telepon kontak berhasil diperbarui.");
                        showContacts(contacts);
                    } else {
                        System.out.println("Kontak dengan nama " + updateName + " tidak ditemukan.");
                    }
                    break;

                case 6: // Keluar dari program
                    System.out.println("Keluar dari program. Terima kasih!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Masukkan angka 1-6 untuk memilih menu!");
            }
        }
    }
}
