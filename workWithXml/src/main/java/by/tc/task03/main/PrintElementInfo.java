package by.tc.task03.main;

import by.tc.task03.entity.Attribute;
import by.tc.task03.entity.Element;
import by.tc.task03.entity.Subject;

public class PrintElementInfo {

    public static void print(Element element) {
        System.out.println("Name element = " + element.getMainElementName());
        for(Subject j: element.getListWithSubject()){
            //System.out.print("Name subject = " + j.getSubjectName() + "   ");
            //System.out.println("Value subject = " + j.getSubjectValue());
            System.out.println("-------------------------------");
            System.out.print(j.getSubjectName() + "   ");
            System.out.println(j.getSubjectValue());
            System.out.println("-------------------------------");
            for(Attribute k : j.getListWithAttribute()){
                //System.out.println("Name attribute = " + k.getNameAttribute());
                //System.out.println("Value attribute = " + k.getValueAttribute());
                System.out.print(k.getNameAttribute() + "   ");
                System.out.println(k.getValueAttribute());
            }
        }
    }

}
