package com.snake.tools.sql.file;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableSqlTool {

    public static final String number_regex = "(\\d)+";
    public static final String decimal_regex = "(\\d)+(\\.)(\\d)+";
    public static final String string_regex = "'([^()'])*'";
    public static final String null_regex = "NULL";
    public static final String column_regex = String.format("(%s)|(%s)|(%s)|(%s)", string_regex, decimal_regex, number_regex, null_regex);
    public static final String value_regex = String.format("\\((%s)((,(%s))*)\\)", column_regex, column_regex);//todo
    private static final Pattern value_pattern = Pattern.compile(value_regex);

    private FileReader fileReader;
    private boolean insertLine = false;
    private String insertStartString;

    private String insertSql;

    public TableSqlTool(String file, String tableName) throws FileNotFoundException {
        this.fileReader = new FileReader(file);
        this.insertStartString = String.format("INSERT INTO `%s` VALUES ", tableName.toUpperCase());
        this.insertSql = "";
    }

//    public String getInsertStartString(){
//        return this.insertStartString;
//    }

    public boolean insertString(String line) {
        return line.toUpperCase().indexOf(this.insertStartString) >= 0;
    }

    public String readString() throws IOException {
        String line = this.fileReader.readString();
        if (null != line) {
            line = line.trim();
        }
        this.insertLine = this.fileReader.isLineStart() ? insertString(line) : this.insertLine;
        if (this.fileReader.isLineStart()) {
            this.insertSql = "";
        }
        return line;
    }

    public String subValue() {
        Matcher matcher = value_pattern.matcher(this.insertSql);
        matcher.reset();
        if (this.isInsertLine() && matcher.find()) {
            String value = matcher.group();
            int start = matcher.start() + value.length() + 1;
            if (start < this.insertSql.length()) {
                this.insertSql = this.insertSql.substring(start);
            } else {
                this.insertSql = "";
            }
            return value;
        }
        return null;
    }

    public String getValue() throws IOException {
        if (this.insertSql == "") {
            do {
                String line = this.readString();
                if (this.isInsertLine()) {
                    if (insertString(line)) {
                        this.insertSql = line.substring(this.insertStartString.length());
                    } else {
                        this.insertSql = line;
                    }
                    break;
                }
            } while (true && this.available());
        } else if (!value_pattern.matcher(this.insertSql).find()) {
            do {
                this.insertSql += this.readString();
            } while (!this.isInsertLine());
        }
        return subValue();
    }

    public boolean isInsertLine() {
        return this.insertLine;
    }

    public boolean available() throws IOException {
        return this.fileReader.available() > 0;
    }

    public void close() throws IOException {
        this.fileReader.close();
    }

}
