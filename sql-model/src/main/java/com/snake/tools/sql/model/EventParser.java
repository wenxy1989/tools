package com.snake.tools.sql.model;

import com.snake.tools.sql.file.AbstractTableParser;

public class EventParser extends AbstractTableParser<Event> {
    @Override
    public String getTableName() {
        return "sam_event";
    }

    @Override
    public String beforeParse(String value) {
//        return super.beforeParse(value);
        return value;
    }

    @Override
    public Event parseObject(String[] values) {
        Event event = new Event();
        try {
            if (null != values[0]) {
                event.setId(Long.parseLong(values[0]));
            }
            if (null != values[1]) {
                event.setPatientId(Long.parseLong(values[1]));
            }
            if (null != values[2]) {
                event.setType(Integer.parseInt(values[2]));
            }
            if (event.getType() == 1 && null != values[4]) {
                if (null != values[3] && values[3] != "") {
                    event.setMealType(Integer.parseInt(values[3]));
                }
                event.setContent(values[4]);
            } else if (event.getType() == 2 && null != values[5]) {
                event.setContent(values[5]);
            } else if (event.getType() == 3 && null != values[6]) {
                event.setContent(values[6]);
            } else if (event.getType() == 4 && null != values[15]) {
                event.setContent(values[15]);
            }
            if (null != values[9]) {
                event.setTime(values[9]);
            }
            if (null != values[10]) {
                event.setCreated(values[10]);
            }
        } catch (Exception e) {
//                    e.printStackTrace();
        }
        return event;
    }
}
