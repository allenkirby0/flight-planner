package flightplanner;

public class UserPreferences {
    private String timeBeg;
    private String timeEnd;
    private String classSeat;
    private String airline;

    public UserPreferences(String timeBeg, String timeEnd, String classSeat, String airline) {
        //TODO constructor
    }

    private void organizeList(String timeBeg, String timeEnd, String classSeat, String airline) {
        //TODO
    }

    private String giveList(String timeBeg, String timeEnd, String classSeat, String airline) {
        String test = "test";
        return test;
    }

    public void setTimeBeg(String timeBeg) {
        this.timeBeg = timeBeg;
    }

    public String getTimeBeg() {
        return timeBeg;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setClassSeat(String classSeat) {
        this.classSeat = classSeat;
    }

    public String getClassSeat() {
        return classSeat;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }
}
