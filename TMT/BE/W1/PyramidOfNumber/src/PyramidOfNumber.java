//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class PyramidOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris: ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            // Print spasi
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }

            // Print angka yang increment
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Print angka yang decrement
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }

            // Pindah ke baris berikutnya
            System.out.println();
        }
        scanner.close();
    }
}