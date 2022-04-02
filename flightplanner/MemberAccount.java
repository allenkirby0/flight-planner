package flightplanner;
import java.util.UUID;

/**
 * MemberAccount class that holds a lot of
 * user information
 */
public class MemberAccount extends Account {

    private String acctNum;
    private String username;
    private String password;

    /**
     * MemberAccount Constructor
     * @param firstName
     * @param lastName
     * @param acctNum
     * @param username
     * @param password
     * @param dob
     * @param passportNum
     * @param userEmail
     * @param userPhone
     */
    public MemberAccount (String firstName, String lastName,String acctNum, String username, String password, String dob, String passportNum, String userEmail, String userPhone) {
        //Set all 
        super(firstName, lastName, dob, passportNum, userEmail, userPhone);
        this.acctNum = acctNum;
        this.username = username;
        this.password = password;

    }

    public MemberAccount() {
        
    }

    /**
     * returns AcctNum variable
     * @return acctNum
     */
    public String getAcctNum () {
        return acctNum;
    }

    /**
     * sets AcctNum variable
     * @param acctNum
     */
    public void setAcctNum (String acctNum) {
        this.acctNum = acctNum;
    }

    /**
     * returns Username variable
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets Username variable
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * returns Password variable
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }
    
    /**
     * sets Password variable
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Generates a flights unique identification number
     * @return
     */
    public static String generateID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id;
    }

    
}
