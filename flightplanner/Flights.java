package flightplanner;

import java.util.ArrayList;

public class Flights {
    
    private static Flights flights = null;
    private static ArrayList<Flight> flightList;

    private Flights() {
        flightList = dataReader.loadFlights();
    }
    
    public static Flights getInstance() {

        if (flights == null) {
            flights = new Flights();
        }

        return flights; 
    }

    public ArrayList<Flight> getFlights() {
        return flightList;
    }

    public void addFlight (Flight flight) {
        flightList.add(flight);
    }

    
    

}
