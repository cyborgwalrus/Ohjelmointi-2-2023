package dev.m3s.programming2.homework3;

import static dev.m3s.programming2.homework2.ConstantValues.*;

public class Course {
    private String name = NO_TITLE;
    private String courseCode = NOT_AVAILABLE;
    private char courseBase = ' ';
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;

    public Course() {
    }

    public Course(String name, final int code,
            Character courseBase, final int type, final int period, final double credits, boolean numericGrade) {
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);
    }

    public Course(Course course) {
        setName(course.getName());
        String courseCode = course.getCourseCode();
        courseCode = courseCode.substring(0, courseCode.length()-1);
        setCourseCode(Integer.parseInt(courseCode), course.getCourseBase());
        setCourseType(course.getCourseType());
        setPeriod(course.getPeriod());
        setCredits(course.getCredits());
        setNumericGrade(course.isNumericGrade());
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
        if (type == 1 || type == 0)
            this.courseType = type;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(final int courseCode, Character courseBase) {
        courseBase = Character.toUpperCase(courseBase);
        boolean courseCodeIsValid = 0 < courseCode && courseCode < 1000000;
        boolean courseBaseIsValid = courseBase == 'A' || courseBase == 'P' || courseBase == 'S';

        if (courseCodeIsValid && courseBaseIsValid) {
            this.courseCode = Integer.toString(courseCode) + courseBase;
            this.courseBase = courseBase;
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
        if (MIN_CREDITS <= credits && credits <= MAX_COURSE_CREDITS)
            this.credits = credits;
    }

    public boolean isNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    public String toString() {
        return String.format("[%s ( %2.2f cr), \"%s\". %s, period: %d.]",
                getCourseCode(), getCredits(), getName(), getCourseTypeString(), getPeriod());
    }

    public static void main(String[] args) {
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.00, true);
        System.out.println(course1.toString());

        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.00, true);
        System.out.println(course2.toString());
    }
}