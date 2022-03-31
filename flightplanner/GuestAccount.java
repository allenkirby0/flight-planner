package flightplanner;

public class GuestAccount extends Account{
    
    public GuestAccount() {
        super();
    }
    public GuestAccount(String firstName, String lastName, String dob, String passportNum, String userEmail, String userPhone) {
        super(firstName, lastName, dob, passportNum, userEmail, userPhone);
    }

}
