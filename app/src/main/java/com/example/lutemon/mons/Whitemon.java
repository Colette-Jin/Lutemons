package com.example.lutemon.mons;

public class Whitemon extends Lutemon{
    public Whitemon(String name, String color, int attack, int defence, int health, int maxHealth, int id,int experience){
        super(name,"white", 5, 4, health, 20, id,0);
    }

    @Override
    public void resetHealthToDefault() {
        this.health = 20;
    }

    @Override
    public void resetAllParametersToDefault() {
        this.health=20;this.attack=5;this.defence=4;this.experience=0;
    }
}