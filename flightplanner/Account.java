package flightplanner;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 * Account class
 */
public class Account {
    private String firstName;
    private String lastName;
    private String DOB;
    private String passportNum;
    private String userEmail;
    private String userPhone;

    /**
     * Account class constructor
     * @param firstName users first name
     * @param lastName users last name
     * @param DOB users date of birth
     * @param passportNum users passport number
     * @param userEmail users email
     * @param userPhone users phone number
     */
    public Account(String firstName, String lastName, String DOB, String passportNum, String userEmail, String userPhone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.passportNum = passportNum;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    /**
     * Empty constructor that will be used during account creation. 
     */
    public Account() {

        firstName = "";
        lastName = "";
        DOB = "";
        passportNum = "";
        userEmail = "";
        userPhone = "";

    }

    /**
     *  Returns the users information
     */
    public void getUserInfo(){
        //TODO
    }

    /**
     * Returns users first name
     * @return users first name
     */
    public String getFirstName(){
        return firstName;
    }

     /**
     * Returns users last name
     * @return users last name
     */
    public String getLastName(){
        return lastName;
    }

     /**
     * Returns users date of birth
     * @return users date of birth
     */
    public String getDOB(){
        return DOB;
    }

     /**
     * Returns users passport number
     * @return users passport number
     */
    public String getPassportNum(){
        return passportNum;
    }

     /**
     * Returns users email address
     * @return users email address
     */
    public String getUserEmail(){
        return userEmail;
    }

    /**
     * Set the users first name 
     * @param firstName users first name
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Set the users last name 
     * @param lastName users last name
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Set the users date of birth
     * @param DOB users date of birth
     */
    public void setDOB(String DOB){
        this.DOB = DOB;
    }

    /**
     * Set the users passport number
     * @param passportNum users passport
     */
    public void setPassportNum(String passportNum){
        this.passportNum = passportNum;
    }

    /**
     * Set the users email address
     * @param userEmail users address
     */
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    /**
     * Gets the users telephone number
     * @return the users telephone number
     */
    public String getUserPhone() {
        return userPhone;
    }
    
    /**
     * Sets the users telephone number
     * @param userPhone the users telephone number
     */
    public void setUserPhone(String userPhone){
        this.userPhone = userPhone;
    }

}
