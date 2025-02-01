package org.example.models;

public abstract class Column {
    String name;
    Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    Boolean isPrimary;

    public Column(String name, Boolean isPrimary) {
        this.name = name;
        this.isPrimary = isPrimary;
    }

    protected abstract boolean validate(Object value);
}
