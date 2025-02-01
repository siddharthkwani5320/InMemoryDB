package org.example.service;

import org.example.models.Column;
import org.example.models.Database;
import org.example.models.Schema;
import org.example.models.Table;
import org.example.models.columnType.IntColumn;
import org.example.models.columnType.VarcharColumn;

import java.util.HashMap;
import java.util.Map;

public class DbManagerService {
    Map<String,Database> inmemoryDb;

    public DbManagerService() {
        inmemoryDb=new HashMap<>();
    }

    public void Manage(){
        listDB();

        //create a database
        Database db = createDB("test");
        addDB(db);

        listDB();

        createTable("test");

        insertRows("test","table1");

    }

    public void insertRows(String dbName,String tableName){
        Database db=inmemoryDb.get(dbName);
        Table table = db.getTable(tableName);

        table.select();

        //insert 2 rows
        Map<String,Object> row1=new HashMap<>();
        row1.put("col1",5);
        row1.put("col2","sid");
        table.insert(row1);

        Map<String,Object> row2=new HashMap<>();
        row2.put("col1","sid");
        row2.put("col2",65);
        table.insert(row2);

        table.select();
    }

    public void createTable(String dbName){
        Database db=inmemoryDb.get(dbName);
        db.showtable();
        Map<String,Column> columns = new HashMap<>();
        columns.put("col1",new IntColumn("col1",true));
        columns.put("col2",new VarcharColumn("col2",false));
        Schema schema = new Schema(columns);
        schema.validate();
        db.createTable("table1",schema);
        db.createTable("table2",schema);
        db.showtable();
    }

    public Database createDB(String dbName){
        return new Database(dbName);
    }

    public void addDB(Database db){
        inmemoryDb.put(db.getName(),db);
    }

    public void listDB(){
        if (inmemoryDb.size()==0){
            System.out.println("No Database");
            return;
        }
        System.out.println("Databases");
        for(String dbName:inmemoryDb.keySet()){
            System.out.println(dbName);
        }
    }
}
