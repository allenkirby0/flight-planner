package flightplanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class AccountsTest {
    
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
