import java.util.ArrayList;
import java.util.Scanner;

public class Task2Program {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Object>> studentDetailList = new ArrayList<>();

    public static void addStudent() {
        int id, marks;
        String name;

        System.out.println("Enter student ID:");
        id = sc.nextInt();

        System.out.println("Enter the Student Name:");
        name = sc.next();

        System.out.println("Enter the Student Marks:");
        marks = sc.nextInt();

        ArrayList<Object> student = new ArrayList<>();
        student.add(id);
        student.add(name);
        student.add(marks);

        studentDetailList.add(student);

        System.out.println("Student details added successfully: " + student);
    }

    public static void viewStudents() {
        System.out.println("Enter the Student ID to view details: ");
        int viewId = sc.nextInt();

        boolean found = false;

        for (ArrayList<Object> student : studentDetailList) {
            if ((int) student.get(0) == viewId) {
                System.out.println("Record found: " + student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student ID not found.");
        }
    }

    public static void updateStudent() {
        System.out.println("Enter student ID to update the record:");
        int updateId = sc.nextInt();
        boolean found = false;

        for (ArrayList<Object> student : studentDetailList) {
            if ((int) student.get(0) == updateId) {
                found = true;

                System.out.println("What do you want to update? (name/marks):");
                String field = sc.next();

                if (field.equalsIgnoreCase("name")) {
                    System.out.println("Enter new name:");
                    String newName = sc.next();
                    student.set(1, newName);
                    System.out.println("Name updated successfully.");

                } else if (field.equalsIgnoreCase("marks")) {
                    System.out.println("Enter new marks:");
                    int newMarks = sc.nextInt();
                    student.set(2, newMarks);
                    System.out.println("Marks updated successfully.");

                } else {
                    System.out.println("Invalid field. Only 'name' or 'marks' allowed.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + updateId + " not found.");
        }
    }

    public static void deleteStudent() {
        System.out.println("Enter student ID to delete the record:");
        int deleteId = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < studentDetailList.size(); i++) {
            ArrayList<Object> student = studentDetailList.get(i);

            if ((int) student.get(0) == deleteId) {
                studentDetailList.remove(i);
                System.out.println("Student with ID " + deleteId + " has been deleted.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + deleteId + " not found.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

