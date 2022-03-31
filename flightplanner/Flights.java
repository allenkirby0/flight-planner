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
    

}
