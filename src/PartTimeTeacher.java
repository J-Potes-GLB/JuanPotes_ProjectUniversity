public class PartTimeTeacher extends Teacher {
    private int activeHoursPerWeek = 0;

    public PartTimeTeacher(double baseSalaryPerHour, int activeHoursPerWeek) {
        this.baseSalaryPerHour = baseSalaryPerHour;
        this.activeHoursPerWeek = activeHoursPerWeek;
        calculateSalary();
    }

    public void calculateSalary(){

    }
    public void showDetails(){

    }
}
