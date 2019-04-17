package com.snake.tools.sql;

import com.snake.tools.sql.file.TableSqlTool;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTests {

    private static final String input_value = "insert into base_table (11111,11.3,'1sk.dks'),(3343,33.233,'sskd'),(23243,2.32,";

    @Test
    public void numberTest(){
        Pattern pattern = Pattern.compile(TableSqlTool.number_regex);
        Matcher matcher = pattern.matcher(input_value);
        while(matcher.find()) {
            System.out.println(String.format("index : %d , value : %s",matcher.start(),matcher.group()));
        }
    }

    @Test
    public void decimalTest(){
        Pattern pattern = Pattern.compile(TableSqlTool.decimal_regex);
        Matcher matcher = pattern.matcher(input_value);
        while(matcher.find()) {
            System.out.println(String.format("index : %d , value : %s",matcher.start(),matcher.group()));
        }
    }

    @Test
    public void stringTest(){
        Pattern pattern = Pattern.compile(TableSqlTool.string_regex);
        Matcher matcher = pattern.matcher(input_value);
        while(matcher.find()) {
            System.out.println(String.format("index : %d , value : %s",matcher.start(),matcher.group()));
        }
    }

    @Test
    public void columnTest(){
        Pattern pattern = Pattern.compile(TableSqlTool.column_regex);
        Matcher matcher = pattern.matcher(input_value);
        while(matcher.find()) {
            System.out.println(String.format("index : %d , value : %s",matcher.start(),matcher.group()));
        }
    }

    @Test
    public void valuesTest(){
        Pattern pattern = Pattern.compile(TableSqlTool.value_regex);
        Matcher matcher = pattern.matcher(input_value);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void matcherOffsetTest(){
        Pattern pattern = Pattern.compile(TableSqlTool.value_regex);
        Matcher matcher = pattern.matcher(input_value);
        while (matcher.find()) {
            System.out.println(matcher.start());
            System.out.println(matcher.group());
        }
    }

}
