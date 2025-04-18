package com.example.lutemon;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.Adapters.storageAdapter;
import com.example.lutemon.container.Storage;
import com.example.lutemon.mons.Lutemon;

import java.util.ArrayList;
import java.util.List;

public class BattleField extends AppCompatActivity implements Battle {
    private final Storage storage;
    int turn;
    private RecyclerView recyclerArena;
    private TextView battle_detail;
    private storageAdapter adapter;
    private List<Lutemon> lutemons_in_arena;
    private Lutemon lutemon1;
    private Lutemon lutemon2;
    private Button next_turn;
    public BattleField() {
        this.storage = Storage.getInstance();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.battle);
        recyclerArena = findViewById(R.id.recycler_arena);

        recyclerArena.setLayoutManager(new LinearLayoutManager(this));
        battle_detail = findViewById(R.id.textView);
        lutemons_in_arena = storage.getLutemonsAtLocation("battlefield");
        if (lutemons_in_arena == null || lutemons_in_arena.size() != 2) {
            Toast.makeText(this, "please select 2 Lutemons", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        lutemon1 = lutemons_in_arena.get(0);
        lutemon2 = lutemons_in_arena.get(1);
        setupButtonListeners();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        adapter = new storageAdapter(new ArrayList<>(),this);
        recyclerArena.setAdapter(adapter);
    }

    private void setupButtonListeners() {
        Button start_b = findViewById(R.id.button_start);
        next_turn = findViewById(R.id.turn_button);
        Button end_b = findViewById(R.id.button_end);

        start_b.setOnClickListener(v -> {
            Toast.makeText(this, "Show time!", Toast.LENGTH_SHORT).show();
            turn = 1;
            battle_detail.setText("");//initialize battle log
            next_turn.setEnabled(true);
            adapter.updateItems(lutemons_in_arena);
        });

        next_turn.setOnClickListener(v -> {
            Toast.makeText(this, "next turn", Toast.LENGTH_SHORT).show();
            fight();
        });

        end_b.setOnClickListener(v -> {
            Toast.makeText(this, "Returning", Toast.LENGTH_SHORT).show();
            moveToHome(lutemon1);
            moveToHome(lutemon2);
            finish();
        });
        next_turn.setEnabled(false);
    }

    public void moveToHome(Lutemon lutemon) {
        lutemon.resetHealthToDefault();//when returning home the lutemon's health is set back to the default health
        storage.moveLutemon(lutemon,"Home");
    }


    @Override
    public void fight() {//turn based
        Lutemon attacker;
        Lutemon defender;

        if (lutemon1.getHealth() <= 0 || lutemon2.getHealth() <= 0) {
            next_turn.setEnabled(false);
            battle_detail.append("Battle is over.\n");
            return;
        }

//        while (true) {
        if (turn % 2 != 0) {//if the turn is odd A attacks
            attacker = lutemon1;
            defender = lutemon2;
        } else {//if the turn is even B attacks
            attacker = lutemon2;
            defender = lutemon1;
        }
        //Randomness in battles:Lutemon.attack
        attacker.attack(defender);//attacker attacks and defender defends
        // print lutemons stats here ?? How if not in the terminal? I dont know how else to print...
        //A.getName()+" has "+ A.getHealth()+" healthpoints"
        //B.getName()+" has "+ B.getHealth()+" healthpoints"
        battle_detail.append(attacker.getName() + " attacks " + defender.getName() + "\n");
        battle_detail.append(defender.getName() + " has " + defender.getHealth() + " HP left.\n\n");
        adapter.updateItems(lutemons_in_arena);//update data after each attack

        if (defender.getHealth() <= 0) {
            //System.out.println(defender.getName()+" died. \n"+attacker.getName()+" wins.");
            battle_detail.append(defender.getName() + "died.\n");
            battle_detail.append(attacker.getName() + "wins.\n");
            //return attacker home with new experience
            attacker.addExperience(1);
            this.moveToHome(attacker);

            //return defender home with its stats put back to the default
            defender.resetAllParametersToDefault();
            this.moveToHome(defender);
        }else{
            //System.out.println(defender.getName()+"managed to escape death.");
            battle_detail.append(defender.getName()+"managed to escape death.\n");
        }
        turn++;// turn increases by one every loop iteration after attacker and defender are set
    }
}