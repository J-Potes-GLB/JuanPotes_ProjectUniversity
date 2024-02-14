package Models.Persons.Teachers;

public class FullTimeTeacher extends Teacher {
    private int experienceYears = 0;
    private final String type = "Full time";

    // Constructor
    public FullTimeTeacher(String name, int id, double baseSalaryPerHour, int experienceYears) {
        this.name = name;
        this.id = id;
        this.baseSalaryPerHour = baseSalaryPerHour;
        this.experienceYears = experienceYears;
        calculateSalary();
    }

    // Methods

    // Method to calculate the salary of full time teachers, in this case, the base salary increments by 10% of the baseSalary for every year of experience.
    // As full time teacher, the amount of hours worked in a week is 40.
    public void calculateSalary(){
        this.fullSalaryPerWeek = (this.baseSalaryPerHour + (0.1 * this.baseSalaryPerHour * this.experienceYears)) * 40;
    }

    // Method to show the details of the teacher (The index is a parameter to only show the titles with the first element of a list and not with the rest)
    public void showDetails(int index){
        if(index == 0){
            System.out.println(String.format("%-10s %-20s %-20s %-20s %-20s %-20s %-20s", "ID", "NAME", "TYPE", "EXPERIENCE YEARS", "BASE SALARY/HOUR", "HOURS/WEEK", "SALARY/WEEK"));
        }
        System.out.println(String.format("%-10s %-20s %-20s %-20s %-20s %-20s %-20s", this.id, this.name, this.type, this.experienceYears, this.baseSalaryPerHour, 40, this.fullSalaryPerWeek));
    }

    // Getters and Setters
    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}
