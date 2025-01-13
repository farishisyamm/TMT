import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    String name;
    String id;
    double score;

    Student(String name, String id, double score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public void displayData() {
        System.out.println("Nama: " + name + ", NIM: " + id + ", Nilai: " + score);
    }

    // Method untuk menampilkan semua data mahasiswa
    public static void processData(ArrayList<Student> studentList) {
        // Menampilkan semua data mahasiswa
        System.out.println("\nDaftar Mahasiswa:");
        for (Student student : studentList) {
            student.displayData();
        }

        // Mencari mahasiswa dengan nilai tertinggi dan terendah
        Student highest = studentList.get(0);
        Student lowest = studentList.get(0);
        for (Student student : studentList) {
            if (student.score > highest.score) {
                highest = student;
            }
            if (student.score < lowest.score) {
                lowest = student;
            }
        }

        System.out.println("\nMahasiswa dengan nilai tertinggi:");
        highest.displayData();

        System.out.println("Mahasiswa dengan nilai terendah:");
        lowest.displayData();

        // Menampilkan mahasiswa dengan nilai lebih dari 75
        System.out.println("\nMahasiswa dengan nilai lebih dari 75:");
        for (Student student : studentList) {
            if (student.score > 75) {
                student.displayData();
            }
        }

        // Mengurutkan mahasiswa berdasarkan nilai secara menurun
        studentList.sort((s1, s2) -> Double.compare(s2.score, s1.score));
        System.out.println();
        System.out.println("Mahasiswa setelah diurutkan berdasarkan nilai (tertinggi ke terendah):");
        for (Student student : studentList) {
            student.displayData();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        // Meminta user memasukkan data mahasiswa
        System.out.print("Masukkan data mahasiswa (minimal 5): ");
        int n = scanner.nextInt();scanner.nextLine();
        if (n >= 5) {
            for (int i = 0; i < n; i++) {
                System.out.println();
                System.out.println("Input Data Mahasiswa " + (i+1));
                System.out.print("Nama: ");
                String name = scanner.nextLine();
                System.out.print("NIM: ");
                String id = scanner.nextLine();

                //Validasi angka untuk nilai
                double score = 0;
                boolean isValid = false;
                while (!isValid) {
                    System.out.print("Nilai: ");
                    if (scanner.hasNextDouble()) {
                        score = scanner.nextDouble();scanner.nextLine();
                        isValid = true;
                    } else {
                        System.out.println("Mohon input angka.");
                        scanner.next();
                    }
                }
                studentList.add(new Student(name, id, score));
            }
            // Memanggil fungsi untuk menampilkan semua data mahasiswa dan kriteria lainnya
            processData(studentList);
        } else {
            System.out.println("Masukkan data wajib minimal 5");
        }
        scanner.close();
    }
}
