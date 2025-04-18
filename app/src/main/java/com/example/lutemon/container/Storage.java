package com.example.lutemon.container;

import com.example.lutemon.mons.Lutemon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private final Map<Integer, Lutemon> lutemonMap;
    private final Map<Lutemon,String> mons_Location;

    private Storage() {
        this.mons_Location = new HashMap<>();
        // lutemons' current location:Home,battlefield,trainingarea
        this.lutemonMap = new HashMap<>();
        // lutemons list
    }
    public static synchronized Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }//singleton

    public void addLutemon(Lutemon lutemon) {
        lutemonMap.put(lutemon.getId(), lutemon);
        mons_Location.put(lutemon, "Home");
        //default location: Home
    }

    public Lutemon getLutemon(Lutemon lutemon) {
        return lutemonMap.get(lutemon.getId());
    }

    public List<Lutemon> getLutemons() {
        return new ArrayList<>(lutemonMap.values());
    }// arraylist of lutemons

    public void moveLutemon(Lutemon lutemon,String location) {
        mons_Location.put(lutemon, location);
    }//move lutemon to target location one by one

    public List<Lutemon> getLutemonsAtLocation(String location){
        List<Lutemon> lutemonList = new ArrayList<>();
        for(Map.Entry<Lutemon,String> entry:mons_Location.entrySet()){
            if(entry.getValue().equals(location)){
                Lutemon lutemon = entry.getKey();
                lutemonList.add(lutemon);
            }
        }
        return lutemonList;
    }//list of lutemons at some location

    public void removeLutemon(Lutemon lutemon) {
        lutemonMap.remove(lutemon.getId());
    }
}


