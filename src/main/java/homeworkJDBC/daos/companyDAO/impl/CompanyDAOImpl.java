package homeworkJDBC.daos.companyDAO.impl;

import homeworkJDBC.daos.companyDAO.CompanyDAO;
import homeworkJDBC.entities.Company;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import static homeworkJDBC.dbConnection.DBConnection.DB_INSTANCE;

public class CompanyDAOImpl implements CompanyDAO {

    @Override
    public Company getById(long id) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select name,founding_date " +
                    "from company " +
                    "where id_comp=?;");
            ps.setInt(1, (int) id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Company(rs.getString(1),rs.getDate(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Company> getAll() {
        Set<Company> companies = new HashSet<>();
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select name,founding_date " +
                    "from company ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                companies.add(new Company(rs.getString(1),rs.getDate(2)));
            }
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Company> get(int offset, int perPage, String sort) {
        Set<Company> companies = new HashSet<>();
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("select name,founding_date from company " +
                    "order by "+ sort + " limit ? offset ?;");
            ps.setInt(1,perPage);
            ps.setInt(2,offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                companies.add(new Company(rs.getString(1),rs.getDate(2)));
            }
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Company save(Company company) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("insert into company(name, founding_date) " +
                    "values (?,?);");
            ps.setString(1,company.getCompanyName());
            ps.setDate(2, (Date) company.getFoundingDate());
            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return company;
    }

    @Override
    public Company update(int id,Company company) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("update company set name=?,founding_date=?" +
                    " where id_comp=?;");
            ps.setString(1,company.getCompanyName());
            ps.setDate(2, (Date) company.getFoundingDate());
            ps.setInt(3,id);
            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return company;
    }

    @Override
    public void delete(long companyId) {
        try(Connection con = DB_INSTANCE.createConnection()){
            PreparedStatement ps = con.prepareStatement("delete from company where id_comp=?;");
            ps.setInt(1,(int) companyId);
            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
