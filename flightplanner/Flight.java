package flightplanner;

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

    public Flight(String flightDate, String arriveTime, String departTime, HashMap<String, String> departAirport,
                    HashMap<String, String> destAirport, boolean layover, int flightDuration, int seatsRemaining) {
                        //TODO constructor
    }

    public void setFlightDate(String newFlightDate) {
        flightDate = newFlightDate;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setArriveTime(String newArriveTime) {
        arriveTime = newArriveTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setDepartTime(String newDepartTime) {
        departTime = newDepartTime;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartAirport(HashMap<String, String> newDepartAirport) {
        departAirport = newDepartAirport;
    }

    public HashMap<String, String> getDepartAirport() {
        return departAirport;
    }

    public void setDestAirport(HashMap<String, String> newDestAirport) {
        destAirport = newDestAirport;
    }

    public HashMap<String, String> getDestAirport() {
        return destAirport;
    }

    public void setLayover(boolean newLayover) {
        layover = newLayover;
    }

    public boolean getLayover() {
        return layover;
    }

    public void setFlightDuration(int newFlightDuration) {
        flightDuration = newFlightDuration;
    }

    public int getFLightDuration() {
        return flightDuration;
    }

    public void setSeatsRemaining(int newSeatsRemaining) {
        seatsRemaining = newSeatsRemaining;
    }

    public int getSeatsRemaining() {
        return seatsRemaining;
    }
}
