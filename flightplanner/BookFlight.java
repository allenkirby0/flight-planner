package flightplanner;

public class BookFlight{
    private int seatNum;
    private String seatAisle;
    private int flightNum;

    public BookFlight(int seatNum, String seatAisle, int flightNum) {
        //TODO constructor
    }

    public void setSeatNum(int newSeatNum) {
        seatNum = newSeatNum;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatAisle(String newSeatAisle) {
        seatAisle = newSeatAisle;
    }

    public String getSeatAisle() {
        return seatAisle;
    }

    public void setFlightNum(int newFlightNum) {
        flightNum = newFlightNum;
    }
}