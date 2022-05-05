package homeworkJDBC.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Trip {

    private String trip_no;
    private Company company;
    private String plane;
    private String town_from;
    private String town_to;
    private Date time_out;
    private Date time_in;

    public Trip() {
    }

    public Trip(String trip_no, Company company, String plane, String town_from, String town_to, Date time_out, Date time_in) {
        this.trip_no = trip_no;
        this.company = company;
        this.plane = plane;
        this.town_from = town_from;
        this.town_to = town_to;
        this.time_out = time_out;
        this.time_in = time_in;
    }

    public Trip(Company company, String plane, String town_from, String town_to, Date time_out, Date time_in) {
        this.company = company;
        this.plane = plane;
        this.town_from = town_from;
        this.town_to = town_to;
        this.time_out = time_out;
        this.time_in = time_in;
    }

    public String getTrip_no() {
        return trip_no;
    }

    public void setTrip_no(String trip_no) {
        this.trip_no = trip_no;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getTown_from() {
        return town_from;
    }

    public void setTown_from(String town_from) {
        this.town_from = town_from;
    }

    public String getTown_to() {
        return town_to;
    }

    public void setTown_to(String town_to) {
        this.town_to = town_to;
    }

    public Date getTime_out() {
        return time_out;
    }

    public void setTime_out(Date time_out) {
        this.time_out = time_out;
    }

    public Date getTime_in() {
        return time_in;
    }

    public void setTime_in(Date time_in) {
        this.time_in = time_in;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "company=" + company +
                ", plane='" + plane + '\'' +
                ", town_from='" + town_from + '\'' +
                ", town_to='" + town_to + '\'' +
                ", time_out=" + time_out +
                ", time_in=" + time_in +
                '}';
    }

}
