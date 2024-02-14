public class Teacher extends Person implements Details {
    protected double baseSalaryPerHour = 0.0;
    protected double fullSalaryPerWeek = 0.0;

    // Methods
    public void calculateSalary(){

    }
    public void showDetails(){

    }

    public void showDetails(int index){
        if(index == 0){
            System.out.println(String.format("%-10s %-20s %-20s %-20s %-20s %-20s %-20s", "ID", "NAME", "TYPE", "EXPERIENCE YEARS", "BASE SALARY/HOUR", "HOURS/WEEK", "SALARY/WEEK"));
        }
        showDetails();
    }

    // Getters and Setters
    public double getBaseSalaryPerHour() {
        return baseSalaryPerHour;
    }

    public void setBaseSalaryPerHour(double baseSalaryPerHour) {
        this.baseSalaryPerHour = baseSalaryPerHour;
    }

    public double getFullSalaryPerWeek() {
        return fullSalaryPerWeek;
    }

    public void setFullSalaryPerWeek(double fullSalaryPerWeek) {
        this.fullSalaryPerWeek = fullSalaryPerWeek;
    }
}
