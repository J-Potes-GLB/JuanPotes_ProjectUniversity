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

    public void showDetails(){
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
