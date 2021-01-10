package by.tc.task03.service;

import by.tc.task03.entity.Attribute;
import by.tc.task03.entity.Element;
import by.tc.task03.entity.Subject;


import java.util.ArrayList;
import java.util.List;

public class ElementService {

    private static final String closingSubjectSlash = "/";

    //todo избавиться от магических значинй, расскидать большой метод на отдельные, сделать код красивым и хорошо читабельным
    public Element findAllElements(List<String> listWithAllElements){

        List<Attribute> listWithAttribute = new ArrayList<>();
        List<Subject> listWithSubject = new ArrayList<>();

        Subject mainSubject = new Subject();
        Element mainElement = new Element();

        AttributeService attributeService = new AttributeService();
        SubjectService subjectService = new SubjectService();

        int count = 0;

        for (String str : listWithAllElements) {
            if (count == 0) {
                mainElement.setMainElementName(subjectService.discoverNameSubject(str).getSubjectName());
                //первая строка отвечает за название группы объектов ОСНОВНОЕ ИМЯ задается здесь
                count++;
            } else {
                count++;
                if (count == listWithAllElements.size()) {
                    //System.out.println("Size of massive = " + listWithSubject.size());
                    mainElement.setListWithSubject(listWithSubject);
                    return mainElement;//проверить на выполнение условия ПОСЛЕДНЯЯ СТРОКА ЗАВЕРШАЕТ ВСЮ РАБОТУ МЕТОДА
                }

                if (!attributeService.isAttribute(str)) {
                    if (str.contains(closingSubjectSlash)) {

                        mainSubject.setListWithAttribute(listWithAttribute);

                        System.out.println("Subject = " + mainSubject);

                        listWithSubject.add(mainSubject);

                        mainSubject = new Subject();
                        listWithAttribute = new ArrayList<>();

                    } else {
                        //сохранить название элемента, после чего элемент должен быть добавлен к списку атрибутов в специальный лист
                        //так же должна быть проверка на наличие индекса или иного опознавательного элемента

                        if (str.contains("'") || str.contains("\"")) {
                            //получить значение и название объекта
                            mainSubject.setSubjectName(subjectService.discoverNameAndValueSubject(str).getSubjectName());
                            mainSubject.setSubjectValue(subjectService.discoverNameAndValueSubject(str).getSubjectValue());

                            // ' and " означают о наличии значения присвоеного объекту
                        } else {
                            //получить название объекта без его значения
                            //mainSubject.setSubjectName(discoverNameSubject(str));
                            mainSubject.setSubjectName(subjectService.discoverNameSubject(str).getSubjectName());
                            mainSubject.setSubjectValue(subjectService.discoverNameSubject(str).getSubjectValue());
                        }
                    }
                }

               // if (countLeft == 2 && countRight == 2) {//Работает
                    if (attributeService.isAttribute(str)) {
                    Attribute attribute = attributeService.processInformationAttribute(str);
                    listWithAttribute.add(attribute);
                }

            }
        }
        System.out.println("Error!");
        return mainElement;
    }

    /*public String processInformationAttribute(String line){ // получаем имя аттрибута и его значение
        // Кривовато и не факт, что так можно
        // Возможно следует возвращать сразу Attribute
        String processingResult;
        String tempProcessingResult;
        String[] result = line.split(">");
        tempProcessingResult = result[0];
        String[] resultName = tempProcessingResult.split("<");
        tempProcessingResult = result[1];
        String[] resultValue = tempProcessingResult.split("<");
        processingResult = resultName[1] + "~" + resultValue[0];
        return processingResult;
    }*/

    /*public String discoverNameSubject(String resultingString){//Получаем только имя переменной
        String returnedString;
        String[] temp = resultingString.split("<");
        returnedString = temp[1];
        temp = returnedString.split(">");
        returnedString = temp[0];
        return returnedString;
    }*/

    /*public String discoverNameAndValueSubject(String resultingString){//Получаем имя переменное и её значение
        //<food id="1">
        // split " " -> <food(0) id="1">(1)
        // split "<" -> (0) food(1)???
        String returnedNameAndValue;
        String valueSubject;
        String nameSubject;

        String[] tempGetValue = resultingString.split("\"");
        valueSubject = tempGetValue[1];

        String[] tempGetName = resultingString.split("<");
        tempGetName = tempGetName[1].split(" ");
        nameSubject = tempGetName[0];

        returnedNameAndValue = nameSubject + "~" + valueSubject;
        return returnedNameAndValue;
    }*/


}
