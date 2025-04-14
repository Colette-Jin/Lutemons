package com.example.lutemon.mons;

public class Pinkmon extends Lutemon{
    public Pinkmon(String name){
        super(name,"pink", 7, 2,  18);
    }

    @Override
    public void resetHealthToDefault() {
        this.health = 18;
    }

    @Override
    public void resetAllParametersToDefault() {
        this.health=18;this.attack=7;this.defence=2;this.experience=0;
    }
}