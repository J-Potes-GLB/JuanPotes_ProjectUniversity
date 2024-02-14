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
