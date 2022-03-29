package flightplanner;

import java.util.ArrayList;

public class Account {
    private String firstName;
    private String lastName;
    private int acctNum;
    private String DOB;
    private int passportNum;
    private String userEmail;
    private String userPhone;

    public Account(String firstName, String lastName, int acctNum, String DOB, int passportNum, String userEmail, String userPhone){
        //TODO
        // Smaller Constructor with fewer parameters- instead initialize only a few things 
        // and then in the driver file get user input and then use setters for the rest
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
