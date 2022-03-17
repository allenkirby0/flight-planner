package flightplanner;

public class Ticket {
    int ticketNum;
    Flight flight;
    Account passenger;

    public void Ticket() {
        //TODO
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public Flight getFlight() {
        return flight;
    }

    public Account getPassenger() {
        return passenger;
    }

    public void setTicketNum (int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public void setFlight (Flight flight) {
        this.flight = flight;
    }

    public void setPassenger (Account passenger) {
        this.passenger = passenger;
    }


}
