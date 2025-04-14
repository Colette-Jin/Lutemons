package com.example.lutemon.mons;

public class Orangemon extends Lutemon{
    public Orangemon(String name) {
        super(name, "orange", 8, 1,  17);
    }

    @Override
    public void resetHealthToDefault() {
        this.health = maxHealth;
    }

    @Override
    public void resetAllParametersToDefault() {
        this.health=maxHealth;
        this.attack=8;
        this.defence=1;
        this.experience=0;
    }
}