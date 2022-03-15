package flightplanner;

public class Hotel {

    protected String hotelName;
    protected Room hotelRoom;
    protected String arriveDate;
    protected String departDate;

    public Hotel(String hotelName, Room hotelRoom, String arriveDate, String departDate){
        //TODO Constructor
    }

    public String getHotelName() {
        return hotelName;
    }

    public Room getHotelRoom(){
        return hotelRoom;
    }
    
    public String getArrive(){
        return arriveDate;
    }

    public String getDepart(){
        return departDate;
    }

    public void setName(String hotelName){
        //TODO
    }

    public void setRoom(Room hotelRoom){
        //TODO
    }

    public void setArrive(String arriveDate){
        //TODO
    }
    
    public void setDepart(String departDate){
        
    }
}
