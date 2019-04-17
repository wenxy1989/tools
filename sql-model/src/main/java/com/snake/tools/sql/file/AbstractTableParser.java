package com.snake.tools.sql.file;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractTableParser<T> {

    public abstract String getTableName();

    public int getColumnCount(){
        return 20;
    }

    public String beforeParse(String value) {
        System.out.println(value);
        return value;
    }

    public abstract T parseObject(String[] values);

    public void afterParse(T object) {
        System.out.println(object);
    }

    public String[] getColumnValues(String value) {
        Matcher matcher = Pattern.compile(TableSqlTool.column_regex).matcher(value);
        String[] values = new String[getColumnCount()];
        for (int i = 0; matcher.find() && i < getColumnCount(); i++) {
            String v = matcher.group();
            if (v.equals("NULL")) {
                values[i] = null;
            } else if (v.contains("'")) {
                values[i] = v.replaceAll("'", "");
            } else {
                values[i] = v;
            }
        }
        return values;
    }

    public void parse(String file) throws IOException {
        this.parse(file, -1);
    }

    public void parse(String file, int count) throws IOException {
        TableSqlTool tableSqlTool = new TableSqlTool(file, getTableName());
        int i = 0;
        while (tableSqlTool.available() && (count < 0 || i < count)) {
            String value = tableSqlTool.getValue();
            if (null != value) {
                value = this.beforeParse(value);
                T object = this.parseObject(this.getColumnValues(value));
                this.afterParse(object);
                i++;
            }
        }
        System.out.println("total count is : " + i);
        tableSqlTool.close();
    }

}
