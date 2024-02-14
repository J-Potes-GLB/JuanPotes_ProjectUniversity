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
    public void calculateSalary(){

    }

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
