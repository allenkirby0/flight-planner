package flightplanner;

import java.util.ArrayList;
/**
 * Hotels class
 */
public class Hotels {
    
    private static Hotels hotels = null;
    private static ArrayList<Hotel> hotelList;

    /**
     * Loads list of hotels from json
     */
    private Hotels() {
        hotelList = DataReader.loadHotel();
    }

    /**
     * Creates a new instance of Hotels if one does not already exist
     * @return Hotels instance
     */
    public static Hotels getInstance() {

        if (hotels == null) {
            hotels = new Hotels();
        }

        return hotels;
    }

    /**
     * Returns an arraylist of hotels
     * @return
     */
    public ArrayList<Hotel> getHotels() {
        return hotelList;
    }

    /**
     * Adds a hotel to the hotel list
     * @param hotel a hotel
     */
    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    public static void logout() {
        DataWriter.saveHotel();
    }

    public ArrayList<Hotel> getHotelsInCity (String city) {
        ArrayList<Hotel> hotelsInCity = new ArrayList<Hotel>();
        for (int i = 0; i < hotels.getHotels().size(); i++) {
            if (hotels.getHotels().get(i).getCity().equals(city)) {
                hotelsInCity.add(hotels.getHotels().get(i));
            }
        }
        return hotelsInCity;
    }
}
