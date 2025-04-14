package com.example.lutemon;

import com.example.lutemon.container.Storage;
import com.example.lutemon.mons.Blackmon;
import com.example.lutemon.mons.Greenmon;
import com.example.lutemon.mons.Lutemon;
import com.example.lutemon.mons.Orangemon;
import com.example.lutemon.mons.Pinkmon;
import com.example.lutemon.mons.Whitemon;

public class Home implements Create {
    private Storage storage;

    public Home() {
        this.storage = Storage.getInstance();
    }

    @Override
    public Lutemon Create_lutemon(String color, String name) {
        Lutemon lutemon = new Lutemon() {
            @Override
            public void resetHealthToDefault() {

            }

            @Override
            public void resetAllParametersToDefault() {

            }
        }
        switch (color) {
            case "white":
                Lutemon lutemon = new Whitemon(String color, String name);
            case "green":
                Lutemon lutemon = new Greenmon(String color, String name);
            case "pink":
                Lutemon lutemon = new Pinkmon(String color, String name);
            case "orange":
                Lutemon lutemon = new Orangemon(String color, String name);
            case "black":
                Lutemon lutemon = new Blackmon(String color, String name);
        }
        storage.addLutemon(lutemon);
        return lutemon;
    }

    public void moveToTrainArea(Lutemon lutemon, String trainArea) {
        storage.moveLutemon(lutemon, "trainArea");
    }

    public void moveToBattleField(Lutemon lutemon, String battleField) {
        storage.moveLutemon(lutemon, "battleField");
    }
}