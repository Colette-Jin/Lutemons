package com.example.lutemon;

public abstract class Lutemon {
    protected String name;
    protected String color;
    protected int attack;
    protected int defence;
    public int health;
    protected int maxHealth;
    protected int id;
    protected int experience;
    static int idCount;

    public Lutemon(String name,String color,int attack,int defence,int health,int maxHealth,int id,int experience){
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.experience = experience;
    }

    public String getName(){
        return name;
    }
    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getId() {
        return id;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() { return health; }

    public String getColor() {
        return color;
    }
    public static int getNumberOfCreatedLutemons(){
        return idCount;
    }

    public void resetHealthToDefault(){
        switch(color){
            case "white":this.health=20;
            case "green":this.health=19;
            case "pink":this.health=18;
            case "orange":this.health=17;
            case "black":this.health=16;
        }
    }

    public void resetAllParametersToDefault(){
        switch(color){
            case "white":this.health=20;this.attack=5;this.defense=4;this.experience=0;
            case "green":this.health=19;this.attack=6;this.defense=3;this.experience=0;
            case "pink":this.health=18;this.attack=7;this.defense=2;this.experience=0;
            case "orange":this.health=17;this.attack=8;this.defense=1;this.experience=0;
            case "black":this.health=16;this.attack=9;this.defense=0;this.experience=0;
        }
    }

    public void defense(int attack){
        health = health-attack;
    }
    public void attack(Lutemon lutemon){
        int current_attack = attack;
        lutemon.defense(current_attack);
    }

    public void addExperience(int additionalExperiencePoints){
        this experice+=additionalExperiencePoints;

        // When experience increases, attack power also increases
        this attack+=additionalExperiencePoints;
    }
}
