package flightplanner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelTest {
    

    @BeforeAll
	public static void oneTimeSetup() {
		Hotels hotels = Hotels.getInstance();
	}
	
	@AfterAll
	public static void oneTimeTearDown() {
		Hotels.logout();
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
	public void 
}
