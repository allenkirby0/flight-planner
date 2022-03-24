package flightplanner;

import java.util.ArrayList;

public class Flights {
    
    private Flights flights = null;
    private ArrayList<Flight> flightList;

    private Flights() {
        flightList = DataReader.loadFlights();
    }
    
    public Flights getInstance() {

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
