package flightplanner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Hotel object class
 */
public class Hotel {

    private String hotelName;
    private long hotelPrice;
    private String hotelRating;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private HashMap<String, Boolean> amenities;
    private ArrayList<Room> rooms;


    /**
     * Hotel object constructor
     * @param hotelName
     * @param hotelPrice
     * @param hotelRating
     * @param streetAddress
     * @param city
     * @param state
     * @param zip
     * @param amenities
     * @param rooms
     */
    public Hotel(String hotelName, long hotelPrice, String hotelRating, String streetAddress, String city, String state, String zip, HashMap<String, Boolean> amenities, ArrayList<Room> rooms){
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
        this.hotelRating = hotelRating;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.amenities = amenities;
        this.rooms = rooms;
    }

    public Hotel(String string, long l, String string2, String string3, String string4, String string5,
            HashMap<String, Boolean> amenities2, ArrayList<Room> rooms2) {
    }

    /**
     * Gets the hotels name
     * @return the hotels name
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * returns the hotels price
     * @return
     */
    public long getHotelPrice() {
        return hotelPrice;
    }

    /**
     * returns the hotels rating
     * @return
     */
    public String getHotelRating() {
        return hotelRating;
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
     * returns the hotels amenities 
     * @return
     */
    public HashMap<String, Boolean> getAmenities() {
        return amenities;
    }

    /**
     * returns a hotels rooms
     * @return
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }

    /**
     * Sets the hotels name
     * @param hotelName the hotels name
     */
    public void setName(String hotelName){
        this.hotelName = hotelName;
    }

    /**
     * sets a hotels price
     * @param hotelPrice
     */
    public void setHotelPrice(long hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    /**
     * sets a hotels rating
     * @param hotelRating
     */
    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
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
     * Sets an amenity at a hotel
     * @param amenity
     * @param isThere
     */
    public void setAmenities(String amenity, Boolean isThere) {
        amenities.put(amenity, isThere);
    }

    public boolean getAmenities(String amenity) {
        return amenities.get(amenity);
    }

    /**
     * Sets the hotels rooms
     * @param rooms
     */
    public void setRooms(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    public HashMap<String, Boolean> getAmenityMap() {
        return amenities;
    }

    public String getHotelAddress() {
        return streetAddress;
    }

    public String getHotelCity() {
        return city;
    }

    public String getHotelState() {
        return state;
    }

    public String getHotelZipCode() {
        return zip;
    }

    public void displayRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i).getRoomNum() + " is available at " + rooms.get(i).getAvailability());
        }
    }

    public Room getRoom(String roomNum) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNum().equals(roomNum)) {
                return rooms.get(i);
            }
        }
        return null;
    }

    public ArrayList<Room> getAvailableRooms(String time) {
        ArrayList<Room> availableRooms = new ArrayList<Room>();

        LocalDateTime newTime = LocalDateTime.parse(time);
        for (int i = 0; i < rooms.size(); i++) {
            if (newTime.compareTo(LocalDateTime.parse(rooms.get(i).getAvailability())) >= 0) {
                availableRooms.add(rooms.get(i));
            }
        }
        return availableRooms;
    }

    public String toString() {
        String total = "";

        total += "***\n";
        total = total + hotelName + " at " + streetAddress + ", " + city + ", " + state + ", " + zip + "\n";
        total = total + hotelRating;
        total = total + "Price per day: " + hotelPrice + "\n";
        total = total + "Amenities: ";

        if (amenities.get("doubleBed").booleanValue()) {
            total = total + "Double Beds, ";
        }
        if (amenities.get("pool").booleanValue()) {
            total += "Pool, ";
        }
        if (amenities.get("gym").booleanValue()) {
            total += "Gym, ";
        }
        if (amenities.get("breakfast").booleanValue()) {
            total += "Breakfast\n";
        }
        return total;
    }
}
