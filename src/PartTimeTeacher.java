public class PartTimeTeacher extends Teacher {
    private int activeHoursPerWeek = 0;

    // Constructor
    public PartTimeTeacher(String name, int id, double baseSalaryPerHour, int activeHoursPerWeek) {
        this.name = name;
        this.id = id;
        this.baseSalaryPerHour = baseSalaryPerHour;
        this.activeHoursPerWeek = activeHoursPerWeek;
        calculateSalary();
    }

    // Methods
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
