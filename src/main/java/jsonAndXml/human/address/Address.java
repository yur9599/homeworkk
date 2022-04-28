package jsonAndXml.human.address;


import jakarta.xml.bind.annotation.XmlElement;

public class Address {
    @XmlElement
    private String city;
    @XmlElement
    private String country;
    @XmlElement
    private String street;
    @XmlElement
    private String postalCode;

    public Address(){}

    public Address(String city, String country, String street, String postalCode) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

}
