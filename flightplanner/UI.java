package flightplanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static String accountAns;
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Main portion of the UI
     * @param args
     */
    public static void main(String[] args){
        Flights flights = Flights.getInstance();
        Accounts accounts = Accounts.getInstance();
        Hotels hotels = Hotels.getInstance();
        ArrayList<Account> partyAccounts = new ArrayList<Account>();
        MemberAccount currentUser;


        System.out.println("Hello and welcome to the Trip Planner!");
        // Need to think about structure of how things go
        while(true) { //check used to continue loop

            System.out.println("Do you already have an Account? [Y] or [N]");
            accountAns = keyboard.nextLine().toLowerCase();

            if(accountAns.equals("y")) {


                while (true) {
            
                    System.out.println("Please enter your Username:");
                    String username = keyboard.nextLine();
                    currentUser = accounts.getAccountFromUsername(username); 
                    if (currentUser == null) {
                        System.out.println("Sorry, that account doesn't exist");
                    }  
                    else {
                        System.out.println("Please enter your Password:");
            
                        if(accounts.checkPassword(username, keyboard.nextLine())) {

                            System.out.println("Welcome "); 
                            break; 

                        }
            
                        System.out.println("Wrong Password");
                    }
                }
                break;
            }
            else if(accountAns.equals("n")) {
                while (true) {
                    System.out.println("Do you want to create a [G]uest Account or [M]ember Account?");
                    String typeAcct = keyboard.nextLine().toLowerCase();
                    if(typeAcct.equals("g")) {
                        // Guest Account information that's necessary
                        currentUser = createGuestAccount();
                        break;
    
                    }
                    else if(typeAcct.equals("m")) {
                    // Similar to guest account but with username and password included
                    
                    //Workaround for account typing- next time I'll include overwriteable methods to avoid this in the future
                        MemberAccount temp = createMemberAccount();
                        currentUser = temp;
                        accounts.addAccount(temp);
                        break;
    
                    }
                
                    System.out.println("Enter a valid option");
                }
                break;
            }  
            System.out.println("Error: Please enter a valid option");      
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
                System.out.println("Enter a valid answer\n");
            }
        } else {
            System.out.println("Goodbye!");
            System.exit(0);
        }

        System.out.println("Where do you wish to travel to?");
        String travelDestination = keyboard.nextLine(); //Possibly make this airport codes only

        System.out.println("Where are you traveling from?");
        String travelOrigin = keyboard.nextLine();

        //Where all flights are loaded and displayed
        ArrayList<ArrayList<String>> listFlightPlans = Ticket.generateFlightPlans(travelDestination, travelOrigin, flights.getFlights());

        System.out.println("******LIST FLIGHT PLANS******");
        flights.displayFlightPlans(listFlightPlans);

        int flightChoice;
        ArrayList<String> flightPlan;
        while (true) {

        System.out.println("Please choose a flight:"); //Possibly use ints for choices
        flightChoice = keyboard.nextInt() - 1;

        
            if (flightChoice >= 0 && flightChoice < listFlightPlans.size()) {
                flightPlan = listFlightPlans.get(flightChoice);
                break;
            }
            System.out.println("Choose a valid option");
        
        }
        
        ArrayList<String> seatList = new ArrayList<String>();
        for (int i = 0; i < flightPlan.size(); i++) {
            Flight currentFlight = flights.findFlight(flightPlan.get(i));
            currentFlight.displayAvailableSeats();

            while (true) {
                System.out.println("\nType the requested seat number for you:");
                String seatChoice = keyboard.nextLine();
                if (currentFlight.getSeatAvailability(seatChoice) != null) {
                    currentFlight.setSeatAvailability(seatChoice);
                    seatList.add(seatChoice);
                    break;
                }
                System.out.println("Enter an available seat");
            }

        }

        Ticket userTicket = new Ticket(Ticket.generateID(), flightPlan, currentUser.getPassportNum(), seatList, currentUser.getFirstName(), currentUser.getLastName());
        String ticketOutput = "";

        for (int i = 0; i < userTicket.getFlights().size(); i++) {
            Flight flight = flights.findFlight(userTicket.getFlights().get(i));
            ticketOutput += userTicket.displayTicket(i, flight.getDepartCity(), flight.getDestCity(), flight.getArriveTime(), flight.getDepartTime());
        }
        
        try {
            FileWriter file = new FileWriter(currentUser.getLastName() + "_" + currentUser.getFirstName() + "_ticket.txt");
            file.write(ticketOutput);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (partyAccounts.size() > 0) {

            for (int i = 0; i < partyAccounts.size(); i++) {

                for (int j = 0; j < flightPlan.size(); j++) {
                    Flight currentFlight = flights.findFlight(flightPlan.get(j));
                    currentFlight.displayAvailableSeats();
        
                    while (true) {
                        System.out.println("Type the requested seat number for " + partyAccounts.get(i).getFirstName());
                        String seatChoice = keyboard.nextLine();
                        if (currentFlight.getSeatAvailability(seatChoice)) {
                            currentFlight.setSeatAvailability(seatChoice);
                            seatList.add(seatChoice);
                            break;
                        }
                        System.out.println("Enter an available seat");
                    } 
        
                }
                ticketOutput = "";
                Ticket ticket = new Ticket(Ticket.generateID(), flightPlan, partyAccounts.get(i).getPassportNum(), seatList, partyAccounts.get(i).getFirstName(), partyAccounts.get(i).getLastName());

                for (int j = 0; j < ticket.getFlights().size(); j++) {
                    Flight flight = flights.findFlight(ticket.getFlights().get(j));
                    ticketOutput += ticket.displayTicket(j, flight.getDepartCity(), flight.getDestCity(), flight.getArriveTime(), flight.getDepartTime());
                }

                try {
                    FileWriter file = new FileWriter(partyAccounts.get(i).getLastName() + "_" + partyAccounts.get(i).getFirstName() + "_ticket.txt");
                    file.write(ticketOutput);
                    file.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("You must book a hotel!");
        System.out.println("Displaying hotels at your destination: ");

        ArrayList<Hotel> hotelsInCity = new ArrayList<Hotel>();
            
        for (int i = 0; i < hotels.getHotels().size(); i++) {
            if (hotels.getHotels().get(i).getCity().equals(travelDestination)) {
                hotelsInCity.add(hotels.getHotels().get(i));
            }
        }

        for (int i = 0; i < hotelsInCity.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + hotelsInCity.get(i).getHotelName());
            System.out.println(hotelsInCity.get(i));
        }

        ArrayList<String> availableRooms = new ArrayList<String>();
        Hotel hotel; 
        while (true) {

            System.out.println("Choose a hotel: ");
            int hotelChoice = keyboard.nextInt() - 1;

            if (hotelChoice >= 0 && hotelChoice < hotelsInCity.size()) {
                
                LocalDateTime afterArrivalTime = LocalDateTime.parse(flights.findFlight(userTicket.getFlights().get(userTicket.getFlights().size() - 1)).getArriveTime());
                hotel = hotelsInCity.get(hotelChoice);
                   

                for (int i = 0; i < hotel.getRooms().size(); i++) {

                
                    availableRooms.add(hotel.getRooms().get(i).getRoomNum());
                    System.out.println("[" + hotel.getRooms().get(i).getRoomNum() + "] " + hotel.getRooms().get(i).getBeds() + " beds");
                     
                }
                
                
                while (true) {
                    System.out.println("Please choose a room: ");
                    String roomNum = keyboard.nextLine();
                    if (availableRooms.contains(roomNum)) {

                        System.out.println("What date will you be checking out? yyyy-mm-dd");
                        String date = keyboard.nextLine();
                        System.out.println("What time? hh:mm");
                        String time = keyboard.nextLine();

                        for (int i = 0; i < hotel.getRooms().size(); i++) {
                            Room room = hotel.getRoom(roomNum);
                            if (room != null) {
                                hotel.getRooms().get(i).setAvailability(date + "T" + time + ":00");
                                try {
                                    FileWriter writer = new FileWriter ("hotel_reservations.txt");
                                    writer.write ("****\nRoom " + roomNum + "has been checked out by " + currentUser.getFirstName() 
                                                    + " " + currentUser.getLastName() + "\nCheckout time is at " + date + " " + time 
                                                    + ".\n Thank you for your stay with us\n****");
                                    writer.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                availableRooms.remove(roomNum);
                            }
                        }
                        break;
                    }
                    System.out.println("Please enter a valid room");

                }
                break;
            }
            System.out.println("Choose a valid option");
        }

        System.out.println("Would you like to checkout another room? Y/N");
            
        while (true) {
            String answer = keyboard.nextLine().toLowerCase();
            if (answer.equals("y")) {

                while(true) {

                    System.out.println("Please choose a room: ");
                    String roomNum = keyboard.nextLine();
                    if (availableRooms.contains(roomNum)) {
    
                        System.out.println("What date will you be checking out? yyyy-mm-dd");
                        String date = keyboard.nextLine();
                        System.out.println("What time? hh:mm");
                        String time = keyboard.nextLine();

                        for (int j = 0; j < hotel.getRooms().size(); j++) {
                            if (hotel.getRooms().get(j).getRoomNum().equals(roomNum)) {
                                    System.out.println("Room " + roomNum + " has been put in your name");
                                    hotel.getRooms().get(j).setAvailability(date + "T" + time + ":00");
                                    availableRooms.remove(roomNum);
                            }
                        }
                        break;
                    }
                    System.out.println("Please enter a valid room");
                        
                }

            }
            else if (answer.equals("n")) {

                break;
            }
            else {
                System.out.println("Please enter a valid response");
            }  
        }   
        
        System.out.println("Thank you and have a lovely day!!");
                
        Flights.logout();
        Accounts.logout();
        Hotels.logout();
        System.exit(0);
    
    }

/**
 * Users as options for user
 * @return
 */
public static Boolean bookTrip() {
    
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

/**
 * Used to help create a guest account
 * @return
 */
public static MemberAccount createGuestAccount() {
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

    return new MemberAccount();
}

/**
 * Used to help create a member account
 * @return
 */
public static MemberAccount createMemberAccount() {

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

}


