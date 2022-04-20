package com.example.triptracker;

public class Trip implements IntentData{
    private String objectId;
    private String name;
    private String desc;
    private boolean shared;
    private String UID;

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

    public Trip(String objectId, String name, String desc, boolean shared) {
        this.objectId = objectId;
        this.name = name;
        this.desc = desc;
        this.shared = shared;
    }

    public Trip(String objectId, String name, String desc, boolean shared, String UID) {
        this.objectId = objectId;
        this.name = name;
        this.desc = desc;
        this.shared = shared;
        this.UID = UID;
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

    public boolean isShared() {
        return shared;
    }

    public String getUID() {
        return UID;
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

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "objectId='" + objectId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", shared=" + shared +
                ", UID='" + UID + '\'' +
                '}';
    }

    public int compareTo(Object o){
        return name.compareTo(((Trip) o).name);
    }
}


