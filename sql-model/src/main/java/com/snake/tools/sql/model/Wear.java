package com.snake.tools.sql.model;

public class Wear {

    private Long id;
    private String idCard;
    private String emitter;
    private String sensor;
    private String start;
    private String end;
    private Integer count;
    private Double avgGlucose;
    private Double avgCurrent;
    private Double stddevPopGlucose;
    private Double stddevPopCurrent;
    private Double stddevSampGlucose;
    private Double stddevSampCurrent;

    @Override
    public String toString() {
        return String.format("{id:%d,idCard:%s,count:%d,start:%s,end:%s,avgGlucose:%f,avgCurrent:%s,stddevPopGlucose:%f,stddevPopCurrent:%f,stddevSampGlucose:%f,stddevSampCurrent:%f}",this.id,this.idCard,this.count,this.start,this.end,this.avgGlucose,this.avgCurrent,this.stddevPopGlucose,this.stddevPopCurrent,this.stddevSampGlucose,this.stddevSampCurrent);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAvgGlucose() {
        return avgGlucose;
    }

    public void setAvgGlucose(Double avgGlucose) {
        this.avgGlucose = avgGlucose;
    }

    public Double getAvgCurrent() {
        return avgCurrent;
    }

    public void setAvgCurrent(Double avgCurrent) {
        this.avgCurrent = avgCurrent;
    }

    public Double getStddevPopGlucose() {
        return stddevPopGlucose;
    }

    public void setStddevPopGlucose(Double stddevPopGlucose) {
        this.stddevPopGlucose = stddevPopGlucose;
    }

    public Double getStddevPopCurrent() {
        return stddevPopCurrent;
    }

    public void setStddevPopCurrent(Double stddevPopCurrent) {
        this.stddevPopCurrent = stddevPopCurrent;
    }

    public Double getStddevSampGlucose() {
        return stddevSampGlucose;
    }

    public void setStddevSampGlucose(Double stddevSampGlucose) {
        this.stddevSampGlucose = stddevSampGlucose;
    }

    public Double getStddevSampCurrent() {
        return stddevSampCurrent;
    }

    public void setStddevSampCurrent(Double stddevSampCurrent) {
        this.stddevSampCurrent = stddevSampCurrent;
    }
}
