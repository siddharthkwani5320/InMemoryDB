package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Row {
    String id;
    Map<String,Object> columns;

    public Row(Map<String, Object> row) {
        this.columns = row;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getColumns() {
        return columns;
    }

    public static boolean validate(Column column,Object value){
        return column.validate(value);
    }

}
