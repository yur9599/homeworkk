package com.company.workingWithFiles;

import java.io.*;

public class WorkingWithFiles {

    private WorkingWithFiles(){}

    public static void countHellos(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("hellos.txt"));
            writer.write("hello hello hello");
            writer.write("\nola ola hello");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try {
            int count=0;
            int line=0;
            String word;
            String [] words;
            BufferedReader reader = new BufferedReader(new FileReader("hellos.txt"));
            while ((word=reader.readLine()) != null){
                words=word.split(" ");
                for (String x:words) {
                    if (x.equalsIgnoreCase("hello")){
                        count++;
                    }
                }
                System.out.println("Line "+(++line)+"-"+count);
                count=0;
            }
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
