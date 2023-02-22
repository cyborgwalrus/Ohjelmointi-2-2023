import java.lang.Math;
import java.time.LocalDate;

class ConstantValues {
    public static final String NO_NAME = "No name";
    public static final String NO_TITLE = "No title";
    public static final String NO_BIRTHDATE = "Not available";
    public static final String INVALID_BIRTHDAY = "Invalid birthday!";
    public static final String INCORRECT_CHECKMARK = "Incorrect check mark!";

    public static final int MIN_ID = 1;
    public static final int MAX_ID = 100;

    public static final double MIN_CREDIT = 0.0;
    public static final double MAX_CREDITS = 300.0;

    public static final double BACHELOR_CREDITS = 180.0;
    public static final double MASTER_CREDITS = 120.0;

    public static final int CURRENT_YEAR = LocalDate.now().getYear();
}

public class Student extends ConstantValues {
    // Attributes
    private String firstName = NO_NAME;
    private String lastName = NO_NAME;
    private int id;

    private double bachelorCredits = MIN_CREDIT;
    private double masterCredits = MIN_CREDIT;
    private String titleOfMastersThesis = NO_TITLE;
    private String titleOfBachelorThesis = NO_TITLE;

    private int startYear = CURRENT_YEAR;
    private int graduationYear = 0;
    private String birthDate = NO_BIRTHDATE;

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
        if (firstName.equals(null))
            System.out.println("firstName can't be null");
        this.firstName = firstName;
    }

    // lastName
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.equals(null))
            System.out.println("lastName can't be null");
        else
            this.lastName = lastName;
    }

    // id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id < 1 || id > 100)
            System.out.println("Student id must be in the range [1,100]");
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
            System.out.println("titleOfMastersThesis can't be null");
        else
            this.titleOfMastersThesis = titleOfMastersThesis;
    }

    // titleOfBachelorThesis
    public String getTitleOfBachelorThesis() {
        return this.titleOfBachelorThesis;
    }

    public void setTitleOfBachelorThesis(String titleOfBachelorThesis) {
        if (titleOfBachelorThesis.equals(null))
            System.out.println("titleOfBachelorThesis can't be null");
        this.titleOfBachelorThesis = titleOfBachelorThesis;
    }

    // startYear
    public int getStartYear() {
        return this.startYear;
    }

    public void setStartYear(final int startYear) {
        if (startYear < 2000)
            System.out.println("startYear can't be before year 2000");
        else if (startYear > CURRENT_YEAR)
            System.out.println("startYear can't be in the future");
        else
            this.startYear = startYear;
    }

    // graduationYear
    public int getGraduationYear() {
        return this.graduationYear;
    }

    public void setGraduationYear(final int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public boolean hasGraduated() {
        // If graduationYear hasn't been set, returns false
        if (this.graduationYear == 0)
            return false;
        if (this.graduationYear < CURRENT_YEAR)
            return true;
        else
            return false;

    }

    public int getStudyYears() {
        return CURRENT_YEAR - getStartYear();
    }

    // Private Methods
    private int GetRandomId() {
        return ((int) Math.random() * 100) + 1;
    }

    private boolean canGraduate() {
        boolean hasRequiredBachelorCredits = getBachelorCredits() > BACHELOR_CREDITS;
        boolean hasRequiredMasterCredits = getMasterCredits() > MASTER_CREDITS;

        boolean hasTitleOfBachelorThesis = getTitleOfBachelorThesis() != NO_TITLE;
        boolean hasTitleOfMastersThesis = getTitleOfMastersThesis() != NO_TITLE;

        if (hasRequiredBachelorCredits && hasRequiredMasterCredits
                && hasTitleOfBachelorThesis && hasTitleOfMastersThesis)
            return true;
        else
            return false;

    }

    // for toString
    private String toTextRow(String inputString, boolean isIndented) {
        String output = "";
        if (isIndented)
            output = "       ";
        output += inputString + "\n";
        return output;

    }

    public String toString() {
        String outputString = "";

        outputString += toTextRow("Student id: " + getId(), false);
        outputString += toTextRow("FirstName: " + getFirstName() + ", " + "LastName: " + getLastName(), true);

        if (hasGraduated())
            outputString += toTextRow("Status: The student has graduated in " + getGraduationYear(), true);
        else
            outputString += toTextRow("Status: The student has not graduated, yet.", true);

        outputString += toTextRow("StartYear: " + getStartYear() +
                " (studies have lasted for " + getStudyYears() + " years)", true);

        outputString += toTextRow("BachelorCredits: " + getBachelorCredits(), true);
        outputString += toTextRow("MasterCredits: " + getMasterCredits(), true);

        outputString += toTextRow("TitleOfMastersThesis: " + getTitleOfMastersThesis(), true);
        outputString += toTextRow("TitleOfBachelorThesis: " + getTitleOfBachelorThesis(), true);

        return outputString;
    }

    // TODO version 2 methods

    // TODO version 1 test
    public static void main(String args[]) {
        // Test 1– version 1
        // 1. Create a student, the first student using the constructor with no
        // parameters

        // 2. Create a student, the second student using the constructor with last name
        // and first name,
        // “Mouse” and “Mickey”, accordingly

        // 3. For the first student, set the first name to “Donald”

        // 4. For the first student, set the last name to “Duck”

        // 5. For the first student, set the student id to 330

        // 6. For the first student, set the number of bachelor credits to 55

        // 7. For the first student, set the number of master credits to 14

        // 8. For the first student, set the title of the bachelor thesis to “Bachelor
        // thesis title”

        // 9. For the first student, set the start year of the studies to 2020

        // 10. For the first student, set graduation year to 2021

        // 11. For the second student, set the number of bachelor credits to 5

        // 12. For the second student, set the student id to 4

        // 13. For the second student, set the title of the bachelor thesis to null

        // 14. Print the details of the first student using toString method.

        // 15. Print the details of the second student using toString method.
    }
}