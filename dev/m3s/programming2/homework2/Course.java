package dev.m3s.programming2.homework2;

import static dev.m3s.programming2.homework2.ConstantValues.*;

public class Course {
    // TODO add default values?
    private String name;
    private String courseCode;
    private char courseBase;
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;

    // TODO implement contructors
    public Course() {
    }

    public Course(String name, final int code,
            Character courseBase, final int type, final int period, final double credits, boolean numericGrade) {
    }

    public Course(Course course) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.equals(""))
            this.name = name;
    }

    public String getCourseTypeString() {
        switch (courseType) {
            case 0:
                return "Optional";
            case 1:
                return "Mandatory";
            default:
                return "";
        }
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(final int type) {
        if (type != 1 || type != 0)
            ;
        this.courseType = type;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(final int courseCode, Character courseBase) {
        boolean courseCodeIsValid = 0 < courseCode && courseCode < 1000000;
        boolean courseBaseIsValid = courseBase == 'A' || courseBase == 'P' || courseBase == 'S';

        if (courseCodeIsValid && courseBaseIsValid) {
            this.courseCode = Integer.toString(courseCode) + courseBase;
        }
    }

    public Character getCourseBase() {
        return courseBase;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(final int period) {
        if (MIN_PERIOD <= period && period <= MAX_PERIOD)
            this.period = period;
    }

    public double getCredits() {
        return credits;
    }

    private void setCredits(final double credits) {
        if (0 <= credits && credits <= MAX_COURSE_CREDITS)
            this.credits = credits;
    }

    public boolean isNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    public String toString() {
        return String.format("[%s ( %.2f cr), \"%s\". %s, period: %i.]",
                getCourseCode(), getCredits(), getName(), getCourseTypeString(), getPeriod());
    }
}