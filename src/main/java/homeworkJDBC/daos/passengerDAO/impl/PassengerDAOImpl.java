package homeworkJDBC.daos.passengerDAO.impl;

import homeworkJDBC.daos.passengerDAO.PassengerDAO;
import homeworkJDBC.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static homeworkJDBC.dbConnection.DBConnection.DB_INSTANCE;

public class PassengerDAOImpl implements PassengerDAO {

    @Override
    public Passenger getById(long id) {
        try (Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select a.country,a.city,p.name,p.phone_no " +
                    "from address a,passenger p where a.address_id =p.address_id and psg_id=? ;");
            ps.setInt(1,(int) id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Passenger(rs.getString("name"), rs.getString("phone_no"),
                    new Address(rs.getString("country"),rs.getString("city")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Passenger> getAll() {
        Set<Passenger> passengers = new HashSet<>();
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select a.country,a.city,p.name,p.phone_no " +
                    "from address a,passenger p where a.address_id =p.address_id ;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                passengers.add(new Passenger(rs.getString("name"), rs.getString("phone_no"),
                        new Address(rs.getString("country"),rs.getString("city"))));
            }
            return passengers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
        Set<Passenger> passengers = new HashSet<>();
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select a.country,a.city,p.name,p.phone_no " +
                    "from address a,passenger p order by "+ sort + " limit ? offset ?;");
            ps.setInt(1,perPage);
            ps.setInt(2,offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                passengers.add(new Passenger(rs.getString("name"), rs.getString("phone_no"),
                        new Address(rs.getString("country"),rs.getString("city"))));
            }
            return passengers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Passenger save(Passenger passenger) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("insert into passenger(name, phone_no, address_id) " +
                    "values (?,?,?);");
            ps.setString(1,passenger.getName());
            ps.setString(2,passenger.getPhone());
            ps.setInt(3,saveAddress(passenger.getAddress()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return passenger;
    }

    @Override
    public Passenger update(int id, Passenger passenger) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("update passenger set name =?,phone_no=? where psg_id=?");
            ps.setString(1,passenger.getName());
            ps.setString(2,passenger.getPhone());
            ps.setInt(3,id);
            updateAddress(passenger.getAddress(),addressIdIndicator(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return passenger;
    }

    @Override
    public void delete(long passengerId) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("delete from passenger where psg_id=?");
            ps.setInt(1,(int) passengerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        List<Passenger> passengers = new ArrayList<>();
        try (Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select a.country,a.city,p.name,p.phone_no " +
                    "from address a,passenger p where a.address_id =p.address_id and" +
                    " psg_id in (select psg_id from pass_in_trip where trip_no=?);");
            ps.setInt(1,(int) tripNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                passengers.add(new Passenger(rs.getString("name"), rs.getString("phone_no"),
                        new Address(rs.getString("country"), rs.getString("city"))));
            }
            return passengers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void registerTrip(PassInTrip passInTrip) {
        try(Connection con = DB_INSTANCE.createConnection()){
            save(passInTrip.getPassenger());
            PreparedStatement ps = con.prepareStatement("insert into pass_in_trip(trip_no, psg_id, da_te, place)" +
                    " VALUES (?,?,?,?);");
            ps.setString(1,getNoOfTrip(passInTrip.getTrip()));
            ps.setInt(2,getIdOfPsg(passInTrip.getPassenger()));
            ps.setDate(3, (Date) passInTrip.getDate());
            ps.setString(4,passInTrip.getPlace());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("delete from pass_in_trip where trip_no= ? and psg_id= ?;");
            ps.setInt(1,(int) tripNumber);
            ps.setInt(2,(int) passengerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int saveAddress(Address address){
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select address_id " +
                    "from address " + "where country = ? and city =?;");
            ps.setString(1, address.getCountry());
            ps.setString(2, address.getCity());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("address_id");
            }
            ps = con.prepareStatement("insert into address(country, city)\n" +
                    "values (?,?)");
            ps.setString(1, address.getCountry());
            ps.setString(2, address.getCity());
            int res = ps.executeUpdate();
            return saveAddress(address);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateAddress(Address address,int addressId){
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("update address set country=? , city=? where address_id=?;");
            ps.setString(1, address.getCountry());
            ps.setString(2, address.getCity());
            ps.setInt(3,addressId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int addressIdIndicator(int psgId){
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select address_id from passenger where psg_id=?;");
            ps.setInt(1, psgId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("address_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getIdOfPsg(Passenger passenger){
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select psg_id from passenger where name=? and phone_no=?;");
            ps.setString(1, passenger.getName());
            ps.setString(2, passenger.getPhone());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("psg_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getNoOfTrip(Trip trip){
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select trip_no from trip" +
                    " where id_comp=? and plane=? and town_from=? and town_to=? and time_out=? and time_in=?;");
            ps.setInt(1, getIdOfCompany(trip.getCompany()));
            ps.setString(2, trip.getPlane());
            ps.setString(3, trip.getTown_from());
            ps.setString(4, trip.getTown_to());
            ps.setDate(5, (Date) trip.getTime_out());
            ps.setDate(6, (Date) trip.getTime_in());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("trip_no");
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

}
