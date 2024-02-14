package Models.Persons.Teachers;

public class PartTimeTeacher extends Teacher {
    private int activeHoursPerWeek = 0;
    private final String type = "Part time";

    // Constructor
    public PartTimeTeacher(String name, int id, double baseSalaryPerHour) {
        this.name = name;
        this.id = id;
        this.baseSalaryPerHour = baseSalaryPerHour;
        calculateSalary();
    }

    // Methods

    // Method to increase the weekly active hours of the part-time teacher
    public void increaseActiveHours(int additionalHours){
        this.activeHoursPerWeek += additionalHours;
    }

    // Method to calculate the salary of part-time teachers, in this case, the base salary is multiplied by the amount of hours worked in the week.
    // The amount of hours worked depends on the classes assigned to the teacher.
    public void calculateSalary(){
        this.fullSalaryPerWeek = this.baseSalaryPerHour * this.activeHoursPerWeek;
    }

    // Method to show the details of the teacher (The index is a parameter to only show the titles with the first element of a list and not with the rest)
    public void showDetails(int index){
        if(index == 0){
            System.out.println(String.format("%-10s %-20s %-20s %-20s %-20s %-20s %-20s", "ID", "NAME", "TYPE", "EXPERIENCE YEARS", "BASE SALARY/HOUR", "HOURS/WEEK", "SALARY/WEEK"));
        }
        System.out.println(String.format("%-10s %-20s %-20s %-20s %-20s %-20s %-20s", this.id, this.name, this.type, "Irrelevant", this.baseSalaryPerHour, this.activeHoursPerWeek, this.fullSalaryPerWeek));
    }

    // Getters and Setters
    public int getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    public void setActiveHoursPerWeek(int activeHoursPerWeek) {
        this.activeHoursPerWeek = activeHoursPerWeek;
    }
}
