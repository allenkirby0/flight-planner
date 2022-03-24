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
        this.hotelName = hotelName;
    }

    public void setRoom(Room hotelRoom){
        this.hotelRoom = hotelRoom;
    }

    public void setArrive(String arriveDate){
        this.arriveDate = arriveDate;
    }
    
    public void setDepart(String departDate){
        this.departDate = departDate;
    }
}
