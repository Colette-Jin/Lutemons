package com.example.lutemon.mons;

public class Greenmon extends Lutemon{
    public Greenmon(String name, String color, int attack, int defence, int health, int maxHealth, int id,int experience){
        super(name,"green", 6, 3, health, 19, id,0);
    }

    @Override
    public void resetHealthToDefault() {
        this.health = 19;
    }

    @Override
    public void resetAllParametersToDefault() {
        this.health=19;this.attack=6;this.defence=3;this.experience=0;
    }
}