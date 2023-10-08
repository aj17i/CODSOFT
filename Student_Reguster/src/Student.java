
import java.util.ArrayList;
import java.util.List;

public class Student {

    private int studentID;
    private String studentName;
    private List<Course> registeredCourses;

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Course> getRegisteredCourse() {
        return registeredCourses;
    }

    public boolean registerForCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.dropStudent();
            registeredCourses.remove(course);
        }
    }

    @Override
    public String toString() {
        return """
               Student{
               studentID=""" + studentID +
                "\nstudentName=" + studentName +
                "\nregisteredCourses=" + registeredCourses + '}';
    }

}
