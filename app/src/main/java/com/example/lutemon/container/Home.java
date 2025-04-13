package com.example.lutemon.container;

import com.example.lutemon.Create;
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

    public void moveToTrainArea(Lutemon lutemon, TrainArea trainArea) {
        storage.moveLutemon(lutemon, trainArea);
    }

    public void moveToBattleField(Lutemon lutemon, BattleField battleField) {
        storage.moveLutemon(lutemon, battleField);
    }
}