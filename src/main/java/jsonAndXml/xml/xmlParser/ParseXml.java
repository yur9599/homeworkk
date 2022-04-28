package jsonAndXml.xml.xmlParser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import jsonAndXml.List.EmployeesList;
import jsonAndXml.human.employee.Employee;

import java.io.File;

public class ParseXml {

    private ParseXml(){}

    public static EmployeesList uploadData(File file){
        EmployeesList x;
        try {
            JAXBContext jc = JAXBContext.newInstance(EmployeesList.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            x = ((EmployeesList) unmarshaller.unmarshal(file));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return x;
    }

}
