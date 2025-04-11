package com.example.lutemon;

public class BattleField implements Battle{
    private Storage storage;

    public void BattleFieldeld() {
        this.storage = Storage.getInstance();
    }

    public void moveToHome(Lutemon lutemon) {
        lutemon.resetHealthToDefault();//when returning home the lutmons health is set back to the default health
        storage.moveLutemon(Lutemon lutemon,Home home);
    }


    @Override
    public void fight(Lutemon A, Lutemon B) {
        turn = 1
        while true {
            if rem(turn / 2) != 0 {//if the turn is odd A attacks
                Lutemon atacker = A;
                Lutemon defender = B;
            }else{//if the turn is even B attacks
                Lutemon atacker = B;
                Lutemon defender = A;
            }
            turn +=;// turn increases by one every loop iteration after attacker and defender are set

            attacker.attack(defender);//attacker attacks and defender defends

            // print lutemons stats here ?? How if not in the terminal? I dont know how else to print...
            System.out.println(A.getName()+" has "+ A.getHealth()+" healthpoints");
            System.out.println(B.getName()+" has "+ B.getHealth()+" healthpoints");

            if defender.getHealth() < 0 {
                System.out.println(defender.getName()+" died. \n"+attacker.getName()+" wins.");

                //return attacker home with new experience
                attacker.addExperice(1);
                BattleField.moveToHome(attacker);

                //return defender home with its stats put back to the default
                defender.resetAllParametersToDefault();
                BattleField.moveToHome(defender);

                break;//end the loop
            }else{
                System.out.println(defender.getName()+"managed to excape death.");
                // loop continues
            }
        }
    }
}