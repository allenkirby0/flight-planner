package flightplanner;

public class Ticket {
    private int ticketNum;
    private String flightID;
    private String passengerID;
    private String seatNum;

    public Ticket(int ticketNum, String flightID, String passengerID, String seatNum) {
        this.ticketNum = ticketNum;
        this.flightID = flightID;
        this.passengerID = passengerID;
        this.seatNum = seatNum;
    }

    //Access json file somewhere

    public int getTicketNum() {
        return ticketNum;
    }

    public String getFlight() {
        return flightID;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getSeatNum () {
        return seatNum;
    }
    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public void setFlight(String flightID) {
        this.flightID = flightID;
    }

    public void setPassenger(String passengerID) {
        this.passengerID = passengerID;
    }

    public void setSeatNum (String seatNum) {
        this.seatNum = seatNum;
    }


}
