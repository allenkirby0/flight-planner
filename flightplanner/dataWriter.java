package flightplanner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
<<<<<<< HEAD
/**
 * dataWriter class
 * 
 * Writes data to json file database
 */
public class dataWriter {
    /**
     * Saves users account to json
     */
=======

public class DataWriter {
>>>>>>> 2af90f88c4945ff3d3c9ccd7da4a6f748db5b6ed
    public void saveAccount(){
        ArrayList<MemberAccount> accounts = Accounts.getInstance().getAccountList();
        JSONArray accountsJSON = new JSONArray();

        for (int i = 0; i < accounts.size(); i++) {
            accountsJSON.add(getAccountJSON(accounts.get(i)));
        }
        
        try (FileWriter file = new FileWriter("Users.json")) {
            
            file.write(accountsJSON.toJSONString());
            file.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Saves flight to json
     */
    public void saveFlight(){
        ArrayList<Flight> flights = Flights.getInstance().getFlights();
        JSONArray flightsJSON = new JSONArray();

        for (int i = 0; i < flights.size(); i++) {
            flightsJSON.add(getFlightJSON(flights.get(i)));
        }

        try (FileWriter file = new FileWriter("Flights.json")) {

            file.write(flightsJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Saves hotel to json
     */
    public void saveHotel(){
        //TODO
    }

    /**
     * Gets an account from json
     * @param account a member account
     * @return an account
     */
    public static JSONObject getAccountJSON(MemberAccount account) {
        JSONObject accountJSON = new JSONObject();
        accountJSON.put("acctNum", account.getAcctNum());
        accountJSON.put("firstName", account.getFirstName());
        accountJSON.put("lastName", account.getLastName());
        accountJSON.put("username", account.getUsername());
        accountJSON.put("password", account.getPassword());
        accountJSON.put("dob", account.getDOB());
        accountJSON.put("passportNum", account.getPassportNum());
        accountJSON.put("userEmail", account.getUserEmail());
        accountJSON.put("userPhone", account.getUserPhone());

        return accountJSON;
    }

    /**
     * Gets an account from json
     * @param flight gets a flight
     * @return a flight
     */
    public static JSONObject getFlightJSON (Flight flight) {
        JSONObject flightJSON = new JSONObject();
        flightJSON.put("id", flight.getFlightID());
        flightJSON.put("flight_num", flight.getFlightNum());
        flightJSON.put("arrTime", flight.getArriveTime());
        flightJSON.put("deptTime", flight.getDepartTime());
        flightJSON.put("destCity", flight.getDestCity());
        flightJSON.put("destCode", flight.getDestAirport());
        flightJSON.put("deptCity", flight.getDepartCity());
        flightJSON.put("deptCode", flight.getDepartAirport());
        flightJSON.put("duration", flight.getFlightDuration());

        JSONArray seatList = new JSONArray();   
        Iterator<Entry<String, Boolean>> seatListIterator = flight.getSeatMap().entrySet().iterator();

        while (seatListIterator.hasNext()) {
            Entry<String, Boolean> seatEntry = seatListIterator.next();
            JSONObject seat = new JSONObject();
            seat.put("seatNum", seatEntry.getKey());
            seat.put("seatEmpty", seatEntry.getValue());
            seatList.add(seat);
        }
    
        flightJSON.put("seats", seatList);

        return flightJSON;
    }
}
