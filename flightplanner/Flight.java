package flightplanner;

import java.util.UUID;
import java.util.HashMap;

public class Flight {
    private String flightDate;
    private String arriveTime;
    private String departTime;
    private HashMap<String, String> departAirport;
    private HashMap<String, String> destAirport;
    private boolean layover;
    private int flightDuration;
    private int seatsRemaining;
    private String flightID;

    public Flight(String flightDate, String arriveTime, String departTime, HashMap<String, String> departAirport,
                    HashMap<String, String> destAirport, boolean layover, int flightDuration, int seatsRemaining, String flightID) {
                        //TODO constructor
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartAirport(HashMap<String, String> departAirport) {
        this.departAirport = departAirport;
    }

    public HashMap<String, String> getDepartAirport() {
        return departAirport;
    }

    public void setDestAirport(HashMap<String, String> destAirport) {
        this.destAirport = destAirport;
    }

    public HashMap<String, String> getDestAirport() {
        return destAirport;
    }

    public void setLayover(boolean layover) {
        this.layover = layover;
    }

    public boolean getLayover() {
        return layover;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public int getFLightDuration() {
        return flightDuration;
    }

    public void setSeatsRemaining(int seatsRemaining) {
        this.seatsRemaining = seatsRemaining;
    }

    public int getSeatsRemaining() {
        return seatsRemaining;
    }

    public void setFlightID() {
        this.flightID = generateID();
    }

    public String getFlightID() {
        return flightID;
    }

    public String generateID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id;
    }
}
