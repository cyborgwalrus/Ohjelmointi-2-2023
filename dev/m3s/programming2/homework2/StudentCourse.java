package dev.m3s.programming2.homework2;

import static dev.m3s.programming2.homework2.ConstantValues.*;

public class StudentCourse {
    private Course course;
    private int gradeNum;
    private int yearCompleted;

    public StudentCourse() {
    }

    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    protected void setGrade(int gradeNum) {
        gradeNum = Character.toUpperCase(gradeNum);
        if (checkGradeValidity(gradeNum)) {
            if (getYear() == 0)
                setYear(CURRENT_YEAR);
            this.gradeNum = gradeNum;
        }
    }

    private boolean checkGradeValidity(final int gradeNum) {
        if (0 < gradeNum && gradeNum <= 5)
            return true;
        if (gradeNum == GRADE_FAILED || gradeNum == GRADE_ACCEPTED)
            return true;
        return false;
    }

    public boolean isPassed() {
        if (getGradeNum() == GRADE_ACCEPTED)
            return true;
        if(0 < getGradeNum() && getGradeNum() <= 5)
            return true;
        return false;
    }

    public int getYear() {
        return yearCompleted;
    }

    public void setYear(final int year) {
        if (2000 < year && year <= CURRENT_YEAR)
            this.yearCompleted = year;
    }

    public String toString() {
        String grade;
        int gradeNum = getGradeNum();
        switch (gradeNum) {
            case 0:
                grade = "\"Not graded\"";
                break;

            case GRADE_ACCEPTED:
            case GRADE_FAILED:
                grade = Character.toString(gradeNum);
                break;

            default:
                grade = Integer.toString(gradeNum);
                break;
        }

        return course.toString() + String.format(" Year: %d, Grade:%s.]\n", getYear(), grade);
    }

    public static void main(String[] args) {
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.00, true);
        StudentCourse studentCourse1 = new StudentCourse(course1, 'A', 2021);
        System.out.println(studentCourse1.toString());
    }
}