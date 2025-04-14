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
        Lutemon lutemon;

        switch (color.toLowerCase()) {
            case "white":
                lutemon = new Whitemon(name);
                break;
            case "green":
                lutemon = new Greenmon(name);
                break;
            case "pink":
                lutemon = new Pinkmon(name);
                break;
            case "orange":
                lutemon = new Orangemon(name);
                break;
            case "black":
                lutemon = new Blackmon(name);
                break;
            default:
                throw new IllegalStateException("Unknown color: "+color);
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