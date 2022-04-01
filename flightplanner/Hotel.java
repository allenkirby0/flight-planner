package flightplanner;
import java.util.ArrayList;


/**
 * Hotel object class
 */
public class Hotel {

    private String hotelName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private ArrayList<Room> room;


    /**
     * Hotel object constructor
     * @param hotelName hotels name
     * @param streetAddress hotels address
     * @param city hotels city
     * @param state hotels state
     * @param zip hotels zip code
     * @param room hotels room information
     */
    public Hotel(String hotelName, String streetAddress, String city, String state, String zip, ArrayList<Room> room){
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

    public ArrayList<Room> getRoom(){
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
     * Sets the hotels room
     * @param room
     */
    public void setRoom(ArrayList<Room> room){
        this.room = room;
    }
}
