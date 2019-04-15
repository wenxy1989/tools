package com.snake.tools.sql;

import com.snake.tools.sql.file.TableSql;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTests {

    private static final String input_value = "insert into base_table (11111,11.3,'1sk.dks'),(3343,33.233,'sskd')";

    @Test
    public void numberTest(){
        Pattern pattern = Pattern.compile(TableSql.number_regex);
        Matcher matcher = pattern.matcher(input_value);
        assert matcher.find();
        System.out.println(matcher.group());
    }

    @Test
    public void decimalTest(){
        Pattern pattern = Pattern.compile(TableSql.decimal_regex);
        Matcher matcher = pattern.matcher(input_value);
        assert matcher.find();
        System.out.println(matcher.group());
    }

    @Test
    public void stringTest(){
        Pattern pattern = Pattern.compile(TableSql.string_regex);
        Matcher matcher = pattern.matcher(input_value);
        assert matcher.find();
        System.out.println(matcher.group());
    }

    @Test
    public void columnTest(){
        Pattern pattern = Pattern.compile(TableSql.column_regex);
        Matcher matcher = pattern.matcher(input_value);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void valuesTest(){
        Pattern pattern = Pattern.compile(TableSql.value_regex);
        Matcher matcher = pattern.matcher(input_value);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
