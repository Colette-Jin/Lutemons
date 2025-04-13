package com.example.lutemon.mons;

public class Blackmon extends Lutemon{
    public Blackmon(String name, String color, int attack, int defence, int health, int maxHealth, int id,int experience){
        super(name,"black", 9, 0, health, 16, id,0);
    }

    @Override
    public void resetHealthToDefault() {
        this.health=16;
    }

    @Override
    public void resetAllParametersToDefault() {
        this.health=16;this.attack=9;this.defence=0;this.experience=0;
    }
}