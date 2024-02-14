package Models.Persons.Teachers;

import Models.Persons.Person;
import Util.Details;

public class Teacher extends Person implements Details {
    protected double baseSalaryPerHour = 0.0;
    protected double fullSalaryPerWeek = 0.0;

    // Methods

    // Method to calculate the salary of the teacher (Override in the subclasses)
    public void calculateSalary(){}

    // Implementation of the Details interface method (Override in the subclasses)
    public void showDetails(int index){}

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
