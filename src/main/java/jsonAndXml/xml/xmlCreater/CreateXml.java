package jsonAndXml.xml.xmlCreater;

import jsonAndXml.human.employee.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class CreateXml {

    private CreateXml(){}

    public static void addData(File file, Object... x){
        try {
            JAXBContext jc = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(x,file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}