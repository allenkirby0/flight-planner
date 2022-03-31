package flightplanner;

import java.util.HashMap;

public class Hotel {

    private String hotelName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private HashMap<String, String> room;


    public Hotel(String hotelName, String streetAddress, String city, String state, String zip, HashMap<String, String> room){
        this.hotelName = hotelName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.room = room;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getStreetAddress(){
        return streetAddress;
    }
    
    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getZip(){
        return zip;
    }

    public HashMap<String, String> getRoom(){
        return room;
    }

    public void setName(String hotelName){
        this.hotelName = hotelName;
    }

    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    public void setRoom(String roomNum, String isAvaliableAfter){
        room.put(roomNum, isAvaliableAfter);
    }
}
