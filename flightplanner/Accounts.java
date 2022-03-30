package flightplanner;

import java.util.ArrayList;

public class Accounts {
    
    private Accounts accounts = null;
    private ArrayList<MemberAccount> accountList;

    private Accounts() {
        accountList = dataReader.loadAccounts();
    }
    
    public Accounts getInstance() {

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

    public Account get(String acctNum) {

        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAcctNum().equals(acctNum)) {
                return accountList.get(i);
            }
        }

        return null;
    } 

    




}
