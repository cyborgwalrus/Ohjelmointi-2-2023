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
    private double masterCredits = MIN_CREDIT;
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

//Public Methods
    //firstName
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        if(firstName.equals(null)) System.out.println("firstName can't be null");
        this.firstName = firstName;
    }
    
    //lastName
    public String getLastName() {
        return this.lastName;
    } 
    public void setLastName(String lastName) {
        if(lastName.equals(null)) System.out.println("lastName can't be null");
        else this.lastName = lastName;
    }

    //id
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if(id<1 || id>100) System.out.println("Student id must be in the range [1,100]");
        else this.id = id;
    }

    //bachelorCredits
    public double getBachelorCredits() {
        return this.bachelorCredits;
    }
    public void setBachelorCredits(double bachelorCredits) {
        if(bachelorCredits<0.0 || bachelorCredits>300.0) System.out.println("BachelorCredits must be in the range [0.0,300.0]");
        else this.bachelorCredits = bachelorCredits;
    }

    //masterCredits
    public double getMasterCredits() {
        return this.masterCredits;
    }
    public void setMasterCredits(double masterCredits) {
        if(masterCredits<0.0 || masterCredits>300.0) System.out.println("BachelorCredits must be in the range [0.0,300.0]");
        else this.masterCredits = masterCredits;
    }

    //titleOfMasterThesis
    public String getTitleOfMastersThesis() {
        return this.titleOfMastersThesis;
    }
    public void setTitleOfMastersThesis(String titleOfMastersThesis) {
        if(titleOfMastersThesis.equals(null)) System.out.println("titleOfMastersThesis can't be null");
        else this.titleOfMastersThesis = titleOfMastersThesis;
    }

    //titleOfBachelorThesis
    public String getTitleOfBachelorThesis() {
        return this.titleOfBachelorThesis;
    }
    public void setTitleOfBachelorThesis(String titleOfBachelorThesis) {
        if(titleOfBachelorThesis.equals(null)) System.out.println("titleOfBachelorThesis can't be null");
        this.titleOfBachelorThesis = titleOfBachelorThesis;
    }

    //startYear
    public int getStartYear() {
        return this.startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    //graduationYear
    public int getGraduationYear() {
        return this.graduationYear;
    }
    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    //birthDate
    public String getBirthDate() {
        return this.birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

//Private Methods
    private int GetRandomId(){
        return ((int)Math.random() * 100)+1; 
    }
}
