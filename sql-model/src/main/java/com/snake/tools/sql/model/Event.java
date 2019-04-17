package com.snake.tools.sql.model;

public class Event {

    private Long id;
    private Long patientId;
    private Integer type;
    private Integer mealType;
    private String content;
    private String time;
    private String created;

    @Override
    public String toString() {
        return String.format("{id:%d,patientId:%d,type:%d,mealType:%d,content:%s,time:%s,created:%s}",this.id,this.patientId,this.type,this.mealType,this.content,this.time,this.created);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMealType() {
        return mealType;
    }

    public void setMealType(Integer mealType) {
        this.mealType = mealType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
