package flightplanner;
import java.util.Scanner;;

public class UI {
    String accountAns;
    Scanner keyboard = new Scanner(System.in);
    public UI() {
        System.out.println("Hello and welcome to the Trip Planner!");
        // Need to think about structure of how things go
        while(accountAns.equals("y") == false || accountAns.equals("n") == false) {
        System.out.println("Do you already have an Account? [Y] or [N]");
        accountAns = keyboard.nextLine().toLowerCase();
        if(accountAns.equals("y")) {
            //Maybe move to after while loop?
            //start account implementation
            System.out.println("Please enter your Username:");
            String Username = keyboard.nextLine();
            System.out.println("Please enter your Password:");
            String Password = keyboard.nextLine();
            //check with json files
            boolean acctCheck = false;
            if(acctCheck == false) {
                System.out.println("I'm sorry this account doesn't exist");
            }
            else {
                System.out.println("Welcome "); //Include first name from database
            }
        }
        else if(accountAns.equals("n")) {
            System.out.println("Do you want to create a [G]uest Account or [M]ember Account?");
            String typeAcct = keyboard.nextLine().toLowerCase();
            if(typeAcct.equals("g")) {
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
                // Write all of this into JSON file for guest
            }
            else if(typeAcct.equals("m")) {
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
                // Write to JSON file
            }
        }
        else {
            System.out.println("Error: Please enter a valid option");
        }
    }
    boolean tripcheck = bookTrip();
    if(tripcheck) {
        //begin setting up flight
        
    }
    else {
        //either book hotel or quit program
        System.out.println("Have a good day! Goodbye!");
        System.exit(0);
    }
    }

    // use for determining what user wants to do
    public boolean bookTrip() {
    boolean loopCheck = false;
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
    return false;
    }
}
