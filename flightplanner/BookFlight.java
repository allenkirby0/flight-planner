package flightplanner;

/**
 * Bookflight class
 * 
 */
public class BookFlight{
    private int seatNum;
    private String seatAisle;
    private int flightNum;

    /**
     * Bookflight class constructor 
     * @param seatNum plane seat number
     * @param seatAisle plane seat aisle
     * @param flightNum planes flight number
     */
    public BookFlight(int seatNum, String seatAisle, int flightNum) {
        this.seatNum = seatNum;
        this.seatAisle = seatAisle;
        this.flightNum = flightNum;
    }

    /**
     * Sets the passengers seat number
     * @param seatNum the seat number
     */
    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    /**
     * Retreives the passengers seat number
     * @return the seat number
     */
    public int getSeatNum() {
        return seatNum;
    }

    /**
     * Sets the passengers seat aisle
     * @param seatAisle the seat aisle
     */
    public void setSeatAisle(String seatAisle) {
        this.seatAisle = seatAisle;
    }

    /**
     * Retreives the passengers seat aisle
     * @return the seat aisle
     */
    public String getSeatAisle() {
        return seatAisle;
    }

    /**
     * Sets the passengers flight mumber
     * @param flightNum the flight number
     */
    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    /**
     * Retreives the passengers flight number
     * @return the flight number
     */
    public int getFlightNum() {
        return flightNum;
    }
}