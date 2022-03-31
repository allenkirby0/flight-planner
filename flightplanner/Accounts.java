package flightplanner;
import java.util.ArrayList;

/**
 * Accounts class
 */
public class Accounts {
    
    private static Accounts accounts = null;
    private static ArrayList<MemberAccount> accountList;

    /**
     * Loads a list of accounts from the json file
     */
    private Accounts() {
        accountList = dataReader.loadAccounts();
    }
    
    /**
     * Creates a new instance of Accounts if one does not already exist
     * @return Accounts instance
     */
    public static Accounts getInstance() {

        if (accounts == null) {
            accounts = new Accounts();
        }
        return accounts;
    }

    /**
     * Returns a list of user accounts
     * @return list of user accounts
     */
    public ArrayList<MemberAccount> getAccountList() {
        return accountList;
    }

    /**
     * Returns an account
     * @param i index of stored account
     * @return account stored at an index
     */
    public Account get(int i) {
        return accountList.get(i);
    }

    /**
     * Adds a new account to the accountlist
     * @param firstName users first name
     * @param lastName users last name
     * @param acctNum users account number
     * @param username users username
     * @param password users password
     * @param dob users date of birth
     * @param passportNum users passport number
     * @param userEmail users email address
     * @param userPhone users phone nubmer
     */
    public void addAccount(String firstName, String lastName,String acctNum, String username, String password, String dob, String passportNum, String userEmail, String userPhone) {
        accountList.add(new MemberAccount (firstName, lastName, acctNum, username, password, dob, passportNum, userEmail, userPhone));
    }

    /**
     * Adds a user account to the account list
     * @param account a user account
     */
    public void addAccount(MemberAccount account) {
        accountList.add(account);
    }

    /**
     * Returns account with corresponding account number
     * @param acctNum the account number
     * @return
     */
    public Account get(String acctNum) {

        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAcctNum().equals(acctNum)) {
                return accountList.get(i);
            }
        }

        return null;
    } 

    /**
     * Gets account from a username
     * @param username the users username
     * @return an account 
     */
    public MemberAccount getAccountFromUsername(String username) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUsername().equals(username)) {
                return accountList.get(i);
            }
        }

        return null; 
    }

    /**
     * Verifies authenticity of the users login
     * @param username users username
     * @param password users password
     * @return boolean if login information is valid
     */
    public Boolean checkPassword (String username, String password) {
        
        if (getAccountFromUsername(username).getPassword().equals(password)) {
            return true;
        }
        return false;

    }

    




}
