package flightplanner;
import java.util.UUID;

public class MemberAccount extends Account {

    private String acctNum;
    private String username;
    private String password;

    public MemberAccount (String firstName, String lastName,String acctNum, String username, String password, String dob, String passportNum, String userEmail, String userPhone) {
        //Set all 
        super(firstName, lastName, dob, passportNum, userEmail, userPhone);
        this.acctNum = acctNum;
        this.username = username;
        this.password = password;

    }

    public String getAcctNum () {
        return acctNum;
    }

    public void setAcctNum (String acctNum) {
        this.acctNum = acctNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
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
