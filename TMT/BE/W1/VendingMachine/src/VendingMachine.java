//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Daftar produk
        System.out.println("Daftar Produk:");
        System.out.println("    A1: Kopi (Rp. 10000)");
        System.out.println("    A2: Teh (Rp. 8000)");
        System.out.println("    A3: Coklat Panas (Rp. 12000)");
        System.out.println("    A4: Jus Buah (Rp. 15000)");

        // Input kode produk
        System.out.print("Masukkan kode produk: ");
        String inputCodeProduct = scanner.nextLine().toUpperCase();

        // Input jumlah uang
        System.out.print("Masukkan jumlah uang: Rp. ");
        int inputMoney = scanner.nextInt();

        // Inisialisasi
        String product;
        int price;

        // Switch-case
        switch (inputCodeProduct) {
            case "A1" -> {
                product = "Kopi";
                price = 10000;
            }
            case "A2" -> {
                product = "Teh";
                price = 8000;
            }
            case "A3" -> {
                product = "Coklat Panas";
                price = 12000;
            }
            case "A4" -> {
                product = "Jus Buah";
                price = 15000;
            }
            default -> {
                System.out.println("Kode produk tidak valid.");
                return;
            }
        }

        // Mengecek kecukupan uang
        if (inputMoney >= price) {
            int change = inputMoney - price;
            System.out.println("Anda membeli " + product + ". Kembalian Anda: Rp. " + change + ".");
        } else {
            System.out.println("Uang Anda tidak cukup. Transaksi dibatalkan.");
        }
        scanner.close();
    }
}