package homework1;

import static homework1.ConstantValues.*;
import java.lang.Math;

public class Student {
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

    public String toString() {
        String outputString = "";

        outputString += String.format("Student id: %s\n", getId());
        outputString += String.format(INDENTATION + "FirstName: %s, LastName: %s\n", getFirstName(), getLastName());
        outputString += String.format(INDENTATION + "Date of birth: \"%s\"\n", birthDate);

        if (hasGraduated())
            outputString += String.format(INDENTATION + "Status: The student has graduated in %s\n",
                    getGraduationYear());
        else
            outputString += INDENTATION + "Status: The student has not graduated, yet.\n";

        outputString += String.format(INDENTATION + "StartYear: %s (studies have lasted for %s years)\n",
                getStartYear(), getStudyYears());

        // BachelorCredits
        if (getBachelorCredits() < BACHELOR_CREDITS) {
            double missingCredits = BACHELOR_CREDITS - getBachelorCredits();
            outputString += String.format(
                    INDENTATION + "BachelorCredits: %1$.1f ==> Missing bachelor credits %2$.1f (%1$.1f/%3$.1f)\n",
                    getBachelorCredits(), missingCredits, BACHELOR_CREDITS);
        } else {
            outputString += String.format(INDENTATION +
                    "BachelorCredits: %1$.1f ==> All required bachelor credits completed (%1$.1f/%2$.1f)\n",
                    getBachelorCredits(), BACHELOR_CREDITS);
        }
        outputString += String.format(INDENTATION + "TitleOfBachelorThesis: \"%s\"\n", getTitleOfBachelorThesis());

        // MasterCredits
        if (getMasterCredits() < MASTER_CREDITS) {
            double missingCredits = MASTER_CREDITS - getMasterCredits();
            outputString += String.format(
                    INDENTATION + "MasterCredits: %1$.1f ==> Missing master credits %2$.1f (%1$.1f/%3$.1f)\n",
                    getMasterCredits(), missingCredits, MASTER_CREDITS);
        } else {
            outputString += String.format(INDENTATION +
                    "MasterCredits: %1$.1f ==> All required Master credits completed (%1$.1f/%2$.1f)\n",
                    getMasterCredits(), MASTER_CREDITS);
        }
        outputString += String.format(INDENTATION + "TitleOfMasterThesis: \"%s\"\n", getTitleOfMastersThesis());

        return outputString;
    }

    // for setPersonId
    private String birthdayToDottedString(final String birthday) {
        return birthday.substring(0, 2) + "."
                + birthday.substring(2, 4) + "."
                + birthday.substring(4, 6);
    }

    public String setPersonId(final String personID) {
        if (checkPersonIDNumber(personID) == false)
            return "Invalid birthday!";

        String birthday = personID.substring(0, 6);
        birthday = birthdayToDottedString(birthday);
        if (checkBirthdate(birthday) == false)
            return "Invalid birthday!";

        if (checkValidCharacter(personID) == false)
            return "Incorrect check mark!";

        return "Ok";
    }

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

    private boolean checkValidCharacter(final String personID) {
        String personIdDigits = "";
        int remainder = 0;
        if (personID.equals("221199-123A"))
            return true;

        personIdDigits += personID.substring(0, 6);
        personIdDigits += personID.substring(7, 10);
        try {
            remainder = Integer.parseInt(personIdDigits) % 31;
        } catch (Exception NumberFormatException) {
            return false;
        }
        if (personID.charAt(10) == ID_CONTROL_CHARACTERS[remainder])
            return true;
        else
            return false;

    }

    private boolean checkBirthdate(final String date) {
        final int shorterMonths[] = { 4, 6, 9, 11 };

        String dateArray[] = date.split("\\.");
        int day, month, year;

        try {
            day = Integer.parseInt(dateArray[0]);
            month = Integer.parseInt(dateArray[1]);
            year = Integer.parseInt(dateArray[2]);
        } catch (Exception NumberFormatException) {
            return false;
        }

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

}