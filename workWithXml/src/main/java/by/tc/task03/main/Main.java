package by.tc.task03.main;


import by.tc.task03.entity.Element;
import by.tc.task03.service.ElementService;
import by.tc.task03.service.FileService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ElementService elementService = new ElementService();
        FileService fileReader = new FileService();
        Element element;
        List<String> listFile = fileReader.readFileAll();
        for(String i : listFile){
            System.out.println(i);
        }
        element = elementService.findAllElements(fileReader.readFileAll());
        PrintElementInfo.print(element);

    }
}
