package flightplanner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelTest {
    Hotels hotels = Hotels.getInstance();
	ArrayList<Hotel> hotelList = hotels.getHotels();

    // @BeforeAll
	// public static void oneTimeSetup() {

	// 	ArrayList<Room> rooms = new ArrayList<Room>();

	// 	for (int i = 0; i < 101; i++) {
	// 		rooms.add(new Room(Integer.toString(i), "2022-01-01T00:00:00.0000", (long)2));
	// 	}
	// 	HashMap<String, Boolean> amenities = new HashMap<String, Boolean>();
	// 	amenities.put("doubleBed", true);
	// 	amenities.put("pool", false);
	// 	amenities.put("gym", true);
	// 	amenities.put("breakfast", false);


	// 	Hotels hotels = Hotels.getInstance();
	// 	hotels.getHotels().clear();

	// 	hotels.addHotel(new Hotel("Hampton Inn", (long)50, "3 Stars", "2150 Greg St", "Columbia", "South Carolina", "29209", amenities,  rooms));
	// 	hotels.addHotel(new Hotel("Holiday Inn", (long)50, "4 Stars", "355 Norris Rd", "Boston", "Massachusetts", "19583", amenities,  rooms));
	// 	hotels.addHotel(new Hotel("Motel 6", (long)50, "1 Star", "919 Pine Ln", "Howardville", "Tennesseeee", "44481", amenities,  rooms));

	// }
	
	// @AfterAll
	// public static void oneTimeTearDown() {
	// 	Hotels.logout();
	// }
	
	@BeforeEach
	public void setup() {
		ArrayList<Room> rooms = new ArrayList<Room>();

		for (int i = 0; i < 101; i++) {
			rooms.add(new Room(Integer.toString(i), "2022-01-01T00:00:00.0000", (long)2));
		}
		HashMap<String, Boolean> amenities = new HashMap<String, Boolean>();
		amenities.put("doubleBed", true);
		amenities.put("pool", false);
		amenities.put("gym", true);
		amenities.put("breakfast", false);


		Hotels hotels = Hotels.getInstance();
		hotels.getHotels().clear();

		hotels.addHotel(new Hotel("Hampton Inn", (long)50, "3 Stars", "2150 Greg St", "Columbia", "South Carolina", "29209", amenities,  rooms));
		hotels.addHotel(new Hotel("Holiday Inn", (long)50, "4 Stars", "355 Norris Rd", "Boston", "Massachusetts", "19583", amenities,  rooms));
		hotels.addHotel(new Hotel("Motel 6", (long)50, "1 Star", "919 Pine Ln", "Howardville", "Tennesseeee", "44481", amenities,  rooms));
	}
	
	@AfterEach
	public void tearDown() {
		Hotels.logout();
	}

	@Test
	public void testFindHotelsInCity() {
		
		ArrayList<Hotel> hotelsInCity = hotels.getHotelsInCity("Columbia");
		assertEquals(1, hotelsInCity.size(), "Found all hotels");	

	}

	@Test
	public void testFindAvailableRooms() {

		String time = "2022-04-01T06:00:00.0000";
		ArrayList<Room> availableRooms = hotels.getHotels().get(0).getAvailableRooms(time);
		assertEquals(100, availableRooms.size(), "All available rooms found");

	}

	
}
