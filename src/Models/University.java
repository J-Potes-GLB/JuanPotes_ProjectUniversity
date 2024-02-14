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

    public void selectAndShowClass(){
        showClasses();
        if(!this.classes.isEmpty()){
            int index = selectClass("Please type the ID of a class to see more details: ");
            this.classes.get(index).showExtraDetails();
        }
    }

    public int selectClass(String requestMessage){
        int index;

        do{
            int classId = UserInput.inputPositiveInt(requestMessage);
            index = indexOfClass(classId);
            if(index == -1){
                System.out.println("\nThe class of ID:" + classId + " does NOT exist. Try again.");
            }
        }while(index == -1);

        return index;
    }

    public int indexOfClass(int id){
        int index = -1;
        for(int i = 0; i < this.classes.size(); i++)
        {
            if(this.classes.get(i).idEquals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void createStudent(){
        Student newStudent = UserInput.inputStudent();
        this.students.add(newStudent);
        System.out.println("\nThe student '" + newStudent.getName() + "' created successfully!");

        int optionYN = UserInput.optionYesNoMenu("Do you wanna add the new student to an existing class? (Type the number of your choice): ");

        switch (optionYN){
            case 1:
                showClasses();
                if(!this.classes.isEmpty()){
                    int index = selectClass("Please type the ID of the class to add the Student: ");
                    addStudentToClass(newStudent, this.classes.get(index));
                }
                else{
                    System.out.println("\nThe student '" + newStudent.getName() + "' was NOT added to any classes.");
                }
                break;
            case 2:
                System.out.println("\nThe student '" + newStudent.getName() + "' was NOT added to any classes.");
                break;
            default:
                break;
        }
    }

    public void addStudentToClass(){
        
    }

    public void addStudentToClass(Student student, UniClass uniClass){
        uniClass.addStudent(student);
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
