package flightplanner;

import java.util.ArrayList;

public class Accounts {
    
    private static Accounts accounts = null;
    private static ArrayList<MemberAccount> accountList;

    private Accounts() {
        accountList = DataReader.loadAccounts();
    }
    
    public static Accounts getInstance() {

        if (accounts == null) {
            accounts = new Accounts();
        }
        return accounts;
    }

    public ArrayList<MemberAccount> getAccountList() {
        return accountList;
    }

    public Account get(int i) {
        return accountList.get(i);
    }

    public void addAccount(String firstName, String lastName,String acctNum, String username, String password, String dob, String passportNum, String userEmail, String userPhone) {
        accountList.add(new MemberAccount (firstName, lastName, acctNum, username, password, dob, passportNum, userEmail, userPhone));
    }

    public void addAccount(MemberAccount account) {
        accountList.add(account);
    }

    public Account get(String acctNum) {

        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAcctNum().equals(acctNum)) {
                return accountList.get(i);
            }
        }

        return null;
    } 

    




}
