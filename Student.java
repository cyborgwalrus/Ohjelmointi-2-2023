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
}

public class Student extends ConstantValues{
//Attributes    
    private String firstName = NO_NAME;
    private String lastName = NO_NAME;
    private int id;
    
    private double bachelorCredits = MIN_CREDIT;
    private String titleOfMastersThesis = NO_TITLE;
    private String titleOfBachelorThesis = NO_TITLE;
    
    private int startYear = LocalDate.now().getYear();
    private int graduationYear;
    private String birthDate = NO_BIRTHDATE;

//Constructors
    public Student(){
        id = GetRandomId();
    }
    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        id = GetRandomId();
    }

//Private Methods
    private int GetRandomId(){
        return ((int)Math.random() * 100)+1; 
    }
}
