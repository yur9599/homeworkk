package jsonAndXml.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jsonAndXml.human.employee.Employee;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class EmployeesList {

    @XmlElement(name = "employee")
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "EmployeesList{" +
                "employees=" + employees +
                '}';
    }
}
