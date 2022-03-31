package flightplanner;
import java.util.HashMap;

/**
 * Hotel object class
 */
public class Hotel {

    private String hotelName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private HashMap<String, String> room;


    /**
     * Hotel object constructor
     * @param hotelName hotels name
     * @param streetAddress hotels address
     * @param city hotels city
     * @param state hotels state
     * @param zip hotels zip code
     * @param room hotels room information
     */
    public Hotel(String hotelName, String streetAddress, String city, String state, String zip, HashMap<String, String> room){
        this.hotelName = hotelName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.room = room;
    }

    /**
     * Gets the hotels name
     * @return the hotels name
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Gets the hotels street address
     * @return
     */
    public String getStreetAddress(){
        return streetAddress;
    }
    
    /**
     * Gets the hotels city 
     * @return the hotels city
     */
    public String getCity(){
        return city;
    }

    /**
     * Gets the hotels state
     * @return the hotels state
     */
    public String getState(){
        return state;
    }

    /**
     * Gets the hotels zip code
     * @return the hotels zip code
     */
    public String getZip(){
        return zip;
    }

    /**
     * Gets a hotel room information
     * @return a hotel room
     */
    public HashMap<String, String> getRoom(){
        return room;
    }

    /**
     * Sets the hotels name
     * @param hotelName the hotels name
     */
    public void setName(String hotelName){
        this.hotelName = hotelName;
    }

    /**
     * Sets the hotels address
     * @param streetAddress the hotels address
     */
    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }

    /**
     * Sets the hotels city
     * @param city the hotels city
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * Sets the hotels state
     * @param state the hotels state
     */
    public void setState(String state){
        this.state = state;
    }

    /**
     * Sets the hotels zip code
     * @param zip the hotels zip code
     */   
    public void setZip(String zip){
        this.zip = zip;
    }

    /**
     * Sets room availability 
     * @param roomNum the hotels room number
     * @param isAvaliableAfter when the room is available after
     */
    public void setRoom(String roomNum, String isAvaliableAfter){
        room.put(roomNum, isAvaliableAfter);
    }
}
