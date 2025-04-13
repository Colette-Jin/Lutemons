package com.example.lutemon.container;

import com.example.lutemon.mons.Lutemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private Map<Integer, Lutemon> lutemonMap;

    private Storage() {
        this.lutemonMap = new HashMap<>();
    }
    public static synchronized Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemonMap.put(lutemon.getId(), lutemon);
    }

    public Lutemon getLutemon(int id) {
        return lutemonMap.get(id);
    }

    public List<Lutemon> listLutemons() {
        return new ArrayList<>(lutemonMap.values());
    }

    public void moveLutemon(Lutemon lutemon, Storage targetStorage) {
        lutemonMap.remove(lutemon.getId());
        targetStorage.addLutemon(lutemon);
    }

    public void removeLutemon(int id) {
        lutemonMap.remove(id);
    }
}

}
