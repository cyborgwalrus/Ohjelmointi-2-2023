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
    // TODO getName, setName, getCourseTypeString, getCourseType,
    // setCourseType, getCourseCode, setCourseCode, getCourseBase, getPeriod,
    // setPeriod, getCredits, setCredits, isNumericGrade, setNumericGrade, toString
}
