package dev.m3s.programming2.homework3;

import static dev.m3s.programming2.homework3.ConstantValues.*;

public class Employee extends Person implements Payment {
    private String empId;
    private int startYear;
    private double salary;

    public Employee() {
        this.empId = "OY_";
        this.empId += getRandomId(MIN_EMP_ID, MAX_EMP_ID);
        startYear = CURRENT_YEAR;
    }

    public Employee(String lastName, String firstName) {
        super(lastName, firstName);
        this.empId = "OY_";
        this.empId += getRandomId(MIN_EMP_ID, MAX_EMP_ID);
        startYear = CURRENT_YEAR;
    }

    public String getIdString() {
        return this.empId;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public void setStartYear(final int startYear) {
        if (2000 < startYear && startYear <= CURRENT_YEAR)
            this.startYear = startYear;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(final double salary) {
        if (salary > 0.0)
            this.salary = salary;
    }

    public double calculatePayment() {
        return this.salary * 1.5;
    }

    public String getEmployeeIdString() {
        return this.empId.substring(0,2);
    }

    public String toString() {
        String outputString = "";

        outputString += String.format("Employee id: %s\n", getIdString());
        outputString += indent(1) + String.format("First name: %s, Last name: %s\n", getFirstName(), getLastName());
        outputString += indent(1) + String.format("Birthdate: %s\n", getBirthDate());
        outputString += indent(1) + String.format("Start Year: %s\n", getStartYear());
        outputString += indent(1) + String.format("Salary: %.2f\n", calculatePayment());

        return outputString;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setLastName("The Dog");
        employee1.setFirstName("Goofy");
        employee1.setBirthDate("141200A2315");
        employee1.setSalary(150);

        System.out.print(employee1.toString());

    }
}