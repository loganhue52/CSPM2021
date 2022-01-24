package com.example.pokedex;

public class Pokemon {
    //what is needed to create a Pokemon
    private String name;
    private int number;

    //Constructor
    public Pokemon(String name, int number) {
        this.name = name;
        this.number = number;
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
