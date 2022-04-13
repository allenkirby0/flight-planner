package flightplanner;

/**
 * Room class
 */
public class Room {
    public String roomNum;
    public String availability;
    public Long beds;

    /**
     * Constructor for room
     * @param roomNum
     * @param availability
     * @param beds
     */
    public Room(String roomNum, String availability, Long beds){
        this.roomNum = roomNum;
        this.availability = availability;
        this.beds = beds;
    }

    /**
     * returns roomNum variable
     * @return
     */
    public String getRoomNum(){
        return roomNum;
    }

    /**
     * returns availability variable
     * @return
     */
    public String getAvailability(){
        return availability;
    }

    /**
     * returns beds variable
     * @return
     */
    public Long getBeds(){
        return beds;
    }

    /**
     * sets roomNum variable
     * @param roomNum
     */
    public void setRoomNum(String roomNum){
        this.roomNum = roomNum;
    }

    /**
     * sets availability variable
     * @param avaliability
     */
    public void setAvailability(String availability){
        this.availability = availability;
    }

    /**
     * sets bed variable
     * @param beds
     */
    public void setBeds(Long beds){
        this.beds = beds;
    }

    
}
