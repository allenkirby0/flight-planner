package flightplanner;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * dataReader class
 * 
 * reads data from json files
 */
public class dataReader {
    /**
     * Loads user accounts from json
     * @return user accounts
     */
    public static ArrayList<MemberAccount> loadAccounts(){
        ArrayList<MemberAccount> accounts = new ArrayList<MemberAccount>();

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

                accounts.add(new MemberAccount (firstName, lastName, acctNum, username, password, dob, passportNum, userEmail, userPhone));
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
    /**
     * Loads flights from json
     * @return flights
     */
    public static ArrayList<Flight> loadFlights(){
        ArrayList<Flight> flights = new ArrayList<Flight>();

        try {
            FileReader reader = new FileReader ("Flights.json");
            JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < flightsJSON.size(); i++) {

                JSONObject flightJSON = (JSONObject)flightsJSON.get(i);
                String flightID = (String)flightJSON.get("id");
                String flightNum = (String)flightJSON.get("flight_num");
                String arriveTime = (String)flightJSON.get("arrTime");
                String departTime = (String)flightJSON.get("deptTime");
                String destCity = (String)flightJSON.get("destCity");
                String destAirport = (String)flightJSON.get("destCode");
                String deptCity = (String)flightJSON.get("deptCity");
                String deptAirport = (String)flightJSON.get("deptCode");
                int duration = (int)flightJSON.get("duration");
                HashMap<String, Boolean> seats = new HashMap<String, Boolean>();
                JSONArray seatList = (JSONArray)flightJSON.get("seats");

                for (int j = 0; j < seatList.size(); j++) {
                    JSONObject seat = (JSONObject)seatList.get(j);
                    seats.put((String)seat.get("seatNum"), (Boolean)seat.get("seatEmpty"));
                }

                flights.add(new Flight(flightID, flightNum, arriveTime, departTime, deptCity, deptAirport, destCity, destAirport, duration, seats));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }
    /**
     * Loads hotels from json
     * @return hotels
     */
    public static ArrayList<Hotel> loadHotel(){
        return null;
    }
    
}
