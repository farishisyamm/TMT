import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        loopingNumber();
    }

    public static void loopingNumber() {
        System.out.println("Masukkan Angka: ");
        Scanner myObj = new Scanner(System.in);
        int number = myObj.nextInt();
        for (int i=1; i<=number; i++) {
            if(i%2 == 0){
                System.out.println(i);
            }
        }

    }
}