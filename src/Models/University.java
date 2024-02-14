package Models;

import Models.Persons.Teachers.FullTimeTeacher;
import Models.Persons.Teachers.PartTimeTeacher;
import Models.Persons.Student;
import Models.Persons.Teachers.Teacher;
import Util.*;

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

    // Method to execute the main menu options
    public void executeOptions(){
        int option;
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

    // Method to show all the classes
    public void showClasses(){
        if(!this.classes.isEmpty()){
            System.out.println("\nALL CLASSES");
            for(int i = 0; i < this.classes.size(); i++){
                this.classes.get(i).showDetails(i);
            }
        }
        else{
            System.out.println("\nCurrently there are no classes in the list.");
        }
    }

    // Method to show all the teachers
    public void showTeachers(){
        if(!this.teachers.isEmpty()){
            System.out.println("\nALL TEACHERS");
            for (int i = 0; i < this.teachers.size(); i++){
                this.teachers.get(i).showDetails(i);
            }
        }
        else{
            System.out.println("\nCurrently there are no teachers in the list.");
        }
    }

    // Method to show all the students
    public void showStudents(){
        if(!this.students.isEmpty()){
            System.out.println("\nALL STUDENTS");
            for (int i = 0; i < this.students.size(); i++){
                this.students.get(i).showDetails(i);
            }
        }
        else{
            System.out.println("\nCurrently there are no students in the list.");
        }
    }

    // Method to execute the functionality of select a class and show all the details (with teacher and students)
    public void selectAndShowClass(){
        showClasses();
        if(!this.classes.isEmpty()){
            int index = selectClass("Please type the ID of a class to see more details: ");
            this.classes.get(index).showExtraDetails();
        }
    }

    // Method that returns a valid index based on the id of one the classes typed by the user
    private int selectClass(String requestMessage){
        int id = UserInput.inputExistingClassId(this.classes, requestMessage);
        return UserInput.indexOfUniClass(this.classes, id);
    }

    // Method that executes the functionality of creating a new student and adding it to an existing class
    public void createStudent(){
        // Creates the new student object with valid inputs from the user
        Student newStudent = UserInput.inputStudent(this.students);
        this.students.add(newStudent);
        System.out.println("\nThe student '" + newStudent.getName() + "' created successfully!");

        // Ask the user if they want to add the new student to a class
        int optionYN = UserInput.optionYesNoMenu("Do you wanna add the new student to an existing class? (Type the number of your choice): ");
        switch (optionYN){
            case 1:
                // Answer YES
                showClasses();
                if(!this.classes.isEmpty()){
                    // The user inputs the id of an existing class and the new student is added
                    int index = selectClass("Please type the ID of the class to add the Student: ");
                    addStudentToClass(newStudent, this.classes.get(index));
                }
                else{
                    System.out.println("\nThe student '" + newStudent.getName() + "' was NOT added to any classes.");
                }
                break;
            case 2:
                // Answer NO
                System.out.println("\nThe student '" + newStudent.getName() + "' was NOT added to any classes.");
                break;
            default:
                break;
        }
    }

    // Method that execute the functionality of adding an existing student to an existing class
    public void addStudentToClass(){
        // The user inputs a valid student id, and the list index of that student is saved
        showStudents();
        int indexStudent = selectStudent("Please type the ID of the STUDENT add to a class: ");

        // The user inputs a valid class id, and list index of that class is saved
        showClasses();
        int indexClass = selectClass("Please type the ID of the CLASS where the student will be added: ");

        // Add the selected student to the selected class
        addStudentToClass(this.students.get(indexStudent), this.classes.get(indexClass));
    }

    // Method to directly add a student to a class sending the objects as parameters (useful for quick initialization)
    public void addStudentToClass(Student student, UniClass uniClass){
        uniClass.addStudent(student);
    }

    // Method that will ask the user for a valid student id and returns the index of that student in the list
    private int selectStudent(String requestMessage){
        int idStudent = UserInput.inputExistingStudentId(this.students, requestMessage);
        return UserInput.indexOfStudent(this.students, idStudent);
    }

    // Method that will ask the user for a valid teacher id and returns the index of that teacher in the list
    private int selectTeacher(String requestMessage){
        int idTeacher = UserInput.inputExistingTeacherId(this.teachers, requestMessage);
        return UserInput.indexOfTeacher(this.teachers, idTeacher);
    }

    // Method that execute the functionality of creating a new class, adding the teacher and several students
    public void createClass(){
        // Creates the new class object
        UniClass newClass = UserInput.inputUniClass();

        // The user inputs a valid teacher id, and list index of that teacher is saved
        showTeachers();
        int indexTeacher = selectTeacher("Please type the ID of the TEACHER for the class: ");

        // The teacher is added to the new class
        newClass.setClassTeacher(this.teachers.get(indexTeacher));

        // Add multiple students
        addMultipleStudentsToClass(newClass);

        // The new class is added to the list
        this.classes.add(newClass);
    }

    // Method to keep adding students to a class until the user wants to stop
    public void addMultipleStudentsToClass(UniClass uniClass){
        int optionYN;
        do {
            // The user inputs a valid student id, and the list index of that student is saved
            showStudents();
            int indexStudent = selectStudent("Please type the ID of the STUDENT to add to the class ");

            // The student selected is added to the class
            uniClass.addStudent(this.students.get(indexStudent));

            // The user decides if they want to add another student (Answer YES), or stop there (Anwer NO)
            optionYN = UserInput.optionYesNoMenu("Would you like to add another student to the class " + uniClass.getName() + "? (Type the number of your choice): ");
        }while(optionYN != 2);
    }

    // Method that execute the functionality of showing all the classes of a specific student
    public void showClassesOfStudent(){
        List<UniClass> studentClasses = new ArrayList<>();
        if(!this.classes.isEmpty()){
            showStudents();
            int idStudent = UserInput.inputExistingStudentId(this.students,"Please type the name of the STUDENT to show their classes: ");
            int indexStudent = UserInput.indexOfStudent(this.students, idStudent);

            // Fill studentClasses List with the classes where the student is found
            for(UniClass c : this.classes){
                if(UserInput.indexOfStudent(c.getClassStudents(),idStudent) != -1){
                    studentClasses.add(c);
                }
            }

            // Show all the classes of the student
            if(!studentClasses.isEmpty()){
                System.out.println("\nCLASSES OF STUDENT '" + this.students.get(indexStudent).getName() + "'");
                for(int i = 0; i < studentClasses.size(); i++){
                    studentClasses.get(i).showDetails(i);
                }
            }
            else{
                System.out.println("\nThe student '" + this.students.get(indexStudent).getName() + "' is NOT ASSIGNED to any classes");
            }
        }
    }

    // Method that initialize values for testing
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
        this.students.add(new Student("Carol Mora", 2006, 20));

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
