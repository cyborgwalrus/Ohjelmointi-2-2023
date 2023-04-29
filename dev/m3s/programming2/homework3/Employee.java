package dev.m3s.programming2.homework3;

import static dev.m3s.programming2.homework3.ConstantValues.*;

public abstract class Employee extends Person implements Payment {
    private String empId;
    private int startYear;
    private Payment payment;

    public Employee() {
        this.empId = getEmployeeIdString();
        this.empId += getRandomId(MIN_EMP_ID, MAX_EMP_ID);
        startYear = CURRENT_YEAR;
    }

    public Employee(String lastName, String firstName) {
        super(lastName, firstName);
        this.empId = getEmployeeIdString();
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

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        if (payment != null)
            this.payment = payment;
    }

    public double calculatePayment() {
        if (getPayment() == null)
            return 0.0;
        else
            return this.payment.calculatePayment();
    }

    abstract protected String getEmployeeIdString();

    public String toString() {
        String outputString = "";

        outputString += String.format("Employee id: %s\n", getIdString());
        outputString += indent(1) + String.format("First name: %s, Last name: %s\n", getFirstName(), getLastName());
        outputString += indent(1) + String.format("Birthdate: %s\n", getBirthDate());
        outputString += indent(1) + String.format("Start Year: %s\n", getStartYear());
        outputString += indent(1) + String.format("Salary: %.2f\n", calculatePayment());

        return outputString;
    }

}