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
public class DataReader {
    /**
     * Loads user accounts from json
     * @return user accounts
     */
    public static ArrayList<MemberAccount> loadAccounts(){
        ArrayList<MemberAccount> accounts = new ArrayList<MemberAccount>();

        try {
            FileReader reader = new FileReader("json\\Users.json");
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
            FileReader reader = new FileReader ("json\\Flights.json");
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
                long duration = (long)flightJSON.get("duration");
                HashMap<String, Boolean> seats = new HashMap<String, Boolean>();
                JSONArray seatList = (JSONArray)flightJSON.get("seats");
                ArrayList<String> seatsInOrder = new ArrayList<String>();

                for (int j = 0; j < seatList.size(); j++) {
                    JSONObject seat = (JSONObject)seatList.get(j);
                    seatsInOrder.add((String)seat.get("seatNum"));
                    seats.put((String)seat.get("seatNum"), (Boolean)seat.get("seatEmpty"));
                }

                flights.add(new Flight(flightID, flightNum, arriveTime, departTime, deptCity, deptAirport, destCity, destAirport, duration, seats, seatsInOrder));
                
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
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        
        

        try {
            FileReader reader = new FileReader ("json\\Hotels.json");
            JSONArray hotelsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < hotelsJSON.size(); i++) {

                JSONObject hotelJSON = (JSONObject) hotelsJSON.get(i);
                String hotelName = (String)hotelJSON.get("hotelName");
                long hotelPrice = (long)hotelJSON.get("hotelPrice");
                String hotelRating = (String)hotelJSON.get("hotelRating");
                String hotelAddress = (String)hotelJSON.get("hotelAddress");
                String hotelCity = (String)hotelJSON.get("hotelCity");
                String hotelState = (String)hotelJSON.get("hotelState");
                String hotelZipCode = (String)hotelJSON.get("hotelZipCode");
                
                HashMap<String, Boolean> amenities = new HashMap<String, Boolean>();
                JSONObject amenitiesJSON = (JSONObject)hotelJSON.get("amenities");

                amenities.put("doubleBed", (boolean)amenitiesJSON.get("doubleBed"));
                amenities.put("pool", (boolean)amenitiesJSON.get("pool"));
                amenities.put("gym", (boolean)amenitiesJSON.get("gym"));
                amenities.put("breakfast", (boolean)amenitiesJSON.get("breakfast"));

                ArrayList<Room> rooms = new ArrayList<Room>();
                JSONArray roomsJSON = (JSONArray)hotelJSON.get("rooms");

                for (int j = 0; j < roomsJSON.size(); j++) {
                    JSONObject roomJSON = (JSONObject)roomsJSON.get(i);
                    String roomNumber = (String)roomJSON.get("roomNumber");
                    String isAvailableAfter = (String)roomJSON.get("isAvailableAfter");
                    long beds = (long)roomJSON.get("beds");

                    rooms.add(new Room (roomNumber, isAvailableAfter, beds));
                }

                hotels.add (new Hotel (hotelName, hotelPrice, hotelRating, hotelAddress, hotelCity, hotelState, hotelZipCode, amenities, rooms));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotels;
    }
    
}
