package com.example.lutemon;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.Adapters.LutemonAdapter;
import com.example.lutemon.container.Storage;
import java.util.ArrayList;

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
        create_btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateLutemonActivity.class);
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
