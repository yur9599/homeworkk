package homeworkJDBC.daos.companyDAO;

import homeworkJDBC.entities.Company;

import java.util.Set;

public interface CompanyDAO {

    Company getById(long id);

    Set<Company> getAll();

    Set<Company> get(int offset, int perPage, String sort);

    Company save(Company company);

    Company update(int id,Company company);

    void delete(long companyId);

}
