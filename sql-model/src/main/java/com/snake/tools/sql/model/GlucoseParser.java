package com.snake.tools.sql.model;

import com.snake.tools.sql.file.AbstractTableParser;

public class GlucoseParser extends AbstractTableParser<Glucose> {
    @Override
    public String getTableName() {
        return "sam_glycemic";
    }

    @Override
    public String beforeParse(String value) {
//        return super.beforeParse(value);
        return value;
    }

    @Override
    public Glucose parseObject(String[] values) {
        Glucose glucose = new Glucose();
        if(null != values[0]) {
            glucose.setUuid(values[0]);
        }
        if(null != values[1]) {
            glucose.setIdCard(values[1]);
        }
        if(null != values[7]) {
            glucose.setEmitter(values[7]);
        }
        if(null != values[8]) {
            glucose.setSensor(values[8]);
        }
        if(null != values[3]) {
            glucose.setValue(Double.parseDouble(values[3]));
        }
        if(null != values[5]) {
            glucose.setCurrent(Double.parseDouble(values[5]));
        }
        if(null != values[11]) {
            glucose.setTime(values[11]);
        }
        if(null != values[12]) {
            glucose.setCreated(values[12]);
        }
        return glucose;
    }

    @Override
    public void afterParse(Glucose object) {
        super.afterParse(object);
    }
}
