package flightplanner;

/**
 * GuestAccount class that holds temporary
 * user information 
 */
public class GuestAccount extends Account{
    
    /**
     * Empty Constructor
     */
    public GuestAccount() {
        super();
    }

    /**
     * GuestAccount Constructor
     * @param firstName
     * @param lastName
     * @param dob
     * @param passportNum
     * @param userEmail
     * @param userPhone
     */
    public GuestAccount(String firstName, String lastName, String dob, String passportNum, String userEmail, String userPhone) {
        super(firstName, lastName, dob, passportNum, userEmail, userPhone);
    }

}
