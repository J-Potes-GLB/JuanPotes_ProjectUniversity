package Models;

import Models.Persons.Teachers.PartTimeTeacher;
import Models.Persons.Student;
import Models.Persons.Teachers.Teacher;
import Util.Details;
import Util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class UniClass implements Details {
    private int id;
    private String name;
    private List<Student> classStudents = new ArrayList<>();
    private Teacher classTeacher;
    private int weeklyHours;
    private static int freeClassId = 1;

    // Constructor
    public UniClass(String name, int weeklyHours) {
        this.id = getFreeClassId();
        this.name = name;
        this.weeklyHours = weeklyHours;
    }

    // Methods

    // Method to add a student to the class, only if the student is not already in the class
    public void addStudent(Student student){
        if (UserInput.indexOfStudent(this.classStudents, student.getId()) == -1){
            this.classStudents.add(student);
            System.out.println("\nThe student '" + student.getName() + "' was added to the class '" + this.name + "'");
        }
        else{
            System.out.println("\nThe student it's already in the class");
        }
    }

    // Implementation of the Details interface method to show the general details of the class
    // (The index is a parameter to only show the titles with the first element of a list and not with the rest)
    public void showDetails(int index){
        if(index == 0){
            System.out.println(String.format("%-10s %-20s %-20s %-20s", "ID", "NAME", "WEEKLY HOURS", "NUMBER OF STUDENTS"));
        }
        System.out.println(String.format("%-10s %-20s %-20s %-20s", this.id, this.name, this.weeklyHours, this.classStudents.size()));
    }

    // Method to show the specific extra details of the class (attributes, teacher and students)
    public void showExtraDetails(){
        System.out.println("\nDETAILS OF CLASS '" + this.id + "'");
        showDetails(0);

        System.out.println("\nTEACHER OF CLASS '" + this.id + "'");
        this.classTeacher.showDetails(0);

        System.out.println("\nSTUDENTS OF CLASS '" + this.id + "'");
        for(int i = 0; i < this.classStudents.size(); i++){
            this.classStudents.get(i).showDetails(i);
        }
    }

    // Method to check if an id sent as parameter is the same as the id of the class
    public boolean idEquals(int id){
        return id == this.id;
    }

    // Getters and Setters

    // Setter for the teacher of the class, in case of part-time teachers the active hours are updated and the salary is recalculated
    public void setClassTeacher(Teacher classTeacher) {
        this.classTeacher = classTeacher;

        if(this.classTeacher instanceof PartTimeTeacher){
            ((PartTimeTeacher) this.classTeacher).increaseActiveHours(this.weeklyHours);
            this.classTeacher.calculateSalary();
        }
    }

    // Getter for the static value freeClassId, the value is changed everytime so that all classes have different id numbers
    public static int getFreeClassId(){
        int taken = freeClassId;
        freeClassId++;
        return taken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(List<Student> classStudents) {
        this.classStudents = classStudents;
    }

    public Teacher getClassTeacher() {
        return classTeacher;
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }
}
