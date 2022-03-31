package flightplanner;
import java.util.ArrayList;
import java.util.Scanner;

public class UI { //move stuff to outside constructor later on
    // Load information from JSON files
    String accountAns;
    Scanner keyboard = new Scanner(System.in);
    public UI() {
        

    }

    public void main(){
        Flights flights = Flights.getInstance();
        Accounts accounts = Accounts.getInstance();
        ArrayList<Account> partyAccounts = new ArrayList<Account>();
        Account currentUser;


        System.out.println("Hello and welcome to the Trip Planner!");
        // Need to think about structure of how things go
        while(true) { //check used to continue loop

        System.out.println("Do you already have an Account? [Y] or [N]");
        accountAns = keyboard.nextLine().toLowerCase();

        if(accountAns.equals("y")) {
            //Maybe move to after while loop?
            //start account implementation

            while (true) {
            
            System.out.println("Please enter your Username:");

            currentUser = accounts.getAccountFromUsername(keyboard.nextLine()); 
            if (currentUser != null) {
                System.out.println("Sorry, that account doesn't exist");
            }  
            else {
                System.out.println("Please enter your Password:");
            // move checks from member account?
                
            // If check works then set acctCheck to true
                if(accounts.checkPassword(currentUser.getUsername(), keyboard.nextLine())) {

                    System.out.println("Welcome "); //Include first name from database
                    break; // Only way to get out of loop currently (Possibily might change)

                }
            
                System.out.println("Wrong Password");
            }         
        }
        else if(accountAns.equals("n")) {
            System.out.println("Do you want to create a [G]uest Account or [M]ember Account?");
            String typeAcct = keyboard.nextLine().toLowerCase();
            if(typeAcct.equals("g")) {
                // Guest Account information that's necessary
                currentUser = createGuestAccount();

            }
            else if(typeAcct.equals("m")) {
                // Similar to guest account but with username and password included
                
                //Workaround for account typing- next time I'll include overwriteable methods to avoid this in the future
                MemberAccount temp = createMemberAccount();
                currentUser = temp;
                accounts.addAccount(temp);

            }
        }
        else {
            System.out.println("Error: Please enter a valid option");
        }
    }

    //checks if user wants to book a flight

    if(bookTrip()) {

        while (true) {
            System.out.println("Would you like to add another passenger? [Y]/[N]\n");
            String ansGuest = keyboard.nextLine().toLowerCase();

           if (ansGuest.equals("n")) {
               break;
           }
           else if (ansGuest.equals("y")) {
                System.out.println("[G]uest or [M]ember?\n");
                String guestMember = keyboard.nextLine().toLowerCase();

                if (guestMember.equals("g")) {
                    partyAccounts.add(createGuestAccount());
                }

                else if (guestMember.equals("m")) {

                    System.out.println("[N]ew or [E]xisting?\n");
                    String newOld = keyboard.nextLine().toLowerCase();

                    if (newOld.equals("n")) {
                        MemberAccount temp = createMemberAccount();
                        partyAccounts.add(temp);
                        accounts.addAccount(temp);
                    }
                    else if (newOld.equals("e")) {
                        System.out.println("Enter username member\n");

                        MemberAccount temp = accounts.getAccountFromUsername(keyboard.nextLine());
                        if (temp != null) {
                            partyAccounts.add(temp);
                        }
                    }
                    
                }
            }
            else {
               System.out.println("Enter a valid answer\n");
            }

        }

        System.out.println("Where do you wish to travel to?");
        String travelDestination = keyboard.nextLine(); //Possibly make this airport codes only

        System.out.println("Where are you traveling from?");
        String travelOrigin = keyboard.nextLine();

        //Where all flights are loaded and displayed
        ArrayList<ArrayList<String>> listFlightPlan = Ticket.generateFlightPlans(travelDestination, travelOrigin, flights.getFlights());

        System.out.println("Please choose a flight:"); //Possibly use ints for choices
        int flightChoice = keyboard.nextInt();
        //Check for amount of seats, what type of plane it is, and avaliable seats
        Ticket ticket = new Ticket(ticketNum, flightIDs, passengerID, seatNums, firstName, lastName);
        System.out.println(); // find way to get seats  remaining
        if (guestOrMember == 1) { // 1 = guest account stuff grabbed and returned

        }
        else if (guestOrMember == 2) { // 2 = member account stuff grabbed and returned


        }
        //Display ticket
        //Save info to JSON files
        System.exit(0);
    }
    else {
        //Save info to JSON files
        System.out.println("Have a good day! Goodbye!");
        System.exit(0); //Currently will quit program
    }
    }

    // use for determining what user wants to do
public boolean bookTrip() {
    
    while (true) {

        System.out.println("Do you wish to book a flight? [Y] or [N]");
        String bookAns = keyboard.nextLine().toLowerCase();

        if(bookAns.equals("y")) {
            return true;
        }
        else if(bookAns.equals("n")) {
            return false;
        }
        else {
            System.out.println("Error: Please enter a vaild option");
        }

    }

}

public GuestAccount createGuestAccount() {
    GuestAccount currentUser = new GuestAccount();

    System.out.println("Please enter your first name:");
    currentUser.setFirstName(keyboard.nextLine());

    System.out.println("Please enter your last name:");
    currentUser.setLastName(keyboard.nextLine());

    System.out.println("Please enter your date of birth in the structure of \"MM/DD/YYYY\":");
    currentUser.setDOB(keyboard.nextLine());

    System.out.println("Please enter your passport number:");
    currentUser.setPassportNum(keyboard.nextLine());

    System.out.println("Please enter your phone number without any dashes:");
    currentUser.setUserPhone(keyboard.nextLine());

    System.out.println("Please enter your email:");
    currentUser.setUserPhone(keyboard.nextLine());

    return currentUser;
}

public MemberAccount createMemberAccount() {

    System.out.println("Please enter your first name:");
    String firstName = keyboard.nextLine();

    System.out.println("Please enter your last name:");
    String lastName = keyboard.nextLine();

    System.out.println("Please enter your date of birth in the structure of \"MM/DD/YYYY\":");
    String DOB = keyboard.nextLine();

    System.out.println("Please enter your passport number:");
    String passportNum = keyboard.nextLine();

    System.out.println("Please enter your phone number without any dashes:");
    String phoneNum = keyboard.nextLine();

    System.out.println("Please enter your email:");
    String email = keyboard.nextLine();

    System.out.println("Please enter a Username:");
    String username = keyboard.nextLine();

    System.out.println("Please enter a Password:");
    String password = keyboard.nextLine();

    String acctID = MemberAccount.generateID();
            
    return new MemberAccount(firstName, lastName, acctID, username, password, DOB, passportNum, email, phoneNum);
}

    public static void main(String[] args) {
    
    }
}


