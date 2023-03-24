package dev.m3s.programming2.homework2;

import static dev.m3s.programming2.homework2.ConstantValues.*;

public class Student {
    private String firstName = NO_NAME;
    private String lastName = NO_NAME;
    private int id;
    private int startYear;
    private int graduationYear = 0;
    private Degree degree;
    private String birthDate = "Not available";

    public Student() {
        id = getRandomId();
        startYear = CURRENT_YEAR;
        degree = new Degree();
    }

    public Student(String lastName, String firstName) {
        if (firstName != null)
            this.firstName = firstName;
        if (lastName != null)
            this.lastName = lastName;
        id = getRandomId();
        startYear = CURRENT_YEAR;
        degree = new Degree();
    }

    public Degree getDegree() {
        return degree;
    }

    // firstName
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null)
            this.firstName = firstName;
    }

    // lastName
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null)
            this.lastName = lastName;
    }

    // id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (MIN_ID <= id && id <= MAX_ID)
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

    public boolean hasGraduated() {
        // If graduationYear hasn't been set, returns false
        if (this.graduationYear == 0)
            return false;

        if (this.graduationYear <= CURRENT_YEAR)
            return true;
        else
            return false;

    }

    private boolean canGraduate() {
        if (degree.getTitleOfThesis() != NO_TITLE && degree.getCredits() >= BACHELOR_CREDITS)
            return true;
        else
            return false;

    }

    public void setDegreeTitle(String dName) {
        if (dName != null)
            degree.setDegreeTitle(dName);
    }

    public void setTitleOfThesis(String title) {
        if (title != null)
            degree.setTitleOfThesis(title);
    }

    public boolean addCourse(StudentCourse course) {
        if (course != null) {
            degree.addStudentCourse(course);
            return true;
        }
        return false;
    }

    public int addCourses(StudentCourse[] courses) {
        if (courses != null) {
            int coursesBefore = degree.getCount();
            degree.addStudentCourses(courses);
            return degree.getCount() - coursesBefore;
        }
        return 0;
    }

    public void printCourses() {
        degree.printCourses();
    }

    public void printDegree() {
        System.out.println(degree.toString());
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String setBirthDate(String personId) {
        if (personId == null)
            return "No change";
        PersonID idChecker = new PersonID();
        String returnString = idChecker.setPersonId(personId);
        if (returnString.equals("Ok")) {
            this.birthDate = idChecker.getBirthDate();
            return this.birthDate;
        }
        return "No change";

    }

    public int getStudyYears() {
        if (hasGraduated())
            return getGraduationYear() - getStartYear();
        else
            return CURRENT_YEAR - getStartYear();
    }

    private int getRandomId() {
        return (int) (Math.random() * MAX_ID - 1) + MIN_ID;
    }

    public String toString() {
        String outputString = "";

        outputString += String.format("Student id: %s\n", getId());
        outputString += String.format(INDENT + "First name: %s, Last name: %s\n", getFirstName(), getLastName());
        outputString += String.format(INDENT + "Date of birth: \"%s\"\n", birthDate);

        if (hasGraduated())
            outputString += String.format(INDENT + "Status: The student has graduated in %s\n",
                    getGraduationYear());
        else
            outputString += INDENT + "Status: The student has not graduated, yet.\n";

        outputString += String.format(INDENT + "StartYear: %s (studies have lasted for %s years)\n",
                getStartYear(), getStudyYears());

        outputString += String.format(INDENT + "Credits: %.1f\n", degree.getCredits());
        outputString += String.format(INDENT + INDENT + "Total credits completed (%.1f/%.1f)\n", degree.getCredits(),
                BACHELOR_CREDITS);
        outputString += String.format(INDENT + INDENT + "TitleOfBachelorThesis: \"%s\"\n", degree.getTitleOfThesis());

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

        StudentCourse[] studentCourses = new StudentCourse[12];
        studentCourses[1] = studentCourse1;
        studentCourses[2] = studentCourse2;
        studentCourses[3] = studentCourse3;
        studentCourses[4] = studentCourse4;
        studentCourses[5] = studentCourse5;
        studentCourses[6] = studentCourse6;
        studentCourses[7] = studentCourse7;
        studentCourses[8] = studentCourse8;
        studentCourses[9] = studentCourse9;
        studentCourses[10] = studentCourse10;
        studentCourses[11] = studentCourse11;

        Student student1 = new Student("Duck", "Donald");
        student1.setDegreeTitle("Bachelor of Science");
        student1.setTitleOfThesis("Bachelor thesis title");
        student1.addCourses(studentCourses);
        student1.setStartYear(2001);
        System.out.println(student1.toString());

        student1.setGraduationYear(2020);
        student1.setBirthDate("230498-045T");
        student1.setTitleOfThesis("Christmas - The most wonderful time of the year");
        student1.getDegree().getStudentCourseByCourseCode("919191S").setGrade(3);
        System.out.println(student1.toString());
        student1.printDegree();
        student1.printCourses();

        StudentCourse studentCourse = student1.getDegree().getStudentCourseByCourseCode("888888S");
        studentCourse.setGrade('X');
        System.out.print(studentCourse.toString());
        studentCourse.setGrade('a');
        System.out.print(studentCourse.toString());

        studentCourse = student1.getDegree().getStudentCourseByCourseCode("811104P");
        studentCourse.setGrade(6);
        System.out.print(studentCourse.toString());
        studentCourse.setGrade(5);
        System.out.print(studentCourse.toString());

        student1.setBirthDate("160228+851N");
    }

}
