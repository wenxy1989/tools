package com.snake.tools.sql.model;

public class Glucose {

    private String uuid;
    private String idCard;
    private String emitter;
    private String sensor;
    private Double value;
    private Double current;
    private String time;
    private String created;

    @Override
    public String toString() {
        return String.format("{uuid:%s,idCard:%s,emitter:%s,sensor:%s,value:%f,current:%f,time:%s,created:%s}",this.uuid,this.idCard,this.emitter,this.sensor,this.value,this.current,this.time,this.created);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmitter() {
        return emitter;
    }

    public void setEmitter(String emitter) {
        this.emitter = emitter;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
