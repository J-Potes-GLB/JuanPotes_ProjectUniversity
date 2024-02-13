import java.util.ArrayList;
import java.util.List;

public class University {
    private List<UniClass> classes = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    // Constructor
    public University() {
    }

    // Methods
    public void executeOptions(){

    }

    public void showClasses(){

    }

    public void showTeachers(){

    }

    public void showStudents(){

    }

    public void selectAndShowClass(){

    }

    public void selectClass(){
        // Check if its necessary
    }

    public void createStudent(){

    }

    public void addStudentToClass(){

    }

    public void createClass(){

    }

    public void showClassesOfStudent(){

    }

    // Getters and Setters
    public List<UniClass> getClasses() {
        return classes;
    }

    public void setClasses(List<UniClass> classes) {
        this.classes = classes;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
