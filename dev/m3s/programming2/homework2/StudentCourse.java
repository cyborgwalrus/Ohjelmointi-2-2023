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
        if (checkGradeValidity(gradeNum)) {
            if (getYear() == 0)
                setYear(CURRENT_YEAR);
            this.gradeNum = gradeNum;
        }
    }

    private boolean checkGradeValidity(final int gradeNum) {
        if (0 <= gradeNum && gradeNum <= 5)
            return true;
        if (gradeNum == GRADE_FAILED || gradeNum == GRADE_ACCEPTED)
            return true;
        return false;
    }

    public boolean isPassed() {
        if (getGradeNum() == 0 || getGradeNum() == GRADE_FAILED)
            return false;
        return true;
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

        return course.toString() + String.format("] Year: %i, Grade:%s.]", getYear(), grade);
    }
}