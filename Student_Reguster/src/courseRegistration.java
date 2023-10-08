
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class courseRegistration {

    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Course");
            System.out.println("2. Register Student");
            System.out.println("3. Display Courses");
            System.out.println("4. Register Student for a Course");
            System.out.println("5. Drop Student from a Course");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    registerStudent(scanner);
                    break;
                case 3:
                    displayCourses();
                    break;
                case 4:
                    registerStudentForCourse(scanner);
                    break;
                case 5:
                    dropStudentFromCourse(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCourse(Scanner scanner) {
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter Course Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Course Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Course Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Enter Course Schedule: ");
        String schedule = scanner.nextLine();
        
        System.out.print("Enter Professor name: ");
        String professor = scanner.nextLine();

        Course course = new Course(courseCode, title, description, capacity, schedule, professor);
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    private static void registerStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        Student student = new Student(studentID, name);
        students.add(student);
        System.out.println("Student registered successfully!");
    }

    private static void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
            System.out.println("-------------------------");
        }
    }

    private static void registerStudentForCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Enter Course Code to register: ");
        String courseCode = scanner.nextLine();

        Student student = findStudent(studentID);
        Course course = findCourse(courseCode);

        if (student != null && course != null) {
            if (student.registerForCourse(course)) {
                System.out.println(student.getStudentName() + " registered for " + course.getTitle());
            } else {
                System.out.println("Registration failed. No available slots for the course.");
            }
        } else {
            System.out.println("Student or Course not found.");
        }
    }

    private static void dropStudentFromCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Enter Course Code to drop: ");
        String courseCode = scanner.nextLine();

        Student student = findStudent(studentID);
        Course course = findCourse(courseCode);

        if (student != null && course != null) {
            student.dropCourse(course);
            System.out.println(student.getStudentName() + " dropped from " + course.getTitle());
        } else {
            System.out.println("Student or Course not found.");
        }
    }

    private static Student findStudent(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

}
