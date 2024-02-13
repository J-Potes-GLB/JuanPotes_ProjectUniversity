public class PartTimeTeacher extends Teacher {
    private int activeHoursPerWeek = 0;

    // Constructor
    public PartTimeTeacher(String name, int id, double baseSalaryPerHour) {
        this.name = name;
        this.id = id;
        this.baseSalaryPerHour = baseSalaryPerHour;
        calculateSalary();
    }

    // Methods

    public void increaseActiveHours(int additionalHours){
        this.activeHoursPerWeek += additionalHours;
    }

    public void calculateSalary(){

    }
    public void showDetails(){

    }

    // Getters and Setters
    public int getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    public void setActiveHoursPerWeek(int activeHoursPerWeek) {
        this.activeHoursPerWeek = activeHoursPerWeek;
    }
}
