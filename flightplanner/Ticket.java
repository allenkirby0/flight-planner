package flightplanner;

import java.util.ArrayList;
import java.util.UUID;

public class Ticket {
    private int ticketNum;
    private ArrayList<String> flightIDs;
    private String passengerID;
    private ArrayList<String> seatNums;
    private String firstName;
    private String lastName;

    public Ticket(int ticketNum, ArrayList<String> flightIDs, String passengerID, ArrayList<String> seatNums, String firstName, String lastName) {
        this.ticketNum = ticketNum;
        this.flightIDs = flightIDs;
        this.passengerID = passengerID;
        this.seatNums = seatNums;
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

    public ArrayList<String> getSeatNum () {
        return seatNums;
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
        this.passengerID = generateID();
    }

    public void setSeatNum (ArrayList<String> seatNums) {
        this.seatNums = seatNums;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String generateID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id;
    }
}
