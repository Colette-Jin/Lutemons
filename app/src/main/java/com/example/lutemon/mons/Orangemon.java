package com.example.lutemon.mons;

public class Orangemon extends Lutemon{
    public Orangemon(String name, String color, int attack, int defence, int health, int maxHealth, int id, int experience) {
        super(name, color, attack, defence, health, maxHealth, id, experience);
    }

    @Override
    public void resetHealthToDefault() {
        this.health = 17;
    }

    @Override
    public void resetAllParametersToDefault() {
        this.health=17;this.attack=8;this.defence=1;this.experience=0;
    }
}