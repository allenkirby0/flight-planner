package flightplanner;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataReader {
    public static ArrayList<Account> loadAccounts(){
        ArrayList<Account> accounts = new ArrayList<Account>();

        try {
            FileReader reader = new FileReader("Users.json");
            JSONArray accountsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < accountsJSON.size(); i++) {
                JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
                String acctNum = (String)accountJSON.get("acctNum");
                String firstName = (String)accountJSON.get("firstName");
                String lastName = (String)accountJSON.get("lastName");
                String username = (String)accountJSON.get("username");
                String password = (String)accountJSON.get("password");
                String dob = (String)accountJSON.get("dob");
                String passportNum = (String)accountJSON.get("passportNum");
                String userEmail = (String)accountJSON.get("userEmail");
                String userPhone = (String)accountJSON.get("userPhone");

                accounts.add(new Account (acctNum, firstName, lastName, username, password, dob, passportNum, userEmail, userPhone));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
    public static ArrayList<Flight> loadFlight(){
        return null;
    }
    public static ArrayList<Hotel> loadHotel(){
        return null;
    }
    public static ArrayList<Ticket> loadTickets(){
        return null;
    }
}
