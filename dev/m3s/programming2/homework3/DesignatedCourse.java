package dev.m3s.programming2.homework3;

import static dev.m3s.programming2.homework3.ConstantValues.*;

public class DesignatedCourse {
    private Course course;
    private boolean responsible;
    private int year;

    public DesignatedCourse() {
    }

    public DesignatedCourse(Course course, boolean responsible, int year) {
        setCourse(course);
        setResponsible(responsible);
        setYear(year);
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        if (course != null)
            this.course = course;
    }

    public boolean isResponsible() {
        return this.responsible;
    }

    public boolean getResponsible() {
        return this.responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if (2000 <= year && year <= CURRENT_YEAR + 1)
            this.year = year;
    }

    public String toString() {

        return String.format("[course=%s,  year=%d]", getCourse().toString(), getYear());
    }

}