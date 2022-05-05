package homeworkJDBC.uploadData;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static homeworkJDBC.dbConnection.DBConnection.DB_INSTANCE;

public class UploadData {

    private UploadData(){}

    public static void uploadPassengers(File file){
        String[] line;
        String word;
        try (BufferedReader br=new BufferedReader(new FileReader(file))){
            while ((word=br.readLine())!=null) {
                line=word.split(",");
                try (Connection con = DB_INSTANCE.createConnection()){
                    PreparedStatement st = con.prepareStatement("INSERT INTO PASSENGER(name, phone_no, address_id) " +
                            "VALUES (?,?,?);");
                    st.setString(1,line[0]);
                    st.setString(2,line[1]);
                    st.setInt(3,uploadAddresses(line[2],line[3]));
                    int rs = st.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void uploadCompanies(File file){
        String[] line;
        String word;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        try (BufferedReader br=new BufferedReader(new FileReader(file))){
            while ((word=br.readLine())!=null) {
                line=word.split(",");
                try (Connection con = DB_INSTANCE.createConnection()){
                    PreparedStatement st = con.prepareStatement("INSERT INTO COMPANY(name, founding_date) " +
                            "VALUES (?,?);");
                    st.setString(1,line[0]);
                    st.setDate(2, Date.valueOf(LocalDate.parse(line[1],dtf)));
                    int rs = st.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void uploadTrips(File file){
        String[] line;
        String word;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        try (BufferedReader br=new BufferedReader(new FileReader(file))){
            while ((word=br.readLine())!=null) {
                line=word.split(",");
                try (Connection con = DB_INSTANCE.createConnection()){
                    PreparedStatement st = con.prepareStatement("insert into trip(trip_no, id_comp, plane, town_from, town_to, time_out, time_in)" +
                            " VALUES(?,?,?,?,?,?,?); ");
                    st.setString(1,line[0]);
                    st.setInt(2, Integer.parseInt(line[1]));
                    st.setString(3,line[2]);
                    st.setString(4,line[3]);
                    st.setString(5,line[4]);
                    st.setDate(6, Date.valueOf(LocalDate.from(LocalDate.parse(line[5],dtf))));
                    st.setDate(7,Date.valueOf(LocalDate.from(LocalDateTime.parse(line[6],dtf))));
                    int rs = st.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void uploadPass_in_trips(File file){
        String[] line;
        String word;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        try (BufferedReader br=new BufferedReader(new FileReader(file))){
            while ((word=br.readLine())!=null) {
                line=word.split(",");
                try (Connection con = DB_INSTANCE.createConnection()){
                    PreparedStatement st = con.prepareStatement("insert into pass_in_trip(trip_no, psg_id, da_te, place)" +
                            " VALUES (?,?,?,?);");
                    st.setString(1,line[0]);
                    st.setInt(2, Integer.parseInt(line[1]));
                    st.setDate(3,Date.valueOf(LocalDate.from(LocalDateTime.parse(line[2],dtf))));
                    st.setString(4,line[3]);
                    int rs = st.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int uploadAddresses(String country,String city){
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select address_id " +
                    "from address " + "where country = ? and city =?;");
            ps.setString(1,country);
            ps.setString(2,city);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("address_id");
            }
            ps = con.prepareStatement("insert into address(country, city)\n" +
                    "values (?,?)");
            ps.setString(1,country);
            ps.setString(2,city);
            int res = ps.executeUpdate();
            return uploadAddresses(country,city);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
