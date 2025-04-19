package com.example.lutemon.mons;

import java.io.Serializable;

public abstract class Lutemon implements Serializable {
    protected String name;
    protected String color;
    protected int attack;
    protected int defence;
    public int health;
    protected int maxHealth;
    protected int id;
    protected int experience;
    static int idCount;
    private int imageID;

    public Lutemon(String name,String color,int attack,int defence,int maxHealth,int imageID){
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.id = ++idCount;
        this.experience = 0;
        this.imageID = imageID;
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
    public  int getImageID(){return imageID;}
    public static int getNumberOfCreatedLutemons(){
        return idCount;
    }

    public abstract void resetHealthToDefault();
    public abstract void resetAllParametersToDefault();

    public void defense(int attack){
        health = health-attack;
    }

    public void attack(Lutemon lutemon){
        int base_attack = attack;
        int exp = experience;
        int damage = (int) (base_attack + Math.random()*2.5 +exp);
        //Randomness in battles
        lutemon.defense(damage);
    }

    public void addExperience(int additionalExperiencePoints){
        this.experience+=additionalExperiencePoints;
    }// called when lutemons are trained or win a battle

    public String getDetails(){
        int atk = this.getAttack();
        int def = this.getDefence();
        int health = this.getHealth();
        int maxhealth = this.getMaxHealth();
        int exp = this.getExperience();
        return "ATK: "+atk+" DEF: "+def+" HP: "+health+"/"+maxhealth+" EXP: "+exp;
    }// called in recyclerView
}
