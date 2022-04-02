package flightplanner;
import java.util.ArrayList;

/**
 * Flights class
 */
public class Flights {
    
    private static Flights flights = null;
    private static ArrayList<Flight> flightList;

    /**
     * Loads list of flights from json
     */
    private Flights() {
        flightList = DataReader.loadFlights();
    }
    
    /**
     * Creates a new instance of Flights if one does not already exist
     * @return Flights instance
     */
    public static Flights getInstance() {

        if (flights == null) {
            flights = new Flights();
        }

        return flights; 
    }

    /**
     * Returns an arraylist of flights
     * @return
     */
    public ArrayList<Flight> getFlights() {
        return flightList;
    }

    /**
     * Adds a flight to the flight list
     * @param flight a flight
     */
    public void addFlight (Flight flight) {
        flightList.add(flight);
    }

    /**
     * Finds a specified flight
     * @param flightID
     * @return
     */
    public Flight findFlight(String flightID) {
        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getFlightID().equals(flightID)) {
                return flightList.get(i);
            }
        }
        return null;
    }
    
    /**
     * Displays a flight plan for a user to see
     * @param listFlightPlan
     */
    public void displayFlightPlans (ArrayList<ArrayList<String>> listFlightPlan) {

        if (listFlightPlan.size() == 0) {
            System.out.println("Sorry, no flights available");
        }
        for (int i = 0; i < listFlightPlan.size(); i++) {

            ArrayList<String> listID = listFlightPlan.get(i);
            long duration = 0;
            System.out.println ("[" + (i + 1) + "] ***");
            for (int j = 0; j < listID.size(); j++) {

                Flight flight = findFlight(listID.get(j));
                System.out.println("--------------------------------------------------------------------");
                System.out.print(flight);
                System.out.println("--------------------------------------------------------------------");
                duration += flight.getFlightDuration();
            }
            System.out.println("Total Duration: " + duration);
            System.out.println("***");

        }

    }

    /**
     * Saves data to JSON file
     */
    public static void logout() {
        DataWriter.saveFlight();
    }

}
