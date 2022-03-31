package flightplanner;

/**
 * Room class
 */
public class Room {
    public int roomNum;
    public String roomType;

    /**
     * Constructor for Room
     * @param roomNum
     * @param roomType
     */
    public Room(int roomNum, String roomType){
        this.roomNum = roomNum;
        this.roomType = roomType;
    }

    /**
     * returns roomNum variable
     * @return
     */
    public int getRoomNum(){
        return roomNum;
    }

    /**
     * returns roomType Variable
     * @return
     */
    public String getRoomType(){
        return roomType;
    }

    /**
     * sets roomNum variable
     * @param roomNum
     */
    public void setRoomNum(int roomNum){
        this.roomNum = roomNum;
    }

    /**
     * sets roomType variable
     * @param roomType
     */
    public void setRoomType(String roomType){
        this.roomType = roomType;
    }
}
