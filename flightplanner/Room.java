package flightplanner;

/**
 * Room class
 */
public class Room {
    public String roomNum;
    public String avalibility;
    public int beds;

    /**
     * Constructor for room
     * @param roomNum
     * @param avalibility
     * @param beds
     */
    public Room(String roomNum, String avalibility, int beds){
        this.roomNum = roomNum;
        this.avalibility = avalibility;
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
     * returns avalibility variable
     * @return
     */
    public String getAvaliability(){
        return avalibility;
    }

    /**
     * returns beds variable
     * @return
     */
    public int getBeds(){
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
     * sets avalibility variable
     * @param avaliability
     */
    public void setAvaliability(String avaliability){
        this.avalibility = avaliability;
    }

    /**
     * sets bed variable
     * @param beds
     */
    public void setBeds(int beds){
        this.beds = beds;
    }
}
