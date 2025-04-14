package com.example.lutemon.mons;

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

    public Lutemon(String name,String color,int attack,int defence,int maxHealth){
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.maxHealth = maxHealth;
        this.id = ++idCount;
        this.experience = 0;
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
    public int getExperience(){return experience;}

    public String getColor() {
        return color;
    }
    public static int getNumberOfCreatedLutemons(){
        return idCount;
    }

    public abstract void resetHealthToDefault();
//        switch(color){
//            case "white":this.health=20;
//            case "green":this.health=19;
//            case "pink":this.health=18;
//            case "orange":this.health=17;
//            case "black":this.health=16;
//        }


    public abstract void resetAllParametersToDefault();
//        switch(color){
//            case "white":this.health=20;this.attack=5;this.defence=4;this.experience=0;
//            case "green":this.health=19;this.attack=6;this.defence=3;this.experience=0;
//            case "pink":this.health=18;this.attack=7;this.defence=2;this.experience=0;
//            case "orange":this.health=17;this.attack=8;this.defence=1;this.experience=0;
//            case "black":this.health=16;this.attack=9;this.defence=0;this.experience=0;

    public void defense(int attack){
        health = health-attack;
    }

    public void attack(Lutemon lutemon){
        int current_attack = attack;
        lutemon.defense(current_attack);
    }

    public void addExperience(int additionalExperiencePoints){
        this.experience+=additionalExperiencePoints;

        // When experience increases, attack power also increases
        this.attack+=additionalExperiencePoints;
    }
    public String getDetails(){
        int atk = this.getAttack();
        int def = this.getDefence();
        int health = this.getHealth();
        int maxhealth = this.getMaxHealth();
        int exp = this.getExperience();
        return "ATK: "+atk+" DEF: "+def+" HP: "+health+"/"+maxhealth+" EXP: "+exp;
    }
}
