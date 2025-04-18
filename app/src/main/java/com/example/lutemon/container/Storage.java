package com.example.lutemon.container;

import com.example.lutemon.mons.Lutemon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private final Map<Lutemon,String> lutemonMap;


    private Storage() {
        // lutemons list and current location:Home,battlefield,trainingarea
        this.lutemonMap = new HashMap<>();
    }
    public static synchronized Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }//singleton

    public void addLutemon(Lutemon lutemon) {
        lutemonMap.put(lutemon, "Home");
        //default location: Home
    }

//    public Lutemon getLutemon(Lutemon lutemon) {
//        return lutemonMap.keySet();
//    }

    public List<Lutemon> listLutemons() {
        return new ArrayList<>(lutemonMap.keySet());
    }// arraylist of lutemons

    public void moveLutemon(Lutemon lutemon,String location) {
        lutemonMap.put(lutemon, location);
    }//move lutemon to target location one by one

    public List<Lutemon> getLutemonsAtLocation(String location){
        //"Home","battlefield","trainingarea"
        List<Lutemon> lutemonList = new ArrayList<>();
        for(Map.Entry<Lutemon,String> entry:lutemonMap.entrySet()){
            if(entry.getValue().equals(location)){
                Lutemon lutemon = entry.getKey();
                lutemonList.add(lutemon);
            }
        }
        return lutemonList;
    }//list of lutemons at certain location

    public void removeLutemon(Lutemon lutemon) {
        lutemonMap.remove(lutemon);
    }

}


