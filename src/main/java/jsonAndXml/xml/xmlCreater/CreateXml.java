package jsonAndXml.xml.xmlCreater;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import jsonAndXml.List.EmployeesList;

import java.io.File;

public class CreateXml {
    private CreateXml(){}
    public static void addData(File file, Object x){
        try {
            JAXBContext jc = JAXBContext.newInstance(EmployeesList.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(x , file);
        } catch ( JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}