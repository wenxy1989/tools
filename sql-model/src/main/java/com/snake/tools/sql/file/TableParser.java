package com.snake.tools.sql.file;

import java.io.IOException;

public class TableParser {

    public void parse(String file) throws IOException {
        TableSql tableSql = new TableSql(file);
        while (tableSql.available()){
            String line = tableSql.readString();
            System.out.println(line);
        }
        tableSql.close();
    }

}
