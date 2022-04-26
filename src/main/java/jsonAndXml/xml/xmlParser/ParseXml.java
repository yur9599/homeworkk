package jsonAndXml.xml.xmlParser;


import jsonAndXml.human.employee.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ParseXml {

    private ParseXml(){}

    public static void uploadData(File file, List<Employee> list){
        try {
            JAXBContext jc = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Employee[] employees = (Employee[]) unmarshaller.unmarshal(file);
            list.addAll(Arrays.asList(employees));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

}
