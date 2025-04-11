package com.example.lutemon;

public class Home implements Create {
    private Storage storage;

    public Home() {
        this.storage = Storage.getInstance();
    }

    @Override
    public Lutemon Create_lutemon(String color, String name) {
        switch (color) {
            case "white":
                Lutemon lutemon = Whitemon(String color, String name);
            case "green":
                Lutemon lutemon = Greenmon(String color, String name);
            case "pink":
                Lutemon lutemon = Pinkmon(String color, String name);
            case "orange":
                Lutemon lutemon = Orangemon(String color, String name);
            case "black":
                Lutemon lutemon = Blackmon(String color, String name);
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