public class FullTimeTeacher extends Teacher {
    private int experienceYears = 0;

    public FullTimeTeacher(int baseSalaryPerHour, int experienceYears) {
        this.baseSalaryPerHour = baseSalaryPerHour;
        this.experienceYears = experienceYears;
        calculateSalary();
    }

    public void calculateSalary(){

    }

    public void showDetails(){

    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}
