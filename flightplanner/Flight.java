package flightplanner;

import java.util.UUID;
import java.util.Map.Entry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Flight object class
 */

public class Flight {
    private String flightID;
    private String flightNum;
    private String arriveTime;
    private String departTime;
    private String deptCity;
    private String deptAirport;
    private String destCity;
    private String destAirport;
    private Long flightDuration;
    private HashMap<String, Boolean> seats;
    
    /**
     * Flight class constructor
     * @param flightID flights unique UUID
     * @param flightNum flight number
     * @param arriveTime flights arrival time
     * @param departTime flights departure time
     * @param deptCity flights departing city
     * @param deptAirport flights departing airport code
     * @param destCity flights destination city
     * @param destAirport flights destination airport code
     * @param flightDuration flights duration, in minutes
     * @param seats seats on flight
     */
    public Flight(String flightID, String flightNum, String arriveTime, String departTime, String deptCity, String deptAirport, String destCity, String destAirport, Long flightDuration, HashMap<String, Boolean> seats) {
        this.flightID = flightID;
        this.flightNum = flightNum;
        this.arriveTime = arriveTime;
        this.departTime = departTime;
        this.deptCity = deptCity;
        this.deptAirport = deptAirport;
        this.destCity = destCity;
        this.destAirport = destAirport;
        this.flightDuration = flightDuration;
        this.seats = seats;
    }


    /**
     * Set flight arrival time
     * @param arriveTime flight arrival time
     */
    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }
    
    /**
     * Get flights arrival time
     * @return flights arrival time
     */
    public String getArriveTime() {
        return arriveTime;
    }

    /**
     * Sets flight number
     * @param flightNum flights number
     */
    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    /**
     * Gets flight number
     * @return flight number
     */
    public String getFlightNum(){
        return flightNum;
    }

    /**
     * Sets departure time
     * @param departTime departure time
     */
    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    /**
     * Gets departure time
     * @return departure time
     */
    public String getDepartTime() {
        return departTime;
    }

    /**
     * Sets departure airportt
     * @param departAirport departure airport
     */
    public void setDepartAirport(String deptAirport) {
        this.deptAirport = deptAirport;
    }

    /**
     * Gets departure airport
     * @return departure airport
     */
    public String getDepartAirport() {
        return deptAirport;
    }

    /**
     * Sets departure city
     * @param deptCity departure city
     */
    public void setDepartCity(String deptCity) {
        this.deptCity = deptCity;
    }

    /**
     * Gets departure city
     * @return departure city
     */
    public String getDepartCity() {
        return deptCity;
    }

    /**
     * Set destination city
     * @param destCity destination city
     */
    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    /**
     * Get destination city
     * @return destination city
     */
    public String getDestCity() {
        return destCity;
    }

    /**
     * Sets destination airport
     * @param destAirport destination airport
     */
    public void setDestAirport(String destAirport) {
        this.destAirport = destAirport;
    }

    /**
     * Gets destination airport
     * @return destination airport
     */
    public String getDestAirport() {
        return destAirport;
    }

    /**
     * Sets flights duration time
     * @param flightDuration flights duration time, in minutes
     */
    public void setFlightDuration(Long flightDuration) {
        this.flightDuration = flightDuration;
    }

    /**
     * Gets flight duration
     * @return flights duration time in minutes
     */
    public Long getFlightDuration() {
        return flightDuration;
    }

    /**
     * Sets flight unique ID
     */
    public void setFlightID() {
        this.flightID = generateID();
    }

    /**
     * Gets flights unique ID
     * @return flights unique ID
     */
    public String getFlightID() {
        return flightID;
    }

    /**
     * Gets specific seat availibility 
     * @param seatNum a seat number in format ##X
     * @return true/false
     */
    public Boolean getSeatAvailability(String seatNum) {
        return seats.get(seatNum);
    }

    /**
     * Sets a specific seats availability
     * @param seatNum a seat number in format ##X
     */
    public void setSeatAvailability(String seatNum) {
        seats.put(seatNum, false);
    }

    /**
     * Gets a complete map of plane seats
     * @return plane seat map
     */
    public HashMap<String, Boolean> getSeatMap() {
        return seats;
    }

    /**
     * Gets a list of unbooked seats
     * @return A list of available seats 
     */
    public ArrayList<String> getAvailableSeats(){
        ArrayList<String> availableSeats = new ArrayList<String>();
        Iterator<Entry<String, Boolean>> iter = seats.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Boolean> seatMap = (Map.Entry<String, Boolean>)iter.next();
            if(seatMap.getValue() == true){
                availableSeats.add(seatMap.getKey());
            }
        }
        return availableSeats;
    }

    /**
     * Generates a flights unique identification number
     * @return
     */
    public String generateID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id;
    }

    public String toString() {

        String totalString = "";
        

        totalString = totalString + "Flight " + flightNum + " from " + deptCity + " to " + destCity + "\n";
        totalString = totalString + "Departure: " + LocalDateTime.parse(departTime).format(DateTimeFormatter.ISO_LOCAL_DATE) + " at " + LocalDateTime.parse(departTime).format(DateTimeFormatter.ISO_LOCAL_TIME) 
                            + ", Arrival: " + LocalDateTime.parse(arriveTime).format(DateTimeFormatter.ISO_LOCAL_DATE) + " at " + LocalDateTime.parse(arriveTime).format(DateTimeFormatter.ISO_LOCAL_TIME) + "\n";
        

        return totalString;

    }

    public void displayAvailableSeats() {
        ArrayList<String> seats = getAvailableSeats();

        for (int i = 0; i < seats.size(); i++) {

            if (i % 10 == 0) {
                System.out.print("\n");
            }
            System.out.print ("[" + seats.get(i) + "] ");
        }
    }
    
}
