package com.snake.tools.sql.file;

public class Table {

    private String name;
    private String[] columns;

    public Table(String name,String... columns){
        this.name = name;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String getInsertStartString(){
        return String.format("INSERT INTO `%s` VALUES ",this.name.toUpperCase());
    }
}
