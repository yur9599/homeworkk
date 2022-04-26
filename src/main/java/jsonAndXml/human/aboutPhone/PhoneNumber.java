package jsonAndXml.human.aboutPhone;

public class PhoneNumber {

    private String number;
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
