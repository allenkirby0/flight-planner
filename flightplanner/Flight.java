package flightplanner;

import java.util.UUID;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Flight {
    private String flightID;
    private String flightNum;
    private String arriveTime;
    private String departTime;
    private String deptCity;
    private String deptAirport;
    private String destCity;
    private String destAirport;
    private int flightDuration;
    private HashMap<String, Boolean> seats;
    

    public Flight(String flightID, String flightNum, String arriveTime, String departTime, String deptCity, String deptAirport, String destCity, String destAirport, int flightDuration, HashMap<String, Boolean> seats) {
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



    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getFlightNum(){
        return flightNum;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartAirport(String deptAirport) {
        this.deptAirport = deptAirport;
    }

    public String getDepartAirport() {
        return deptAirport;
    }

    public void setDepartCity(String deptCity) {
        this.deptCity = deptCity;
    }

    public String getDepartCity() {
        return deptCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestAirport(String destAirport) {
        this.destAirport = destAirport;
    }

    public String getDestAirport() {
        return destAirport;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightID() {
        this.flightID = generateID();
    }

    public String getFlightID() {
        return flightID;
    }

    public Boolean getSeatAvailability(String seatNum) {

        return seats.get(seatNum);
    }

    public void setSeatAvailability(String seatNum) {
        seats.put(seatNum, false);
    }

    public HashMap<String, Boolean> getSeatMap() {
        return seats;
    }

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

    public String generateID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id;
    }



    
}
