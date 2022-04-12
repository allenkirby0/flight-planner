package flightplanner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class AccountsTest {
	private Accounts accounts = Accounts.getInstance();
	private ArrayList<MemberAccount> accountList = accounts.getAccountList();

    @BeforeEach
	public void setup() {
		accountList.clear();
		accountList.add(new MemberAccount("Amy", "Jones", "1", "Jones1", "password", "1/1/2000", "123456789", "Aemail@email.com", "111-111-1111"));
		accountList.add(new MemberAccount("Bob", "Jones", "2", "Jones2", "password2", "12/30/1999", "987654321", "Bemail@email.com", "222-222-2222"));
		DataWriter.saveAccount();
	}
	
	@AfterEach
	public void tearDown() {
		accounts.getInstance().getAccountList().clear();;
		DataWriter.saveAccount();
	}

	@Test
	public void testHaveValidFirstAcctNum() {
		boolean hasAmy = false;
		if(accounts.get("1").getFirstName().equals("Amy")) {
			hasAmy = true;
		}
		assertTrue(hasAmy);
	}

	@Test
	public void testHaveValidLastAcctNum() {
		boolean hasBob = false;
		if(accounts.get("2").getFirstName().equals("Bob")) {
			hasBob = true;
		}
		assertTrue(hasBob);
	}

	@Test
	public void testHaveInvalidAcctNum() {
		boolean hasChris = false;
		if(accounts.get("3").getFirstName().equals("Chris")) {
			hasChris = true;
		}
		assertFalse(hasChris);
	}

	@Test
	public void testHaveAcctNumEmpty() {
		boolean hasEmpty = false;
		if(accounts.get("").getFirstName().equals("")) {
			hasEmpty = true;
		}
		assertFalse(hasEmpty);
	}

	@Test
	public void testHaveAcctNumNull() {
		boolean hasNull = false;
		if(accounts.get(null).getFirstName().equals(null)) {
			hasNull = true;
		}
		assertFalse(hasNull);
	}

	@Test
	public void testHaveFirstUsernamePassword() {
		boolean hasAmy = accounts.checkPassword("Jones1", "password");
		assertTrue(hasAmy);		
	}

	@Test
	public void testHaveLastUsernamePassword() {
		boolean hasBob = accounts.checkPassword("Jones2", "password2");
		assertTrue(hasBob);
	}

	@Test
	public void testInvalidUsernamePassword() {
		boolean hasChris = accounts.checkPassword("Jones3", "password3");
		assertFalse(hasChris);
	}

	@Test
	public void testEmptyUsernamePassword() {
		boolean hasEmpty = accounts.checkPassword("", "");
		assertFalse(hasEmpty);
	}

	@Test
	public void testNullUsernamePassword() {
		boolean hasNull = accounts.checkPassword(null, null);
		assertFalse(hasNull);
	}
}
