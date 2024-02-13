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
        int option = 0;
        do{
            option = UserInput.optionMainMenu();

            switch(option){
                case 1:
                    showClasses();
                    break;
                case 2:
                    showTeachers();
                    break;
                case 3:
                    showStudents();
                    break;
                case 4:
                    selectAndShowClass();
                    break;
                case 5:
                    createStudent();
                    break;
                case 6:
                    addStudentToClass();
                    break;
                case 7:
                    createClass();
                    break;
                case 8:
                    showClassesOfStudent();
                    break;
                default:
                    break;
            }
        }while(option != 9);
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
