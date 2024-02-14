package Models;

import Models.Persons.Teachers.PartTimeTeacher;
import Models.Persons.Student;
import Models.Persons.Teachers.Teacher;
import Util.Details;

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
    public int indexOfStudent(int id){
        return 0;
    }

    public void addStudent(Student student){
        if (indexOfStudent(student.getId()) != -1){
            this.classStudents.add(student);
            System.out.println("\nModels.Persons.Student '" + student.getName() + "' was added to the class '" + this.name + "'");
        }
        else{
            System.out.println("\nThe student it's already in the class");
        }
    }

    public void showDetails(int index){
        if(index == 0){
            System.out.println(String.format("%-10s %-20s %-20s %-20s", "ID", "NAME", "WEEKLY HOURS", "NUMBER OF STUDENTS"));
        }
        System.out.println(String.format("%-10s %-20s %-20s %-20s", this.id, this.name, this.weeklyHours, this.classStudents.size()));
    }

    public void showExtraDetails(){

    }

    public boolean idEquals(int id){
        return id == this.id;
    }

    // Getters and Setters
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

    public void setClassTeacher(Teacher classTeacher) {
        this.classTeacher = classTeacher;

        if(this.classTeacher instanceof PartTimeTeacher){
            ((PartTimeTeacher) this.classTeacher).increaseActiveHours(this.weeklyHours);
        }
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public int getFreeClassId(){
        int taken = freeClassId;
        freeClassId++;
        return taken;
    }
}
