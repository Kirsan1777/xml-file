package by.tc.task03.service;

import by.tc.task03.entity.Subject;

public class SubjectService {

    private static final String findStartTag = "<";
    private static final String findEndTag = ">";
    private static final String emptyIdentificationField = " ";

    public Subject discoverNameSubject(String resultingString){//Получаем только имя переменной
        Subject returnedSubjectName = new Subject();
        String[] temp = resultingString.split(findStartTag);
        String returnedString = temp[1];
        temp = returnedString.split(findEndTag);
        returnedSubjectName.setSubjectName(temp[0]);
        returnedSubjectName.setSubjectValue(emptyIdentificationField);
        return returnedSubjectName;
    }

    public Subject discoverNameValueSubject(String resultingString){//Получаем имя переменное и её значение

        Subject subject = new Subject();
        String valueSubject;
        String nameSubject;

        String[] tempGetValue = resultingString.split("\"");
        valueSubject = tempGetValue[1];

        String[] tempGetName = resultingString.split("<");
        tempGetName = tempGetName[1].split(" ");
        nameSubject = tempGetName[0];

        subject.setSubjectName(nameSubject);
        subject.setSubjectValue(valueSubject);

        return subject;
    }

    public Subject discoverNameAndValueSubject(String str){
        Subject subject = new Subject();
        if (str.contains("'") || str.contains("\"")) {
            //получить значение и название объекта
            subject.setSubjectName(discoverNameAndValueSubject(str).getSubjectName());
            subject.setSubjectValue(discoverNameAndValueSubject(str).getSubjectValue());

            // ' and " означают о наличии значения присвоеного объекту
        } else {
            //получить название объекта без его значения
            //mainSubject.setSubjectName(discoverNameSubject(str));
            subject.setSubjectName(subjectService.discoverNameSubject(str).getSubjectName());
            subject.setSubjectValue(subjectService.discoverNameSubject(str).getSubjectValue());
        }
    }

}
