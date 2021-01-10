package by.tc.task03.entity;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String subjectName;
    private String subjectValue;
    private List<Attribute> listWithAttribute = new ArrayList<>();

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectValue() {
        return subjectValue;
    }

    public void setSubjectValue(String subjectValue) {
        this.subjectValue = subjectValue;
    }

    public List<Attribute> getListWithAttribute() {
        return listWithAttribute;
    }

    public void setListWithAttribute(List<Attribute> listWithAttribute) {
        this.listWithAttribute = listWithAttribute;
    }

    @Override
    public String toString() {
        return       subjectName + " " + subjectValue + " " +  listWithAttribute;
    }
}
