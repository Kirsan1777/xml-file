package by.tc.task03.service;

import by.tc.task03.entity.Attribute;

public class AttributeService {

    public Attribute processInformationAttribute(String line){ // получаем имя аттрибута и его значение
        Attribute attribute = new Attribute();
        String tempProcessingResult;
        String[] result = line.split(">");
        tempProcessingResult = result[0];
        String[] resultName = tempProcessingResult.split("<");
        tempProcessingResult = result[1];
        String[] resultValue = tempProcessingResult.split("<");
        attribute.setNameAttribute(resultName[1]);
        attribute.setValueAttribute(resultValue[0]);
        return attribute;
    }

    public boolean isAttribute(String str){
        int countLeft = 0, countRight = 0;
        for (char element : str.toCharArray()) {
            //смотрим, чем является строка: атрибутом или названием объекта, ну походу это надо менять, так как в строке может быть больше 2-х скобок
            if (element == '<') countLeft++;
            if (element == '>') countRight++;
        }
        return countLeft == 2;
    }

}
