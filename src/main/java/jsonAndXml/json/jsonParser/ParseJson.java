package jsonAndXml.json.jsonParser;


import com.google.gson.*;
import jsonAndXml.human.employee.Employee;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ParseJson {

    private ParseJson(){}

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void uploadData(File file, List<Employee> list) {
        try (FileReader fileReader = new FileReader(file)) {
            Employee[] employee = gson.fromJson(fileReader, Employee[].class);
            list.addAll(Arrays.asList(employee));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
