package com.example.lutemon.mons;

public class Whitemon extends Lutemon{
    public Whitemon(String name){
        super(name,"white", 5, 4, 20);
    }

    @Override
    public void resetHealthToDefault() {
        this.health = maxHealth;
    }

    @Override
    public void resetAllParametersToDefault() {
        this.health=maxHealth;
        this.attack=5;
        this.defence=4;
        this.experience=0;
    }
}