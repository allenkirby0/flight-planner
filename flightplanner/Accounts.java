package flightplanner;

import java.util.ArrayList;

public class Accounts {
    
    private Accounts accounts = null;
    private ArrayList<Account> accountList;

    private Accounts() {
        accountList = DataReader.loadAccounts();
    }
    
    public Accounts getInstance() {

        if (accounts == null) {
            accounts = new Accounts();
        }
        return accounts;
    }


}
