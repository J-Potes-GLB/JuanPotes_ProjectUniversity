package Models.Persons;

import Util.Details;

public class Student extends Person implements Details {
    private int age;

    // Constructor
    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    // Methods

    // Implementation of the Details interface method to show the details of the student
    // (The index is a parameter to only show the titles with the first element of a list and not with the rest)
    public void showDetails(int index){
        if(index == 0){
            System.out.println(String.format("%-10s %-20s %-10s", "ID", "NAME", "AGE"));
        }
        System.out.println(String.format("%-10s %-20s %-10s", this.id, this.name, this.age));
    }

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
