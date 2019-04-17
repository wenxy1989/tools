package com.snake.tools.sql.model;

import com.snake.tools.sql.file.AbstractTableParser;

public class LabelParser extends AbstractTableParser<Label> {
    @Override
    public String getTableName() {
        return "base_label";
    }

    @Override
    public Label parseObject(String[] values) {
        Label label = new Label();
        if(null != values[0]) {
            label.setId(Long.parseLong(values[0]));
        }
        if(null != values[1]) {
            label.setName(values[1]);
        }
        return label;
    }

    @Override
    public void afterParse(Label object) {
        System.out.println(object);
    }
}
