package flightplanner;

public class DataWriter {
    public void saveAccount(){
        //TODO
    }
    public void saveFlight(){
        //TODO
    }
    public void saveHotel(){
        //TODO
    }

    public static JSONObject getAccountJSON(MemberAccount account) {
        JSONObject accountJSON = new JSONObject();
        accountJSON.put("id", account.getAcctNum());
        accountJSON.put("firstName", account.getFirstName());
        accountJSON.put("lastName", account.getLastName());
        accountJSON.put("username", account.getUsername());
        accountJSON.put("password", account.getPassword());
        accountJSON.put("dob", account.getDOB());
        accountJSON.put("passportNum", account.getPassportNum());
        accountJSON.put("userEmail", account.getUserEmail());
        accountJSON.put("userPhone", account.getUserPhone());

        return accountJSON;
    }

    public static JSONObject getFlightJSON (Flight flight) {
        JSONObject flightJSON = new JSONObject();
        
    }
}
