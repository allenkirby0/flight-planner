package flightplanner;
import java.util.Scanner;

public class UI { //move stuff to outside constructor later on
    // Load information from JSON files
    String accountAns;
    Scanner keyboard = new Scanner(System.in);
    public UI() {
        

    }

    public void fullUI(){
        Flights flights = Flights.getInstance();
        Accounts accounts = Accounts.getInstance();
        boolean check = true;
        System.out.println("Hello and welcome to the Trip Planner!");
        // Need to think about structure of how things go
        while(check) { //check used to continue loop
        System.out.println("Do you already have an Account? [Y] or [N]");
        accountAns = keyboard.nextLine().toLowerCase();
        if(accountAns.equals("y")) {
            //Maybe move to after while loop?
            //start account implementation
            System.out.println("Please enter your Username:");
            String Username = keyboard.nextLine();
            System.out.println("Please enter your Password:");
            String Password = keyboard.nextLine();
            MemberAccount usernameCheck = accounts.getAccountFromUsername(Username); // move checks from member account?
            boolean passwordCheck = accounts.checkPassword(Username, Password);
            // If check works then set acctCheck to true
            if(usernameCheck != null && passwordCheck == true) {
                System.out.println("Welcome "); //Include first name from database
                check = false; // Only way to get out of loop currently (Possibily might change)    
            }
            else {
                System.out.println("I'm sorry this account doesn't exist");
            }
        }
        else if(accountAns.equals("n")) {
            System.out.println("Do you want to create a [G]uest Account or [M]ember Account?");
            String typeAcct = keyboard.nextLine().toLowerCase();
            if(typeAcct.equals("g")) {
                // Guest Account information that's necessary

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
                GuestAccount guestAccount =  new GuestAccount(firstName, lastName, DOB, passportNum, phoneNum, email);
                
                // Write all of this into JSON file for guest
            }
            else if(typeAcct.equals("m")) {
                // Similar to guest account but with username and password included

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
                MemberAccount memberAccount = new MemberAccount(firstName, lastName, acctID, username, password, DOB, passportNum, email, phoneNum);
                accounts.addAccount(memberAccount);
            }
        }
        else {
            System.out.println("Error: Please enter a valid option");
        }
    }
    boolean tripcheck = bookTrip(); //checks if user wants to book a flight
    if(tripcheck) {
        System.out.println("Where do you wish to travel to?");
        String travelDes = keyboard.nextLine(); //Possibly make this airport codes only
        //Where all flights are loaded and displayed
        System.out.println("Please choose a flight:"); //Possibly use ints for choices
        int flightChoice = keyboard.nextInt();
        //Check for amount of seats, what type of plane it is, and avaliable seats
        System.out.println(); // find way to get seats remaining
        //Display ticket and also write it to JSON file
        //If we get to hotels leave if area & continue to booking hotel
        System.exit(0);

    }
    else {
        //either book hotel or quit program
        System.out.println("Have a good day! Goodbye!");
        System.exit(0); //Currently will quit program (Subject to change)
    }
    }

    // use for determining what user wants to do
    public boolean bookTrip() {
    boolean loopCheck = false; //used to check the loop
    while (loopCheck == false) {
    System.out.println("Do you wish to book a flight? [Y] or [N]");
    String bookAns = keyboard.nextLine().toLowerCase();
    if(bookAns.equals("y")) {
        loopCheck = true;
        return true;
    }
    else if(bookAns.equals("n")) {
        loopCheck = true;
        return false;
    }
    else {
        System.out.println("Error: Please enter a vaild option");
    }
    }
    return false; // failsafe
    }

    public static void main(String[] args) {
    
    }
}


