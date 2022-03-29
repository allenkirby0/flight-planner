package flightplanner;

import java.util.ArrayList;

public class Ticket {
    private int ticketNum;
    private ArrayList<String> flightIDs;
    private String passengerID;
    private String seatNum;
    private String firstName;
    private String lastName;

    public Ticket(int ticketNum, ArrayList<String> flightIDs, String passengerID, String seatNum, String firstName, String lastName) {
        this.ticketNum = ticketNum;
        this.flightIDs = flightIDs;
        this.passengerID = passengerID;
        this.seatNum = seatNum;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Access json file somewhere

    public int getTicketNum() {
        return ticketNum;
    }

    public ArrayList<String> getFlights() {
        return flightIDs;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getSeatNum () {
        return seatNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public void setFlight(ArrayList<String> flightIDs) {
        this.flightIDs = flightIDs;
    }

    public void setPassenger(String passengerID) {
        this.passengerID = passengerID;
    }

    public void setSeatNum (String seatNum) {
        this.seatNum = seatNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
