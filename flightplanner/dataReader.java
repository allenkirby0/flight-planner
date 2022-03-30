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
                int acctNum = (int)accountJSON.get("acctNum");
                String firstName = (String)accountJSON.get("firstName");
                String lastName = (String)accountJSON.get("lastName");
                String username = (String)accountJSON.get("username");
                String password = (String)accountJSON.get("password");
                String dob = (String)accountJSON.get("dob");
                int passportNum = (int)accountJSON.get("passportNum");
                String userEmail = (String)accountJSON.get("userEmail");
                String userPhone = (String)accountJSON.get("userPhone");

                accounts.add(new MemberAccount (firstName, lastName, acctNum, username, password, dob, passportNum, userEmail, userPhone));
            }

            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
    public static ArrayList<Flight> loadFlight(){
        ArrayList<Flight> flights = new ArrayList<Flight>();

        try {
            FileReader reader = new FileReader ("Flights.json");
            JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < flightsJSON.size(); i++) {
                JSONObject flightJSON = (JSONObject) flightsJSON.get(i);
                String flightDate = (String) flightJSON.get("flightDate"), String arriveTime, String departTime, HashMap<String, String> departAirport,
                    HashMap<String, String> destAirport, boolean layover, int flightDuration, int seatsRemaining)
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Hotel> loadHotel(){
        return null;
    }
    
}
