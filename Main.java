import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StudentDAO dao = new StudentDAO();
            int choice;

            do {
                System.out.println("\n--- Student Record Management ---");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();
                        dao.insertStudent(new Student(id, name, email, marks));
                        System.out.println("Student added.");
                        break;

                    case 2:
                        List<Student> students = dao.getAllStudents();
                        if (students.isEmpty()) System.out.println("No students found.");
                        else students.forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter ID to search: ");
                        Student s = dao.getStudentById(sc.nextInt());
                        System.out.println(s != null ? s : "Student not found.");
                        break;

                    case 4:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Name: ");
                        String uname = sc.nextLine();
                        System.out.print("New Email: ");
                        String uemail = sc.nextLine();
                        System.out.print("New Marks: ");
                        int umarks = sc.nextInt();
                        dao.updateStudent(new Student(uid, uname, uemail, umarks));
                        System.out.println("Student updated.");
                        break;

                    case 5:
                        System.out.print("Enter ID to delete: ");
                        dao.deleteStudent(sc.nextInt());
                        System.out.println("Student deleted.");
                        break;
                }

            } while (choice != 6);

            dao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
