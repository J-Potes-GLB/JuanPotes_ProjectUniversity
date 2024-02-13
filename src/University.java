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

    public void initializeValues(){
        this.teachers.add(new FullTimeTeacher("Alberto Perez", 1001, 5000, 5));
        this.teachers.add(new FullTimeTeacher("Sara Garcia", 1002, 6000, 10));
        this.teachers.add(new PartTimeTeacher("Alex Jimenez", 1003, 4000));
        this.teachers.add(new PartTimeTeacher("Natalia Parra", 1004, 4300));

        this.classes.add(new UniClass("Matematicas 1", 4));
        this.classes.add(new UniClass("Quimica 2", 3));
        this.classes.add(new UniClass("Programacion 3", 3));
        this.classes.add(new UniClass("Dibujo 1", 2));

        this.students.add(new Student("Javier Rodriguez", 2001, 18));
        this.students.add(new Student("Milena Vargas", 2002, 20));
        this.students.add(new Student("Santiago Ruiz", 2003, 19));
        this.students.add(new Student("Luis Gomez", 2004, 21));
        this.students.add(new Student("John Pardo", 2005, 18));
        this.students.add(new Student("Carol Mora", 2001, 20));

        this.classes.get(0).setClassTeacher(this.teachers.get(3));
        this.classes.get(0).addStudent(this.students.get(0));
        this.classes.get(0).addStudent(this.students.get(2));
        this.classes.get(0).addStudent(this.students.get(4));

        this.classes.get(1).setClassTeacher(this.teachers.get(0));
        this.classes.get(1).addStudent(this.students.get(1));
        this.classes.get(1).addStudent(this.students.get(3));
        this.classes.get(1).addStudent(this.students.get(5));

        this.classes.get(2).setClassTeacher(this.teachers.get(2));
        this.classes.get(2).addStudent(this.students.get(1));
        this.classes.get(2).addStudent(this.students.get(0));
        this.classes.get(2).addStudent(this.students.get(2));

        this.classes.get(3).setClassTeacher(this.teachers.get(1));
        this.classes.get(3).addStudent(this.students.get(4));
        this.classes.get(3).addStudent(this.students.get(5));
        this.classes.get(3).addStudent(this.students.get(3));
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
