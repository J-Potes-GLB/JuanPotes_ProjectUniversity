public class Teacher extends Person implements Details {
    double baseSalaryPerHour = 0.0;
    double fullSalaryPerWeek = 0.0;

    // Methods
    public void calculateSalary(){

    }
    public void showDetails(){

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
