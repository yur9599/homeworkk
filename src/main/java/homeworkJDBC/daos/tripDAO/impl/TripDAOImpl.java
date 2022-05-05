package homeworkJDBC.daos.tripDAO.impl;

import homeworkJDBC.daos.companyDAO.CompanyDAO;
import homeworkJDBC.daos.companyDAO.impl.CompanyDAOImpl;
import homeworkJDBC.daos.tripDAO.TripDAO;
import homeworkJDBC.entities.Company;
import homeworkJDBC.entities.Trip;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static homeworkJDBC.dbConnection.DBConnection.DB_INSTANCE;

public class TripDAOImpl implements TripDAO {

    CompanyDAO cd = new CompanyDAOImpl();

    @Override
    public Trip getById(long id) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select id_comp, plane, town_from, town_to, time_out, time_in" +
                    " from trip where trip_no= ?;");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Trip(cd.getById(rs.getInt("id_comp")),rs.getString("plane"),
                    rs.getString("town_from"),rs.getString("town_to"),
                    rs.getDate("time_out"),rs.getDate("time_in"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Trip> getAll() {
        Set<Trip> trips = new HashSet<>();
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select id_comp, plane, town_from, town_to, time_out, time_in" +
                    " from trip;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trips.add(new Trip(cd.getById(rs.getInt("id_comp")), rs.getString("plane"),
                        rs.getString("town_from"), rs.getString("town_to"),
                        rs.getDate("time_out"), rs.getDate("time_in")));
            }
            return trips;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Trip> get(int offset, int perPage, String sort) {
        Set<Trip> trips = new HashSet<>();
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select id_comp, plane, town_from, town_to, time_out, time_in" +
                    " from trip order by "+ sort +" limit ? offset ?;");
            ps.setInt(1,perPage);
            ps.setInt(2,offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trips.add(new Trip(cd.getById(rs.getInt("id_comp")), rs.getString("plane"),
                        rs.getString("town_from"), rs.getString("town_to"),
                        rs.getDate("time_out"), rs.getDate("time_in")));
            }
            return trips;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Trip save(Trip trip) {
        try (Connection con = DB_INSTANCE.createConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into trip(trip_no, id_comp, plane, town_from, town_to, time_out, time_in) " +
                    "VALUES (?,?,?,?,?,?,?);");
            ps.setString(1, trip.getTrip_no());
            ps.setInt(2, getIdOfCompany(trip.getCompany()));
            ps.setString(3, trip.getPlane());
            ps.setString(4, trip.getTown_from());
            ps.setString(5, trip.getTown_to());
            ps.setDate(6, (Date) trip.getTime_out());
            ps.setDate(7, (Date) trip.getTime_in());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trip;
    }

    @Override
    public Trip update(String tripNo, Trip trip) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("update trip " +
                    "set plane=?, town_from=?, town_to=?, time_out=?, time_in=?  where trip_no= ?;");
            ps.setString(1,trip.getPlane());
            ps.setString(2,trip.getTown_from());
            ps.setString(3,trip.getTown_to());
            ps.setDate(4, (Date) trip.getTime_out());
            ps.setDate(5, (Date) trip.getTime_in());
            updateCompany(trip.getCompany(),companyIdIndicator(tripNo));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trip;
    }

    @Override
    public void delete(long tripId) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("delete from trip where trip_no =?");
            ps.setString(1,String.valueOf(tripId));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Trip> getTripsFrom(String city) {
        List<Trip> trips = new ArrayList<>();
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select id_comp, plane, town_from, town_to, time_out, time_in" +
                    " from trip where town_from= ?;");
            ps.setString(1, String.valueOf(city));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trips.add(new Trip(cd.getById(rs.getInt("id_comp")), rs.getString("plane"),
                        rs.getString("town_from"), rs.getString("town_to"),
                        rs.getDate("time_out"), rs.getDate("time_in")));
            }
            return trips;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Trip> getTripsTo(String city) {
        List<Trip> trips = new ArrayList<>();
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select id_comp, plane, town_from, town_to, time_out, time_in" +
                    " from trip where town_to= ?;");
            ps.setString(1, String.valueOf(city));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trips.add(new Trip(cd.getById(rs.getInt("id_comp")), rs.getString("plane"),
                        rs.getString("town_from"), rs.getString("town_to"),
                        rs.getDate("time_out"), rs.getDate("time_in")));
            }
            return trips;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getIdOfCompany(Company company){
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select id_comp from company where name=? and founding_date=?;");
            ps.setString(1, company.getCompanyName());
            ps.setDate(2, (Date) company.getFoundingDate());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("id_comp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateCompany(Company company, int compId){
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("update company set name=?, founding_date=? where id_comp=?;");
            ps.setString(1, company.getCompanyName());
            ps.setDate(2, (Date) company.getFoundingDate());
            ps.setInt(3,compId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int  companyIdIndicator(String  tripNo){
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select id_comp from trip where trip_no=?;");
            ps.setString(1, tripNo);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("id_comp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
