package com.example.lutemon;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.Adapters.storageAdapter;
import com.example.lutemon.container.Storage;
import com.example.lutemon.mons.Lutemon;

import java.util.ArrayList;
import java.util.List;

public class TrainingField extends AppCompatActivity implements Train {
    private Storage storage;
    private RecyclerView recyclerTrain;
    private TextView train_log;
    private storageAdapter adapter;
    private List<Lutemon> lutemons_in_training;

    public void TrainingFieldeld() {
        this.storage = Storage.getInstance();
    }


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.training);
        recyclerTrain = findViewById(R.id.recyclerView);
        recyclerTrain.setLayoutManager(new LinearLayoutManager(this));
        train_log = findViewById(R.id.textView2);
        lutemons_in_training = storage.getLutemonsAtLocation("trainingarea");
        if (lutemons_in_training == null) {
            Toast.makeText(this, "select at least 1 Lutemon", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        train_log.setText("");//initialize log
        setupButtonListeners();
        setupRecyclerView();
    }

    private void setupButtonListeners() {
        Button train_b = findViewById(R.id.train);
        Button end_b = findViewById(R.id.reHome);
        train_b.setOnClickListener(v -> {
            for(Lutemon lutemon:lutemons_in_training){
                train(lutemon);
            }
            adapter.updateItems(lutemons_in_training);
        });
        end_b.setOnClickListener(v -> {
            Toast.makeText(this, "Returning", Toast.LENGTH_SHORT).show();
            for(Lutemon lutemon:lutemons_in_training){
                storage.moveLutemon(lutemon,"Home");
            }
            finish();
        });
    }

    private void setupRecyclerView() {
        adapter = new storageAdapter(new ArrayList<>(lutemons_in_training),this);
        recyclerTrain.setAdapter(adapter);
        adapter.updateItems(lutemons_in_training);
    }

    @Override
    public void train(Lutemon lutemon) {
        lutemon.addExperience(1);
        train_log.append("all lutemons' EXP+1\n");
    }
}