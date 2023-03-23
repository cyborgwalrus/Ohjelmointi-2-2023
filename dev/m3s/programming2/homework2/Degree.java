package dev.m3s.programming2.homework2;

import static dev.m3s.programming2.homework2.ConstantValues.*;

public class Degree {
    private static final int MAX_COURSES = 50;
    private int count = 0;
    private String degreeTitle = NO_TITLE;
    private String titleOfThesis = NO_TITLE;
    private StudentCourse[] myCourses = new StudentCourse[MAX_COURSES];

    // TODO
    // toString

    public StudentCourse[] getCourses() {
        return myCourses;
    }

    public int getCount() {
        return count;
    }

    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && this.count < MAX_COURSES) {
            this.myCourses[count] = course;
            count++;
            return true;
        }

        return false;
    }

    public void addStudentCourses(StudentCourse[] courses) {
        for (StudentCourse course : courses) {
            addStudentCourse(course);
        }
    }

    public String getDegreeTitle() {
        return this.degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        if (!degreeTitle.equals(null))
            this.degreeTitle = degreeTitle;
    }

    public String getTitleOfThesis() {
        return this.titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis) {
        if (!titleOfThesis.equals(null))
            this.titleOfThesis = titleOfThesis;
    }

    private boolean isCourseCompleted(StudentCourse c) {
        if (c == null)
            return false;
        if (c.isPassed())
            return true;

        return false;
    }

    public double getCreditsByBase(char base) {
        double credits = 0;
        for (StudentCourse course : getCourses()) {
            if (isCourseCompleted(course) && course.getCourse().getCourseBase() == base)
                credits += course.getCourse().getCredits();
        }

        return credits;
    }

    public double getCreditsByType(final int courseType) {
        double credits = 0;
        for (StudentCourse course : getCourses()) {
            if (isCourseCompleted(course) && course.getCourse().getCourseType() == courseType)
                credits += course.getCourse().getCredits();
        }

        return credits;
    }

    public double getCredit() {
        double credits = 0;
        for (StudentCourse course : getCourses()) {
            if (isCourseCompleted(course))
                credits += course.getCourse().getCredits();
        }

        return credits;
    }

    public String printCourses() {
        String outputString = "";
        for (StudentCourse course : myCourses) {
            if (course != null)
                outputString += course.toString();
        }
        return outputString;
    }

    public String toString() {
        String outputString = "";
        int courseNum = 1;
        outputString += String.format("Degree [Title: \"%s\" (courses: %d)\n", getDegreeTitle(), getCount());
        outputString += String.format(INDENTATION + "Thesis title: \"%s\"\n", getTitleOfThesis());
        for (StudentCourse course : myCourses) {
            if (course != null) {
                outputString += String.format(INDENTATION + "%d. %s\n", courseNum, course.toString());
                courseNum++;
            }
        }
        //trim is needed to remove the last redundant newline character
        return outputString.trim() + "]";
    }

    public static void main(String[] args){
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.00, true);
        StudentCourse studentCourse1 = new StudentCourse(course1, 'A', 2021);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.00, true);
        StudentCourse studentCourse2 = new StudentCourse(course2, 1, 2014);
        
        Degree degree1 = new Degree();
        degree1.setDegreeTitle("Bachelor of Science");
        degree1.setTitleOfThesis("Christmas - The most wonderful time of the year");
        degree1.addStudentCourse(studentCourse1);
        degree1.addStudentCourse(studentCourse2);
        
        System.out.println(degree1.toString());
    }
}
