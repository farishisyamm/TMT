import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Daftar Produk");
        System.out.println("    A1L");
        System.out.println("    A2");
        System.out.println("    A3");
        System.out.println("    A4");
        System.out.println("Masukkan Kode Produk: ");
        String inputCodeProduct = scanner.nextLine();
        System.out.println("Masukkan Jumlah Uang");
        int inputMoney = scanner.nextInt();

        String product;
        int price;

        switch (inputCodeProduct) {
            case "A1" -> {
                product ="Kopi";
                price = "10000"
            }
            case "A2" -> {
                product ="Kopi";
                price = "10000"
            }
            case "A3" -> {
                product ="Kopi";
                price = "10000"
            }
            case "A4" -> {
                product ="Kopi";
                price = "10000"
            }
        }
    }
}