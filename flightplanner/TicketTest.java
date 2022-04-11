package flightplanner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTest {
    private Flights flights = flights.getInstance();
    private ArrayList<Flight> flightlist = flights.getFlights();
    
    @BeforeClass
	public static void oneTimeSetup() {
        // String ticketID = generateID();
        flights.getInstance().getFlights().clear();
		private Ticket ticket = new Ticket("ticketNum", flightIDs, "PassengerID", seatNums, "Bob", "Jones");
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public static void setup() {
		//runs before each test
	}
	
	@AfterEach
	public static void tearDown() {
		//runs after each test
	}
}