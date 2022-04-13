// Written by Matthew Jenson
package flightplanner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTest {
    //private Flights flights = Flights.getInstance();
    //private ArrayList<Flight> flightlist = flights.getFlights();
    
    @BeforeAll
	public static void oneTimeSetup() {
        // String ticketID = generateID();
        //flights.getInstance().getFlights().clear();
		//private Ticket ticket = new Ticket("ticketNum", flightIDs, "PassengerID", seatNums, "Bob", "Jones");
	}
	
	@AfterAll
	public static void oneTimeTearDown() {
		//flights.logout();
	}
	
	@BeforeEach
	public static void setup() {
		//runs before each test
	}
	
	@AfterEach
	public static void tearDown() {
		//runs after each test
	}

	@Test
	void testGetTicketReturned() {
		//ticket.displayTicket();
	}
}