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

    public void increaseActiveHours(int additionalHours){
        this.activeHoursPerWeek += additionalHours;
    }

    public void calculateSalary(){

    }
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
