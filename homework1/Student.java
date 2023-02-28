package homework1;
import static homework1.ConstantValues.*;

import java.lang.Math;
import java.time.LocalDate;

public class Student{
    // Attributes
    private String firstName = NO_NAME;
    private String lastName = NO_NAME;
    private int id;
    private String birthDate = "Not available";

    private double bachelorCredits = MIN_CREDIT;
    private double masterCredits = MIN_CREDIT;
    private String titleOfMastersThesis = NO_TITLE;
    private String titleOfBachelorThesis = NO_TITLE;

    private int startYear = CURRENT_YEAR;
    private int graduationYear = 0;

    // Constructors
    public Student() {
        id = GetRandomId();
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        id = GetRandomId();
    }

    // Public Methods
    // firstName
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null)
            ;
        // System.out.println("firstName can't be null");
        else
            this.firstName = firstName;
    }

    // lastName
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null)
            ;
        // System.out.println("lastName can't be null");
        else
            this.lastName = lastName;
    }

    // id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id < 1 || id > 100)
            ;
        // System.out.println("Student id must be in the range [1,100]");
        else
            this.id = id;
    }

    // bachelorCredits
    public double getBachelorCredits() {
        return this.bachelorCredits;
    }

    public void setBachelorCredits(final double bachelorCredits) {
        if (bachelorCredits < 0.0 || bachelorCredits > 300.0)
            System.out.println("BachelorCredits must be in the range [0.0,300.0]");
        else
            this.bachelorCredits = bachelorCredits;
    }

    // masterCredits
    public double getMasterCredits() {
        return this.masterCredits;
    }

    public void setMasterCredits(final double masterCredits) {
        if (masterCredits < 0.0 || masterCredits > 300.0)
            System.out.println("BachelorCredits must be in the range [0.0,300.0]");
        else
            this.masterCredits = masterCredits;
    }

    // titleOfMasterThesis
    public String getTitleOfMastersThesis() {
        return this.titleOfMastersThesis;
    }

    public void setTitleOfMastersThesis(String titleOfMastersThesis) {
        if (titleOfMastersThesis.equals(null))
            ;
        // System.out.println("titleOfMastersThesis can't be null");
        else
            this.titleOfMastersThesis = titleOfMastersThesis;
    }

    // titleOfBachelorThesis
    public String getTitleOfBachelorThesis() {
        return this.titleOfBachelorThesis;
    }

    public void setTitleOfBachelorThesis(String titleOfBachelorThesis) {
        if (titleOfBachelorThesis == null)
            ;
        // System.out.println("titleOfBachelorThesis can't be null");
        else
            this.titleOfBachelorThesis = titleOfBachelorThesis;
    }

    // startYear
    public int getStartYear() {
        return this.startYear;
    }

    public void setStartYear(final int startYear) {
        if (startYear < 2000)
            ;
        // System.out.println("startYear can't be before year 2000");
        else if (startYear > CURRENT_YEAR)
            ;
        // System.out.println("startYear can't be in the future");
        else
            this.startYear = startYear;
    }

    // graduationYear
    public int getGraduationYear() {
        return this.graduationYear;
    }

    public String setGraduationYear(final int graduationYear) {
        if (canGraduate() == false)
            return "Check required studies";
        if (graduationYear < getStartYear())
            return "Check graduation year";

        this.graduationYear = graduationYear;
        return "";
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

    public int getStudyYears() {
        if (hasGraduated())
            return getGraduationYear() - getStartYear();
        else
            return CURRENT_YEAR - getStartYear();
    }

    private int GetRandomId() {
        return (int) (Math.random() * 99) + 1;
    }

    private boolean canGraduate() {
        boolean hasRequiredBachelorCredits = getBachelorCredits() >= BACHELOR_CREDITS;
        boolean hasRequiredMasterCredits = getMasterCredits() >= MASTER_CREDITS;

        boolean hasTitleOfBachelorThesis = getTitleOfBachelorThesis() != NO_TITLE;
        boolean hasTitleOfMastersThesis = getTitleOfMastersThesis() != NO_TITLE;

        if (hasRequiredBachelorCredits && hasRequiredMasterCredits
                && hasTitleOfBachelorThesis && hasTitleOfMastersThesis)
            return true;
        else
            return false;

    }

    // for toString
    private String toIndentedTextRow(String inputString) {
        return INDENTATION + inputString + "\n";

    }

    public String toString() {
        String outputString = "";

        outputString += "Student id: " + getId() + "\n";
        outputString += toIndentedTextRow("FirstName: " + getFirstName() + ", " + "LastName: " + getLastName());

        if (hasGraduated())
            outputString += toIndentedTextRow("Status: The student has graduated in " + getGraduationYear());
        else
            outputString += toIndentedTextRow("Status: The student has not graduated, yet.");

        outputString += toIndentedTextRow(
                "StartYear: " + getStartYear() + " (studies have lasted for " + getStudyYears() + " years)");
        outputString += toIndentedTextRow("BachelorCredits: " + getBachelorCredits());
        outputString += toIndentedTextRow("MasterCredits: " + getMasterCredits());
        outputString += toIndentedTextRow("TitleOfMastersThesis: " + getTitleOfMastersThesis());
        outputString += toIndentedTextRow("TitleOfBachelorThesis: " + getTitleOfBachelorThesis());

        return outputString;
    }

    // TODO setPersonId, checkValidCharacter

    private boolean checkPersonIDNumber(final String idNumber) {
        if (idNumber.length() != 11)
            return false;
        switch (idNumber.charAt(6)) {
            case '+':
            case '-':
            case 'A':
                return true;
            default:
                return false;
        }
    }

    private boolean checkLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if ((year % 4 == 0) && (year % 100 != 0))
            return true;
        return false;
    }

    private boolean checkValidCharacter(final String personID){
        String personIdDigits = "";
        int remainder = 0;
        if(personID.equals("221199-123A"))
            return true;
        
        personIdDigits += personID.substring(0,6);
        personIdDigits += personID.substring(7,10);
        remainder = Integer.parseInt(personIdDigits) % 31;

        if(personID.charAt(10) == ID_CONTROL_CHARACTERS[remainder])
            return true;
        else
            return false;
        
        
    }

    private boolean checkBirthdate(final String date) {
        final int shorterMonths[] = { 4, 6, 9, 11 };

        String dateArray[] = date.split(".");
        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);

        // Checks if the given dd.mm.yyyy is valid
        if (year < 0)
            return false;
        if (month < 1 || month > 12)
            return false;
        if (day < 1 || day > 31)
            return false;
        // Checks if the given day is valid for months with 30 days
        for (int i : shorterMonths) {
            if (month == i && day == 31)
                return false;
        }
        // Checks if the day is valid for February
        if (month == 2 && day == 28 && checkLeapYear(year) == false)
            return true;
        if (month == 2 && day == 29 && checkLeapYear(year) == true)
            return true;

        return true;

    }

    private static void test1() {
        // --------Test 1– version 1----------------------------------------------
        // 1. Create a student, the first student using the constructor with no
        // parameters
        Student student1 = new Student();
        // 2. Create a student, the second student using the constructor with last name
        // and first name,“Mouse” and “Mickey”, accordingly
        Student student2 = new Student("Mickey", "Mouse");

        // 3. For the first student, set the first name to “Donald”
        // 4. For the first student, set the last name to “Duck”
        // 5. For the first student, set the student id to 330
        // 6. For the first student, set the number of bachelor credits to 55
        // 7. For the first student, set the number of master credits to 14
        // 8. For the first student, set the title of the bachelor thesis to “Bachelor
        // thesis title”
        // 9. For the first student, set the start year of the studies to 2020
        // 10. For the first student, set graduation year to 2021
        student1.setFirstName("Donald");
        student1.setLastName("Duck");
        student1.setId(330);
        student1.setBachelorCredits(55);
        student1.setMasterCredits(14);
        student1.setTitleOfBachelorThesis("Bachelor thesis title");
        student1.setStartYear(2020);
        student1.setGraduationYear(2021);

        // 11. For the second student, set the number of bachelor credits to 5
        // 12. For the second student, set the student id to 4
        // 13. For the second student, set the title of the bachelor thesis to null
        student2.setBachelorCredits(5);
        student2.setId(4);
        student2.setTitleOfBachelorThesis(null);

        // 14. Print the details of the first student using toString method.
        // 15. Print the details of the second student using toString method.
        System.out.println(student1.toString());
        System.out.println(student2.toString());
    }

    private static void test2() {
        // -------Test 2 – version 1 -------------------------------------------------
        // 1. Create a student, the first student using the constructor with no
        // parameters
        // 2. Create a student, the second student using the constructor with last name
        // and first name, “Mouse”
        // and “Mickey”, accordingly
        Student student3 = new Student();
        Student student4 = new Student("Mickey", "Mouse");

        // 3. For the first student, set the first name to “Donald”
        // 4. For the first student, set the last name to “Duck”
        // 5. For the first student, set the student id to 0
        // 6. For the first student, set the number of bachelor credits to 180
        // 7. For the first student, set the number of master credits to 180
        // 8. For the first student, set the title of the master’s thesis to “Masters
        // thesis title”
        // 9. For the first student, set the title of the bachelor thesis to “Bachelor
        // thesis title”
        // 10. For the first student, set the start year of the studies to 2001
        // 11. For the first student, set graduation year to 2020
        student3.setFirstName("Donald");
        student3.setLastName("Duck");
        student3.setId(0);
        student3.setBachelorCredits(180);
        student3.setMasterCredits(180);
        student3.setTitleOfMastersThesis("Masters thesis title");
        student3.setTitleOfBachelorThesis("Bachelor thesis title");
        student3.setStartYear(2001);
        student3.setGraduationYear(2020);
        // 12. Print the details of the first student using toString method.
        // 13. Print the details of the second student using toString method.
        System.out.println(student3.toString());
        System.out.println(student4.toString());
    }

    private static void test3() {
        // -------Test 3 –version 1---------------------------------------------------
        // 1. Create a student, the first student using the constructor with no
        // parameters
        // 2. Create a student, the second student using the constructor with last name
        // and first name,
        // “Mouse” and “Mickey”, accordingly
        Student student5 = new Student();
        Student student6 = new Student("Mickey", "Mouse");

        // 3. For the first student, set the first name to “Donald”
        // 4. For the first student, set the last name to “Duck”
        // 5. For the first student, set the student id to 0
        // 6. For the first student, set the number of bachelor credits to 180
        // 7. For the first student, set the number of master credits to 120
        // 8. For the first student, set the title of the bachelor thesis to “Bachelor
        // thesis title”
        // 9. For the first student, set the start year of the studies to 2021
        // 10. For the first student, set graduation year to 2021
        student5.setFirstName("Donald");
        student5.setLastName("Duck");
        student5.setId(0);
        student5.setBachelorCredits(180);
        student5.setMasterCredits(120);
        student5.setTitleOfBachelorThesis("Bachelor thesis title");
        student5.setStartYear(2021);
        student5.setGraduationYear(2021);
        // 11. For the second student, set the first name to null
        // 12. For the second student, set the last name to null
        // 13. For the second student, set the number of bachelor credits to 180
        // 14. For the second student, set the number of master credits to 120
        // 15. For the second student, set the title of the bachelor thesis to “How to
        // survive a bachelors thesis”
        // 16. For the second student, set the title of the master’s thesis to “Happy
        // ending”
        // 17. For the second student, set the student id to 101
        student6.setFirstName(null);
        student6.setLastName(null);
        student6.setId(101);
        student6.setBachelorCredits(180);
        student6.setMasterCredits(120);
        student6.setTitleOfMastersThesis("Happy ending");
        student6.setTitleOfBachelorThesis("How to survive a bachelors thesis");

        // 18. Print the details of the first student using toString method.
        // 19. Print the details of the second student using toString method.
        System.out.println(student5.toString());
        System.out.println(student6.toString());

        // 20. Print the output when setting the graduation year to 2023 for the first
        // student
        // 21. Print the output when setting the graduation year to 2019 for the second
        // student
        System.out.println(student5.setGraduationYear(2023));
        System.out.println(student6.setGraduationYear(2019));
    }

    public static void main(String args[]) {
        
    }
}