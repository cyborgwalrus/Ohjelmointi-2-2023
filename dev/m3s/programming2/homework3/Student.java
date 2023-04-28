package dev.m3s.programming2.homework3;

import static dev.m3s.programming2.homework3.ConstantValues.*;
import java.util.*;

//TODO create Employee
public class Student extends Person {

    private int id;
    private int startYear;
    private int graduationYear = 0;
    private int degreeCount = 3;
    private List<Degree> degrees;

    public Student() {
        id = getRandomId(MIN_STUDENT_ID, MAX_STUDENT_ID);
        startYear = CURRENT_YEAR;
        this.degrees = new ArrayList<Degree>(3);
        degrees.add(new Degree());
        degrees.add(new Degree());
        degrees.add(new Degree());
    }

    public Student(String lastName, String firstName) {
        this();
        if (firstName != null)
            this.firstName = firstName;
        if (lastName != null)
            this.lastName = lastName;
    }

    // id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (MIN_STUDENT_ID <= id && id <= MAX_STUDENT_ID)
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

    public String setGraduationYear(final int graduationYear) {
        if (canGraduate() == false)
            return "Check amount of required credits";
        if (graduationYear < getStartYear() || graduationYear > CURRENT_YEAR)
            return "Check graduation year";

        this.graduationYear = graduationYear;
        return "Ok";
    }

    public Degree getDegree(final int i) {
        return degrees.get(i);
    }

    public List<Degree> getDegrees() {
        return degrees;
    }

    public void setDegreeTitle(final int i, String degreeTitle) {
        if (degreeTitle != null && 0 <= i && i < degreeCount) {
            getDegree(i).setDegreeTitle(degreeTitle);
        }
    }

    public boolean addCourse(final int i, StudentCourse course) {
        if (course != null && 0 <= i && i < degreeCount) {
            return getDegree(i).addStudentCourse(course);
        }
        return false;
    }

    public int addCourses(final int i, List<StudentCourse> courses) {
        if (courses != null && 0 <= i && i < degreeCount) {
            int coursesBefore = getDegree(i).getCount();
            getDegree(i).addStudentCourses(courses);
            return getDegree(i).getCount() - coursesBefore;
        }
        return 0;
    }

    public void printCourses() {
        for (int i = 0; i < degreeCount; i++) {
            getDegree(i).printCourses();
        }

    }

    public void printDegree(final int i) {
        System.out.println(getDegree(i).toString());
    }

    public void printDegrees() {
        for (int i = 0; i < degreeCount; i++) {
            printDegree(i);
        }
    }

    public void setTitleOfThesis(final int i, String title) {
        if (title != null && 0 <= i && i < degreeCount)
            getDegree(i).setTitleOfThesis(title);
    }

    public boolean hasGraduated() {
        if (this.graduationYear == 0)
            return false;

        if (this.graduationYear <= CURRENT_YEAR)
            return true;
        else
            return false;

    }

    private boolean canGraduate() {
        if (getDegree(BACHELOR).getCredits() < BACHELOR_CREDITS)
            return false;
        if (getDegree(BACHELOR).getTitleOfThesis() == NO_TITLE)
            return false;

        if (getDegree(MASTER).getCredits() < MASTER_CREDITS)
            return false;
        if (getDegree(MASTER).getTitleOfThesis() == NO_TITLE)
            return false;

        return true;

    }

    public int getStudyYears() {
        if (hasGraduated())
            return getGraduationYear() - getStartYear();
        else
            return CURRENT_YEAR - getStartYear();
    }

    public StudentCourse getStudentCourseByCourseCode(String courseCode) {
        StudentCourse studentCourse;
        for (int i = 0; i < degreeCount; i++) {
            studentCourse = getDegree(i).getStudentCourseByCourseCode(courseCode);
            if (studentCourse != null)
                return studentCourse;
        }
        return null;
    }

    public String toString() {
        String outputString = "";

        outputString += String.format("Student id: %s\n", getId());
        outputString += indent(1) + String.format("First name: %s, Last name: %s\n", getFirstName(), getLastName());
        outputString += indent(1) + String.format("Date of birth: \"%s\"\n", birthDate);

        if (hasGraduated())
            outputString += indent(1) + String.format("Status: The student has graduated in %s\n",
                    getGraduationYear());
        else
            outputString += indent(1) + "Status: The student has not graduated, yet.\n";

        outputString += indent(1) + String.format("StartYear: %s (studies have lasted for %s years)\n",
                getStartYear(), getStudyYears());
        outputString += indent(1) + String.format("Total credits: %.1f\n",
                getDegree(BACHELOR).getCredits() + getDegree(MASTER).getCredits());

        outputString += getBachelorString(1);
        outputString += getMasterString(1);
        
        return outputString;
    }

    public String indent(int n) {
        String outputString = "";
        for (int i = 0; i < n; i++) {
            outputString += INDENT;
        }
        return outputString;
    }

    public String getIdString() {
        return String.format("Student id: %d", getId());
    }

    public String getBachelorString(int indents) {
        String outputString = "";
        outputString += indent(indents) + String.format("Bachelor credits: %.1f\n", getDegree(BACHELOR).getCredits());
        if (getDegree(BACHELOR).getCredits() < BACHELOR_CREDITS) {
            outputString += indent(indents + 1) + String.format("Missing bachelor credits %.1f (%.1f/%.1f)\n",
                    BACHELOR_CREDITS - getDegree(BACHELOR).getCredits(), getDegree(BACHELOR).getCredits(),
                    BACHELOR_CREDITS);
        } else {
            outputString += indent(indents + 1) + String.format("Total bachelor credits completed (%.1f/%.1f)\n",
                    getDegree(BACHELOR).getCredits(), BACHELOR_CREDITS);
        }
        outputString += indent(indents + 1)
                + String.format("Title of BSc Thesis: \"%s\"\n", getDegree(BACHELOR).getTitleOfThesis());
        return outputString;
    }

    public String getMasterString(int indents){
        String outputString = "";
        outputString += indent(indents) + String.format("Master credits: %.1f\n", getDegree(MASTER).getCredits());
        if (getDegree(MASTER).getCredits() < MASTER_CREDITS) {
            outputString += indent(indents+1) + String.format("Missing master's credits %.1f (%.1f/%.1f)\n",
                    MASTER_CREDITS - getDegree(MASTER).getCredits(), getDegree(MASTER).getCredits(), MASTER_CREDITS);
        } else {
            outputString += indent(indents+1) + String.format("Total master's credits completed (%.1f/%.1f)\n",
                    getDegree(MASTER).getCredits(), MASTER_CREDITS);
        }
        outputString += indent(indents+1)
                + String.format("Title of MSc Thesis: \"%s\"\n", getDegree(MASTER).getTitleOfThesis());
        return outputString;
    }

    public static void main(String[] args) {
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 1, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 818181, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies", 919191, 'S', 1, 3, 20.0, false);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);

        StudentCourse studentCourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse studentCourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse studentCourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse studentCourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse studentCourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse studentCourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse studentCourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse studentCourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse studentCourse9 = new StudentCourse(course9, 0, 2021);
        StudentCourse studentCourse10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse studentCourse11 = new StudentCourse(course11, 'f', 2022);

        List<StudentCourse> studentCoursesBachelor = new ArrayList<StudentCourse>();
        List<StudentCourse> studentCoursesMaster = new ArrayList<StudentCourse>();
        studentCoursesBachelor.add(studentCourse1);
        studentCoursesBachelor.add(studentCourse2);
        studentCoursesBachelor.add(studentCourse3);
        studentCoursesBachelor.add(studentCourse4);
        studentCoursesBachelor.add(studentCourse5);
        studentCoursesMaster.add(studentCourse6);
        studentCoursesMaster.add(studentCourse7);
        studentCoursesMaster.add(studentCourse8);
        studentCoursesMaster.add(studentCourse9);
        studentCoursesMaster.add(studentCourse10);
        studentCoursesMaster.add(studentCourse11);

        Student student1 = new Student();
        student1.getDegree(BACHELOR).setDegreeTitle("Bachelor of Science");
        student1.getDegree(MASTER).setDegreeTitle("Master of Science");

        student1.getDegree(BACHELOR).setTitleOfThesis("Bachelor thesis title");
        student1.getDegree(MASTER).setTitleOfThesis("Master thesis title");

        student1.addCourses(BACHELOR, studentCoursesBachelor);
        student1.addCourses(MASTER, studentCoursesMaster);

        student1.setStartYear(2001);
        student1.setGraduationYear(2020);
        student1.setFirstName("Donald");
        student1.setLastName("Duck");
        System.out.println(student1.toString());

        student1.setBirthDate("230498-045T");
        student1.getDegree(BACHELOR).setTitleOfThesis("Christmas - The most wonderful time of the year");
        student1.getDegree(MASTER).setTitleOfThesis("Dreaming of a white Christmas");
        student1.printDegrees();
        student1.getStudentCourseByCourseCode("919191S").setGrade(3);
        System.out.println(student1.toString());

        student1.printDegrees();
        student1.printCourses();

        StudentCourse studentCourse = student1.getStudentCourseByCourseCode("888888S");
        studentCourse.setGrade('X');
        System.out.print(studentCourse.toString());
        studentCourse.setGrade('a');
        System.out.print(studentCourse.toString());

        studentCourse = student1.getStudentCourseByCourseCode("811104P");
        studentCourse.setGrade(6);
        System.out.print(studentCourse.toString());
        studentCourse.setGrade(5);
        System.out.print(studentCourse.toString());

    }

}
