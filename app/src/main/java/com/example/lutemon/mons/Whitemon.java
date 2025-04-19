package com.example.lutemon.mons;

import com.example.lutemon.R;

public class Whitemon extends Lutemon{
    public Whitemon(String name){
        super(name,"white", 5, 4, 20, R.drawable.white);
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