package com.example.triptracker;

public class Trip {
    private String objectId;
    private String name;
    private String desc;

    //no-arg
    public Trip(){}

    //basic


    public Trip(String objectId, String name, String desc) {
        this.objectId = objectId;
        this.name = name;
        this.desc = desc;
    }

    public Trip(String name, String desc) {
        this.name = name;
        this.desc = desc;
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

    @Override
    public String toString() {
        return "Trip{" +
                "objectId='" + objectId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}


