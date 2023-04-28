package dev.m3s.programming2.homework3;

import static dev.m3s.programming2.homework3.ConstantValues.*;

public abstract class Person {
    protected String firstName = NO_NAME;
    protected String lastName = NO_NAME;
    protected String birthDate = "Not available";

    public Person() {
    }

    public Person(String lastName, String firstName) {
        if (firstName != null)
            this.firstName = firstName;
        if (lastName != null)
            this.lastName = lastName;
    }

    // firstName
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null)
            this.firstName = firstName;
    }

    // lastName
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null)
            this.lastName = lastName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String setBirthDate(String personId) {
        if (personId == null)
            return "No change";
        PersonID idChecker = new PersonID();
        String returnString = idChecker.setPersonId(personId);
        if (returnString.equals("Ok")) {
            this.birthDate = idChecker.getBirthDate();
            return this.birthDate;
        }
        return "No change";

    }

    protected int getRandomId(final int min, final int max) {
        return (int) (Math.random() * max - 1) + min;
    }

}
