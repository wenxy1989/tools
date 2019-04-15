package com.snake.tools.sql.file;

import java.io.IOException;

public class TableParser {

    public void parse(String file) throws IOException {
        String tableName = "base_label";
        tableName = "cgm_wear";
        TableSql tableSql = new TableSql(file,new Table(tableName,"id","name"));
        while (tableSql.available()){
            String value = tableSql.getValue();
            if(tableSql.isInsertLine()) {
                System.out.println(value);
            }
        }
        tableSql.close();
    }

}
