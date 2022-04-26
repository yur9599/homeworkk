package jsonAndXml.json.jsonCreater;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJson {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private CreateJson(){}

    public static void addData(File file,Object... x){
        try(FileWriter fileWriter = new FileWriter(file)){
            gson.toJson(x,fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
