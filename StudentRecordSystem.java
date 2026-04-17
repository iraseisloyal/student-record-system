import java.io.*;
import java.util.Scanner;

public class StudentRecordSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                addStudent(input);
            } 
            else if (choice == 2) {
                viewStudents();
            } 
            else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void addStudent(Scanner input) {
        try {
            FileWriter writer = new FileWriter("students.txt", true);

            System.out.print("Enter name: ");
            String name = input.nextLine();

            System.out.print("Enter age: ");
            int age = input.nextInt();
            input.nextLine();

            System.out.print("Enter course: ");
            String course = input.nextLine();

            writer.write(name + "," + age + "," + course + "\n");

            writer.close();
            System.out.println("Student saved!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void viewStudents() {
        try {
            FileReader reader = new FileReader("students.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            System.out.println("\nStudent Records:");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Name: " + data[0] +
                                   ", Age: " + data[1] +
                                   ", Course: " + data[2]);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}