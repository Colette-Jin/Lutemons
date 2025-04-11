package com.example.lutemon;

public class TrainingField implements Train{
    private Storage storage;

    public void TrainingFieldeld() {
        this.storage = Storage.getInstance();
    }

    @Override
    public void train(Lutemon lutemon) {
        lutemon.addExperience(1);
    }

    public void moveToHome(Lutemon lutemon, Home home) {
        lutemon.resetHealthToDefault();//when returnong home the lutmons health is set back to the default health
        storage.moveLutemon(lutemon, home);
    }
}