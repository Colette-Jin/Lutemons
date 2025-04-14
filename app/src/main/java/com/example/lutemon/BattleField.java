package com.example.lutemon;

import com.example.lutemon.container.Storage;
import com.example.lutemon.mons.Lutemon;

public class BattleField implements Battle {
    private final Storage storage;

    public BattleField() {
        this.storage = Storage.getInstance();
    }

    public void moveToHome(Lutemon lutemon) {
        lutemon.resetHealthToDefault();//when returning home the lutemon's health is set back to the default health
        storage.moveLutemon(lutemon,"Home");
    }


    @Override
    public void fight(Lutemon A, Lutemon B) {
        int turn = 1;
        Lutemon attacker;
        Lutemon defender;

        while (true) {
            if (turn % 2 != 0) {//if the turn is odd A attacks
                attacker = A;
                defender = B;
            }else{//if the turn is even B attacks
                attacker = B;
                defender = A;
            }
            turn ++;// turn increases by one every loop iteration after attacker and defender are set

            attacker.attack(defender);//attacker attacks and defender defends

            // print lutemons stats here ?? How if not in the terminal? I dont know how else to print...
            System.out.println(A.getName()+" has "+ A.getHealth()+" healthpoints");
            System.out.println(B.getName()+" has "+ B.getHealth()+" healthpoints");

            if (defender.getHealth() < 0) {
                System.out.println(defender.getName()+" died. \n"+attacker.getName()+" wins.");

                //return attacker home with new experience
                attacker.addExperience(1);
                this.moveToHome(attacker);

                //return defender home with its stats put back to the default
                defender.resetAllParametersToDefault();
                this.moveToHome(defender);
                break;//end the loop
            }else{
                System.out.println(defender.getName()+"managed to escape death.");
                // loop continues
            }
        }
    }
}