package com.example.lutemon;

import com.example.lutemon.container.Storage;
import com.example.lutemon.mons.Lutemon;

public class TrainingField implements Train {
    private Storage storage;

    public void TrainingFieldeld() {
        this.storage = Storage.getInstance();
    }

    @Override
    public void train(Lutemon lutemon) {
        lutemon.addExperience(1);
    }

    public void moveToHome(Lutemon lutemon) {
        lutemon.resetHealthToDefault();//when returning home the lutemons health is set back to the default health
        storage.moveLutemon(lutemon, "home");
    }
}