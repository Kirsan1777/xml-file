package by.tc.task03.entity;

public class Attribute {
    private String nameAttribute;
    private String valueAttribute;

    public Attribute(){

    }

    public Attribute(String nameAttribute, String valueAttribute){
        this.nameAttribute = nameAttribute;
        this.valueAttribute = valueAttribute;
    }

    public String getNameAttribute() {
        return nameAttribute;
    }

    public void setNameAttribute(String nameAttribute) {
        this.nameAttribute = nameAttribute;
    }

    public String getValueAttribute() {
        return valueAttribute;
    }

    public void setValueAttribute(String valueAttribute) {
        this.valueAttribute = valueAttribute;
    }

    @Override
    public String toString() {
        return nameAttribute + " " + valueAttribute;
    }
}
