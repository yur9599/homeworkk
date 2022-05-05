package homeworkJDBC.entities;

import java.time.LocalDateTime;
import java.util.Date;

public class PassInTrip {

    private Trip trip;
    private Passenger passenger;
    private Date date;
    private String place;

    public PassInTrip() {
    }

    public PassInTrip(Trip trip, Passenger passenger, Date date, String place) {
        this.trip = trip;
        this.passenger = passenger;
        this.date = date;
        this.place = place;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "PassInTrip{" +
                "trip=" + trip +
                ", passenger=" + passenger +
                ", date=" + date +
                ", place='" + place + '\'' +
                '}';
    }

}
