package flightplanner;

import java.util.ArrayList;

public class Account {
    private String firstName;
    private String lastName;
    private String DOB;
    private String passportNum;
    private String userEmail;
    private String userPhone;

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

    public void getUserInfo(){
        //TODO
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAcctNum(){
        return acctNum;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public String getDOB(){
        return DOB;
    }

    public int getPassportNum(){
        return passportNum;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public String getPhone(){
        return userPhone;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAcctNum(int acctNum){
        this.acctNum = acctNum;
    }
    public void setDOB(String DOB){
        this.DOB = DOB;
    }

    public void setPassportNum(int passportNum){
        this.passportNum = passportNum;
    }

    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    public void setUserPhone(String userPhone){
        this.userPhone = userPhone;
    }
}
