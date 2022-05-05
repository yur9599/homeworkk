package homeworkJDBC.entities;

import java.util.Date;

public class Company {

    private String companyName;
    private Date foundingDate;

    public Company() {
    }

    public Company(String companyName, Date foundingDate) {
        this.companyName = companyName;
        this.foundingDate = foundingDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(Date foundingDate) {
        this.foundingDate = foundingDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", foundingDate=" + foundingDate +
                '}';
    }

}
