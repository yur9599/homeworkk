package jsonAndXml.human.employee;

import jsonAndXml.human.aboutPhone.PhoneNumber;
import jsonAndXml.human.address.Address;
import java.util.List;

public class Employee {

    private String fName;
    private String lName;
    private int age;
    private Address address;
    private List<PhoneNumber> numbers;

    public Employee(){}

    public Employee(String fName,String lName,int age,Address address,List<PhoneNumber> numbers){
        this.fName=fName;
        this.lName=lName;
        this.age=age;
        this.address=address;
        this.numbers=numbers;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<PhoneNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", numbers=" + numbers +
                '}';
    }

}
