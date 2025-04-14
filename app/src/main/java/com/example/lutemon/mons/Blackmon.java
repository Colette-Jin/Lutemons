package com.example.lutemon.mons;

public class Blackmon extends Lutemon{
    public Blackmon(String name){
        super(name,"black", 9, 0, 16);
    }

    @Override
    public void resetHealthToDefault() {
        this.health=maxHealth;
    }

    @Override
    public void resetAllParametersToDefault() {
        this.health=maxHealth;
        this.attack=9;
        this.defence=0;
        this.experience=0;
    }
}