public class FullTimeTeacher extends Teacher {
    private int experienceYears = 0;

    // Constructor
    public FullTimeTeacher(int baseSalaryPerHour, int experienceYears) {
        this.baseSalaryPerHour = baseSalaryPerHour;
        this.experienceYears = experienceYears;
        calculateSalary();
    }

    // Methods
    public void calculateSalary(){

    }

    public void showDetails(){

    }

    // Getters and Setters
    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}
