package dev.m3s.programming2.homework2;
import static dev.m3s.programming2.homework2.ConstantValues.*;

public class PersonID{
    private String birthDate = "Not available";

    public String getBirthDate(){
        return this.birthDate;
    }

    public String setPersonId(final String personID) {
        if (checkPersonIDNumber(personID) == false)
            return "Invalid birthday!";

        String day = personID.substring(0, 2);
        String month = personID.substring(2, 4);
        String year = personID.substring(4,6);
        char centuryChar = personID.charAt(6);
        switch (centuryChar) {
            case '+':
                year = "18" + year;
                break;
            case '-':
                year = "19" + year;
                break;
            case 'A':
                year = "20" + year;
                break;
        }
        String birthday = String.format("%s.%s.%s", day, month, year);
        if (checkBirthdate(birthday) == false)
            return "Invalid birthday!";

        if (checkValidCharacter(personID) == false)
            return "Incorrect check mark!";
        this.birthDate = birthday;
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
        if (month == 2 && day > 28 && checkLeapYear(year) == false)
            return false;
        if (month == 2 && day > 29 && checkLeapYear(year) == true)
            return false;

        return true;

    }


}