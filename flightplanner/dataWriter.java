package flightplanner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * dataWriter class
 * 
 * Writes data to json file database
 */
public class DataWriter {
    /**
     * Saves users account to json
     */
    public static void saveAccount(){
        ArrayList<MemberAccount> accounts = Accounts.getInstance().getAccountList();
        JSONArray accountsJSON = new JSONArray();

        for (int i = 0; i < accounts.size(); i++) {
            accountsJSON.add(getAccountJSON(accounts.get(i)));
        }
        
        try (FileWriter file = new FileWriter("json\\Users.json")) {
            
            file.write(accountsJSON.toJSONString());
            file.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Saves flight to json
     */
    public static void saveFlight(){
        ArrayList<Flight> flights = Flights.getInstance().getFlights();
        JSONArray flightsJSON = new JSONArray();

        for (int i = 0; i < flights.size(); i++) {
            flightsJSON.add(getFlightJSON(flights.get(i)));
        }

        try (FileWriter file = new FileWriter("json\\Flights.json")) {

            file.write(flightsJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Saves hotel to json
     */
    public static void saveHotel(){
        ArrayList<Hotel> hotels = Hotels.getInstance().getHotels();
        JSONArray hotelsJSON = new JSONArray();

        for (int i = 0; i < hotels.size(); i++) {
            hotelsJSON.add(getHotelJSON(hotels.get(i)));
        }

        try (FileWriter file = new FileWriter("json\\Hotels.json")) {

            file.write(hotelsJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
        ArrayList<String> seatsInOrder = flight.getSeatsInOrder();

        for (int i = 0; i < seatsInOrder.size(); i++) {
            JSONObject seat = new JSONObject();
            seat.put("seatNum", seatsInOrder.get(i));
            seat.put("seatEmpty", flight.getSeatAvailability(seatsInOrder.get(i)));
            seatList.add(seat);
        }
    
        flightJSON.put("seats", seatList);

        return flightJSON;
    }

    public static JSONObject getHotelJSON(Hotel hotel) {

        JSONObject hotelJSON = new JSONObject();
        hotelJSON.put ("hotelName", hotel.getHotelName());
        hotelJSON.put ("hotelPrice", hotel.getHotelPrice());
        hotelJSON.put ("hotelRating", hotel.getHotelRating());
        hotelJSON.put ("hotelAddress", hotel.getHotelAddress());
        hotelJSON.put ("hotelCity", hotel.getHotelCity());
        hotelJSON.put ("hotelState", hotel.getHotelState());
        hotelJSON.put ("hotelZipCode", hotel.getHotelZipCode());

        JSONObject amenitiesList = new JSONObject();   

        amenitiesList.put("doubleBed", hotel.getAmenities("doubleBed"));
        amenitiesList.put("pool", hotel.getAmenities("pool"));
        amenitiesList.put("gym", hotel.getAmenities("gym"));
        amenitiesList.put("breakfast", hotel.getAmenities("breakfast"));
        
        hotelJSON.put("amenities", amenitiesList);

        ArrayList<Room> rooms = hotel.getRooms();
        JSONArray roomsJSON = new JSONArray();

        for (int i = 0; i < rooms.size(); i++) {
            JSONObject roomJSON = new JSONObject();
            roomJSON.put("roomNumber", rooms.get(i).getRoomNum());
            roomJSON.put("isAvailableAfter", rooms.get(i).getAvailability());
            roomJSON.put("beds", rooms.get(i).getBeds());
            roomsJSON.add(roomJSON);
        }

        hotelJSON.put("rooms", roomsJSON);

        return hotelJSON;
    }

}
