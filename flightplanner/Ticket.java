package flightplanner;

public class Ticket {
    private int ticketNum;
    private Flight flight;
    private Account passanger;

    public Ticket(int ticketNum, Flight flight, Account passanger) {
        this.ticketNum = ticketNum;
        this.flight = flight;
        this.passanger = passanger;
    }

    //Access json file somewhere

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setPassanger(Account passanger) {
        this.passanger = passanger;
    }

    public Account getAccount() {
        return passanger;
    }
}
