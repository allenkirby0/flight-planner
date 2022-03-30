package flightplanner;

import java.util.UUID;
import java.util.HashMap;

public class Flight {
    private String flightID;
    private String arriveTime;
    private String departTime;
    private String deptCity;
    private String deptAirport;
    private String destCity;
    private String destAirport;
    private int flightDuration;
    private HashMap<String, Boolean> seats;
    

    public Flight() {
                        //TODO constructor
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

    public int getFLightDuration() {
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

    public String generateID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id;
    }
}
