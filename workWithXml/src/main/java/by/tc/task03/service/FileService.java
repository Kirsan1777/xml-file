package by.tc.task03.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<String> readFileAll() throws IOException {
        List<String> listWithAllAppliance = new ArrayList<>();
        FileReader fileReader = new FileReader("C:\\Users\\Nikita\\Desktop\\temp.txt");

        try
        {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s;
            while((s=bufferedReader.readLine())!=null){
                listWithAllAppliance.add(s);
            }
            bufferedReader.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());

        }

        return listWithAllAppliance;
    }

}
