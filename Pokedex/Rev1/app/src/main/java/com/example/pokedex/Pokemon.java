package com.example.pokedex;

public class Pokemon {
    //what is needed to create a Pokemon
    private String name;
    private String url;
//    private String t1;
//    private String t2;
    private int number;

    //Constructor

    public Pokemon(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Pokemon(String name, String url){

        this.name = name;
        this.url = url;
    }


    public Pokemon(String name, String url, String t1, String t2) {
        this.name = name;
        this.url = url;
//        this.t1 = t1;
//        this.t2 = t2;
    }

//    public String getT1() {
//        return t1;
//    }
//
//    public void setT1(String t1) {
//        this.t1 = t1;
//    }
//
//    public String getT2() {
//        return t2;
//    }
//
//    public void setT2(String t2) {
//        this.t2 = t2;
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
