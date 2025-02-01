package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.example.models.Row.validate;

public class Table {
    String name;
    String id;
    Schema schema;
    String primaryKey;
    List<Row> rows;

    public Table(String name, Schema schema) {
        this.name = name;
        this.schema = schema;
        rows= new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void select(){
        System.out.println("TableName: "+this.name);
        for(Row row:rows){
            System.out.println("---------------------------------------------");
            for(Map.Entry<String,Object> column : row.getColumns().entrySet()){
                System.out.println(column.getKey() + ":"+column.getValue());
            }
            System.out.println("---------------------------------------------");
        }
        System.out.println("row_count : "+ rows.size());
    }

    public void insert(Map<String,Object> rowObj){
        for(Map.Entry<String,Object> row: rowObj.entrySet()){
            if(this.schema.getColumn(row.getKey())==null){
                System.out.println("Error inserting data column "+row.getKey()+" doesnt exist");
                return;
            }
            if(!validate(this.schema.getColumn(row.getKey()),row.getValue())){
                System.out.println("Error inserting data column validation failed for column "+row.getKey());
                return;
            }
        }
        Row row= new Row(rowObj);
        this.rows.add(row);

        System.out.println("Row Inserted Successfully \nrows affected :- "+1);
    }
}
