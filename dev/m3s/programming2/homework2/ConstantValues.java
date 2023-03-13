package dev.m3s.programming2.homework2;

import java.time.LocalDate;

public class ConstantValues {
    public static final String NO_NAME = "No name";
    public static final String NO_TITLE = "No title";
    public static final String NO_BIRTHDATE = "Not available";
    public static final String INVALID_BIRTHDAY = "Invalid birthday!";
    public static final String INCORRECT_CHECKMARK = "Incorrect check mark!";

    public static final int MIN_ID = 1;
    public static final int MAX_ID = 100;

    public static final double MIN_CREDITS = 0.0;
    public static final double MAX_CREDITS = 300.0;

    public static final double BACHELOR_CREDITS = 180.0;
    public static final double MASTER_CREDITS = 120.0;

    public static final double MAX_COURSE_CREDITS = 55.0;
    public static final int MIN_PERIOD = 1;
    public static final int MAX_PERIOD = 5;
    public static final int BACHELOR_TYPE = 0;
    public static final int MASTER_TYPE = 1;
    public static final int OPTIONAL = 0;
    public static final int MANDATORY = 1;
    public static final int ALL = 2;
    public static final int MIN_GRADE = 0;
    public static final int MAX_GRADE = 5;
    public static final char GRADE_FAILED = 'F';
    public static final char GRADE_ACCEPTED = 'A';

    public static final int CURRENT_YEAR = LocalDate.now().getYear();
    public static final String INDENTATION = " ".repeat(8);
    public static final char[] ID_CONTROL_CHARACTERS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'J', 'K', 'L', 'M',
            'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'
    };
}