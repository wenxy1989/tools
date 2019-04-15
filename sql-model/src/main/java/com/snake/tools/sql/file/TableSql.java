package com.snake.tools.sql.file;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableSql {

    public static final String number_regex = "(\\d)+";
    public static final String decimal_regex = "(\\d)+(\\.)(\\d)+";
    public static final String string_regex = "'.*'";
    public static final String column_regex = String.format("(%s)|(%s)|(%s)",number_regex,decimal_regex,string_regex);
    public static final String value_regex = String.format("(\\()(%s)(,(%s))*(\\))", column_regex, column_regex);//todo
    private static final Pattern value_pattern = Pattern.compile(value_regex);

    private FileReader fileReader;
    private boolean insertLine = false;
    private Table table;

    private String insertSql;

    public TableSql(String file, Table table) throws FileNotFoundException {
        this.fileReader = new FileReader(file);
        this.table = table;
        this.insertSql = "";
    }

    public boolean insertString(String line) {
        return line.toUpperCase().indexOf(this.table.getInsertStartString()) >= 0;
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
        if (this.isInsertLine() && matcher.find()) {
            String value = matcher.group();
            this.insertSql = this.insertSql.substring(0, value.length());
            return value;
        }
        return null;
    }

    public String getValue() throws IOException {
        if (this.insertSql == "") {
            do {
                String line = this.readString();
                if (this.isInsertLine()) {
                    this.insertSql = line.substring(this.table.getInsertStartString().length() - 1);
                    break;
                }
            } while (true);
        } else if (!this.insertSql.matches(value_regex)) {
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
