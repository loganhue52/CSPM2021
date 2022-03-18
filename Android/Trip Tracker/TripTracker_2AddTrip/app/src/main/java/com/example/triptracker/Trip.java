package com.example.triptracker;

public class Trip {
    private String objectId;
    private String name;
    private String desc;

    //no-arg
    public Trip(){}

    //basic
    public Trip(String objectId,String name,String desc){
        objectId=this.objectId;
        name=this.name;
        desc=this.desc;
    }

    public Trip(String name,String desc){
        name=this.name;
        desc=this.desc;
    }

    //getters and setters
    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


