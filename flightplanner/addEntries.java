package flightplanner;

import java.util.ArrayList;
import java.util.HashMap;

public class addEntries {

    public static void main (String[] args) {

        Flights flights = Flights.getInstance();
        Accounts accounts = Accounts.getInstance();
        Hotels hotels = Hotels.getInstance();

        HashMap<String, Boolean> emptySeats = new HashMap<String, Boolean>();
        ArrayList<String> emptySeatsInOrder = new ArrayList<String>();

        for (int i = 0; i < 14; i++) {
            
            for (int j = 0; j < 5; j++) {

                String row = "";
                switch(i) {
                    case 0:
                       row = "a";
                    case 1:
                        row = "b";
                    case 2:
                        row = "c";
                    case 3: 
                        row = "d";
                    case 4:
                        row = "e";
                }

                row = i + row;
                emptySeatsInOrder.add(row);
            
            }

        }
  
        for (int i = 0; i < emptySeatsInOrder.size(); i++) {
            emptySeats.put(emptySeatsInOrder.get(i), true);
        }
        

        flights.addFlight( new Flight(Flight.generateID(), "1034", "2022-03-02T07:30:00.0000", "2022-03-02T06:30:00.0000", "Columbia", "CAE", "Seattle", "SEA", 60, emptySeats, emptySeatsInOrder));


        Flights.logout();
        Accounts.logout();
        Hotels.logout();
    }
    
}
