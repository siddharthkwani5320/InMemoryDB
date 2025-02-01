package org.example.models;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Database {
    String name;
    String id;
    Map<String,Table> tables;

    public Database(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.tables = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Table> getTables() {
        return tables;
    }

    public void setTables(Map<String, Table> tables) {
        this.tables = tables;
    }

    public Table getTable(String tableName){
        return this.tables.get(tableName);
    }

    public void dropTable(String tableName){
        this.tables.remove(tableName);
    }

    public void createTable(String name,Schema schema){
        Table table = new Table(name,schema);
        this.tables.put(name,table);
    }

    public void showtable(){
        if (this.tables.size()==0){
            System.out.println("No Tables Exist");
            return;
        }
        System.out.println("Tables");
        for(String tableName:tables.keySet()){
            System.out.println(tableName);
        }
    }
}
