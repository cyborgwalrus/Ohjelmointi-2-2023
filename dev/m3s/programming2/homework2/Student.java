package dev.m3s.programming2.homework2;

import static dev.m3s.programming2.homework2.ConstantValues.*;

public class Student {
    private String firstName = NO_NAME;
    private String lastName = NO_NAME;
    private int id;
    private int startYear;
    private int graduationYear = 0;
    private String birthDate = "Not available";

    public Student() {
        id = getRandomId();
        startYear = CURRENT_YEAR;
    }

    public Student(String lastName, String firstName) {
        if (firstName != null)
            this.firstName = firstName;
        if (lastName != null)
            this.lastName = lastName;
        id = getRandomId();
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

    // id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id > 1 && id < 100)
            this.id = id;
    }

    // startYear
    public int getStartYear() {
        return this.startYear;
    }

    public void setStartYear(final int startYear) {
        if (2000 < startYear && startYear <= CURRENT_YEAR)
            this.startYear = startYear;
    }

    // graduationYear
    public int getGraduationYear() {
        return this.graduationYear;
    }

    // TODO implement changes
    public String setGraduationYear(final int graduationYear) {
        if (canGraduate() == false)
            return "Check required studies";
        if (graduationYear < getStartYear() || graduationYear > CURRENT_YEAR)
            return "Check graduation year";

        this.graduationYear = graduationYear;
        return "Ok";
    }

    public boolean hasGraduated() {
        // If graduationYear hasn't been set, returns false
        if (this.graduationYear == 0)
            return false;

        if (this.graduationYear <= CURRENT_YEAR)
            return true;
        else
            return false;

    }

    private boolean canGraduate() {
        boolean hasRequiredBachelorCredits = getBachelorCredits() >= BACHELOR_CREDITS;
        boolean hasRequiredMasterCredits = getMasterCredits() >= MASTER_CREDITS;

        boolean hasTitleOfBachelorThesis = getTitleOfBachelorThesis() != NO_TITLE;
        boolean hasTitleOfMastersThesis = getTitleOfMastersThesis() != NO_TITLE;

        if (hasRequiredBachelorCredits && hasRequiredMasterCredits
                && hasTitleOfBachelorThesis && hasTitleOfMastersThesis)
            return true;
        else
            return false;

    }

    public int getStudyYears() {
        if (hasGraduated())
            return getGraduationYear() - getStartYear();
        else
            return CURRENT_YEAR - getStartYear();
    }

    private int getRandomId() {
        return (int) (Math.random() * 99) + 1;
    }

}
