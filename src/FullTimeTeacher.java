public class FullTimeTeacher extends Teacher {
    private int experienceYears = 0;

    // Constructor
    public FullTimeTeacher(String name, int id, int baseSalaryPerHour, int experienceYears) {
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

    }

    // Getters and Setters
    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}
