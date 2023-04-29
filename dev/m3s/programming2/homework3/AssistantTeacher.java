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
        // TODO
    }

    public void setCourses(List<DesignatedCourse> courses) {
        // TODO
    }

    public String toString() {
        // TODO
    }
}
