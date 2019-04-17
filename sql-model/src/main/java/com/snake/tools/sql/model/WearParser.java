package com.snake.tools.sql.model;

import com.snake.tools.sql.file.AbstractTableParser;

public class WearParser extends AbstractTableParser<Wear> {

    @Override
    public String getTableName() {
        return "cgm_wear";
    }

    public Wear parseObject(String[] values) {
        Wear wear = new Wear();
        int i = 0;
        if (values[i] != null) {
            wear.setId(Long.parseLong(values[i++]));
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setIdCard(values[i++]);
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setEmitter(values[i++]);
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setSensor(values[i++]);
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setStart(values[i++]);
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setEnd(values[i++]);
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setCount(Integer.parseInt(values[i++]));
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setAvgGlucose(Double.parseDouble(values[i++]));
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setAvgCurrent(Double.parseDouble(values[i++]));
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setStddevPopGlucose(Double.parseDouble(values[i++]));
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setStddevPopCurrent(Double.parseDouble(values[i++]));
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setStddevSampGlucose(Double.parseDouble(values[i++]));
        } else {
            i++;
        }
        if (values[i] != null) {
            wear.setStddevSampCurrent(Double.parseDouble(values[i++]));
        } else {
            i++;
        }
        return wear;
    }
}
