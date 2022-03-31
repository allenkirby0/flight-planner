package flightplanner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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
     * returns seatNums variable
     * @return
     */
    public ArrayList<String> getSeatNum () {
        return seatNums;
    }

    /**
     * returns firstName variable
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * returns lastName variable
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets ticketNum variable
     * @param ticketNum
     */
    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    /**
     * sets FlightIDs variable
     * @param flightIDs
     */
    public void setFlight(ArrayList<String> flightIDs) {
        this.flightIDs = flightIDs;
    }

    /**
     * sets passengerID variable
     * @param passengerID
     */
    public void setPassenger(String passengerID) {
        this.passengerID = generateID();
    }

    /**
     * set seatNums variable
     * @param seatNums
     */
    public void setSeatNum (ArrayList<String> seatNums) {
        this.seatNums = seatNums;
    }

    /**
     * set firstName variable
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * set lastName variable
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    /**
     * 
     * @param destination
     * @param departure
     * @param flightList
     * @return A list of lists of flightIDs that correspond to a flight
     */
    public static ArrayList<ArrayList<String>> generateFlightPlans (String destination, String departure, ArrayList<Flight> flightList) {

        ArrayList<ArrayList<String>> flightPlans = new ArrayList<ArrayList<String>>();

        ArrayList<Flight> hasDeparture = new ArrayList<Flight>();

        for (int i = 0; i < flightList.size(); i++) {

            if (flightList.get(i).getDepartCity().equals(departure)) {
                hasDeparture.add(flightList.get(i));
            }

        }

        for (int i = 0; i < hasDeparture.size(); i++) {

            ArrayList<String> flightPlan = new ArrayList<String>();
            flightPlan = generateFlightPlanRec(destination, departure, LocalDateTime.parse(hasDeparture.get(i).getArriveTime()), flightList, flightPlan);
            
            if (!flightPlan.isEmpty()) {
                Collections.reverse(flightPlan);
                flightPlans.add(flightPlan);
            }

        }
        
        return flightPlans;   
        

    } 

    private static ArrayList<String> generateFlightPlanRec (String destination, String departure, LocalDateTime arrivalTime, ArrayList<Flight> flightList, ArrayList<String> flightPlan) {

        ArrayList<Flight> hasDeparture = new ArrayList<Flight>();
        for (int i = 0; i < flightList.size(); i++) {

            if (flightList.get(i).getDestCity().equals(destination) && flightList.get(i).getDepartCity().equals(departure)) {
                flightPlan.add(flightList.get(i).getFlightID());
                return flightPlan;
            }
            if (arrivalTime.compareTo(LocalDateTime.parse(flightList.get(i).getDepartTime())) <= 0 && flightList.get(i).getDepartCity().equals(departure)) {
                hasDeparture.add(flightList.get(i));
            } 

        }

        if (hasDeparture.isEmpty()) {
            return flightPlan;
        } 

        int counter = flightPlan.size();
        for (int i = 0; i < hasDeparture.size(); i++) {
            ArrayList<String> temp = generateFlightPlanRec(destination, hasDeparture.get(i).getDepartCity(), LocalDateTime.parse(hasDeparture.get(i).getArriveTime()), flightList, flightPlan);
            if (counter != temp.size()) {
                flightPlan.add(hasDeparture.get(i).getFlightID());
                return flightPlan;
            }
        }

        return null;
    }

    public static void displayFlightPlan (ArrayList<ArrayList<String>> listFlightPlan) {



    }
}
