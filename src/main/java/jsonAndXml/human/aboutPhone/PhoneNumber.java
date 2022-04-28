package jsonAndXml.human.aboutPhone;

import jakarta.xml.bind.annotation.XmlElement;

public class PhoneNumber {
    @XmlElement
    private String number;
    @XmlElement
    private NumberType type;

    public PhoneNumber(){}

    public PhoneNumber(String number,NumberType type){
        this.number=number;
        this.type=type;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "number='" + number + '\'' +
                ", type=" + type +
                '}';
    }

}
