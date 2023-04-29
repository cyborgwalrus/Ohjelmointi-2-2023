package dev.m3s.programming2.homework3;

import java.util.*;

public class AssistantTeacher extends Employee implements Teacher {
    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();

    public AssistantTeacher(String lastName, String firstName) {
        super(lastName, firstName);
    }

    public String getEmployeeIdString() {
        return "OY_ASSISTANT_";
    }

    public String getCourses() {
        String outputString = "";
        for (DesignatedCourse course : courses) {
            outputString += String.format("%s in %d\n", course.toString(), course.getYear());
        }
        return outputString;
    }

    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null)
            this.courses = courses;
    }

    public String toString() {
        String outputString = "";

        outputString += "Teacher id: " + getIdString();

        outputString += indent(1) + String.format("First name: %s, Last name: %s\n", getFirstName(), getLastName());
        outputString += indent(1) + String.format("Birthdate: %s\n", getBirthDate());
        outputString += indent(1) + String.format("Salary: %s\n", getSalary());
        outputString += indent(1) + "Assistant for courses:\n";
        for (DesignatedCourse course : courses) {
            outputString += course.toString() + "\n";
        }

        return outputString;

    }
}
