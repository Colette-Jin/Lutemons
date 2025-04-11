package com.example.lutemon;

public class Arena implements Battle{
    private Storage storage;

    public Arena() {
        this.storage = Storage.getInstance();
    }
//cooent
    @Override
    public Lutemon fight(Lutemon lutemon1, Lutemon lutemon2) {
        while (lutemon1.health>0 & lutemon2.health>0){

        }
    }
}
