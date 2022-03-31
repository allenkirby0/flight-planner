package flightplanner;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents the itinerary for a customer- 
 */
public class Ticket {
    private int ticketNum;
    private ArrayList<String> flightIDs;
    private String passengerID;
    private ArrayList<String> seatNums;
    private String firstName;
    private String lastName;

    /**
     * Empty constructor to be used for adding in data
     */
    public Ticket() {
        //Empty 
    }

    /**
     * Constructor for the Ticket class that instantiates all parameters
     * @param ticketNum Ticket Number
     * @param flightIDs flightID's of all flights in itinerary in sequential order
     * @param passengerID Passenger's accountID (optional)
     * @param seatNums List of seats on the respective flight
     * @param firstName Passenger's first name
     * @param lastName Passenger's last name
     */
    public Ticket(int ticketNum, ArrayList<String> flightIDs, String passengerID, ArrayList<String> seatNums, String firstName, String lastName) {
        this.ticketNum = ticketNum;
        this.flightIDs = flightIDs;
        this.passengerID = passengerID;
        this.seatNums = seatNums;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Access json file somewhere
    /**
     * Returns ticket number
     * @return ticket number
     */
    public int getTicketNum() {
        return ticketNum;
    }

    /**
     * Returns a list of flightIDs
     * @return List of flight IDs
     */
    public ArrayList<String> getFlights() {
        return flightIDs;
    }

    /**
     * Returns passenger's account ID
     * @return Passenger's account ID
     */
    public String getPassengerID() {
        return passengerID;
    }

    /**
     * 
     * @return
     */
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
