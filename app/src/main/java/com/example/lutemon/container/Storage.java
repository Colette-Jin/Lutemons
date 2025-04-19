package com.example.lutemon.container;

import android.content.Context;

import com.example.lutemon.mons.Lutemon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private Map<Lutemon,String> lutemonMap;


    private Storage() {
        this.lutemonMap = new HashMap<>();
    }// lutemons list and current location:Home,battlefield,trainingarea

    public static synchronized Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }//singleton

    public void addLutemon(Lutemon lutemon) {
        lutemonMap.put(lutemon, "Home");
    }//default location: Home


    public List<Lutemon> getLutemons() {
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

    public void saveLutemons(Context context){
        try{
            FileOutputStream fos = context.openFileOutput("lutemons.data",Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lutemonMap);
            oos.close();
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLutemons(Context context){
        try{
            FileInputStream fis = context.openFileInput("lutemons.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lutemonMap = (Map<Lutemon, String>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            lutemonMap = new HashMap<>();
            e.printStackTrace();
        }
    }
}


