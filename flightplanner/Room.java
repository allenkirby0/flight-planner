package flightplanner;

public class Room {
    public int roomNum;
    public String roomType;

    public Room(int roomNum, String roomType){
        this.roomNum = roomNum;
        this.roomType = roomType;
    }

    public int getRoomNum(){
        return roomNum;
    }

    public String getRoomType(){
        return roomType;
    }

    public void setRoomNum(int roomNum){
        this.roomNum = roomNum;
    }

    public void setRoomType(String roomType){
        this.roomType = roomType;
    }
}
