package com.example.lutemon;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.Adapters.LutemonAdapter;
import com.example.lutemon.container.Storage;
import com.example.lutemon.mons.Lutemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LutemonAdapter adapter;
    private Storage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.home_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new com.example.lutemon.Adapters.LutemonAdapter(new ArrayList<>(storage.getLutemons()));
        recyclerView.setAdapter(adapter);


        Button create_btn = findViewById(R.id.create_btn);
        Button train_btn = findViewById(R.id.train_btn);
        Button battle_btn= findViewById(R.id.battle_btn);
        create_btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateLutemonActivity.class);
            startActivity(intent);
        });
        train_btn.setOnClickListener(v -> {
            List<Lutemon> selectedmons = adapter.getSelectedmons();
            if(selectedmons.isEmpty()){
                Toast.makeText(this, "Please select at least one Lutemon to train!", Toast.LENGTH_SHORT).show();
                return;
            }

            for(Lutemon lutemon:selectedmons){
                storage.moveLutemon(lutemon,"trainingarea");
            }
            Intent intent = new Intent(MainActivity.this, TrainingField.class);
            startActivity(intent);
        });
        battle_btn.setOnClickListener(v -> {
            List<Lutemon> selectedmons = adapter.getSelectedmons();
            if (selectedmons.size() != 2) {
                Toast.makeText(this, "Please select exactly 2 Lutemons to battle!", Toast.LENGTH_SHORT).show();
                return;
            }
            for(Lutemon lutemon:selectedmons){
                storage.moveLutemon(lutemon,"battlefield");
            }
            Intent intent = new Intent(MainActivity.this, BattleField.class);
            startActivity(intent);
        });
    }

    // for returning from CreateLutemonActivity
    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateList(new ArrayList<>(storage.getLutemons()));
    }
}
