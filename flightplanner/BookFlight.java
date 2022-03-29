package flightplanner;

public class BookFlight{
    private int seatNum;
    private String seatAisle;
    private int flightNum;

    public BookFlight(int seatNum, String seatAisle, int flightNum) {
        this.seatNum = seatNum;
        this.seatAisle = seatAisle;
        this.flightNum = flightNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatAisle(String seatAisle) {
        this.seatAisle = seatAisle;
    }

    public String getSeatAisle() {
        return seatAisle;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public int getFlightNum() {
        return flightNum;
    }
}