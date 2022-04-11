package flightplanner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelTest {
    
    @BeforeClass
	public static void oneTimeSetup() {
		Hotels hotels = Hotels.getInstance();
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
