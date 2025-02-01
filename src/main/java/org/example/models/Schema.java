package org.example.models;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Schema {
    Map<String,Column> columns;

    public Column getColumn(String columnName) {
        return columns.getOrDefault(columnName,null);
    }

    public Schema(Map<String,Column> columns) {
        this.columns = columns;
    }

    public boolean validate(){
        //check if 2 columns should not be of same name
        //check if 2 columns should not be primary column
        return (checkDuplicateName() && checkPrimaryKey());
    }

    public boolean checkDuplicateName(){
        Set<String> names = new HashSet<>();
        for(String columnName:columns.keySet()){
            if(names.contains(columnName)){
                return false;
            }
            names.add(columnName);
        }
        return true;
    }

    public boolean checkPrimaryKey(){
        boolean hasPrimary=false;
        for(Map.Entry<String,Column> column:columns.entrySet()){
            if(hasPrimary && column.getValue().isPrimary){
                return false;
            }
            if(column.getValue().isPrimary)hasPrimary=true;
        }
        return true;
    }
}
