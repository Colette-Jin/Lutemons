package com.example.lutemon.mons;

public class Greenmon extends Lutemon{
    public Greenmon(String name){
        super(name,"green", 6, 3,  19);
    }

    @Override
    public void resetHealthToDefault() {
        this.health = maxHealth;
    }

    @Override
    public void resetAllParametersToDefault() {
        this.health=maxHealth;
        this.attack=6;
        this.defence=3;
        this.experience=0;
    }
}