package jsonAndXml.human.address;


public class Address {

    private String city;
    private String country;
    private String street;
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
