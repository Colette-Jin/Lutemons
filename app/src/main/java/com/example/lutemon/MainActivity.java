package com.example.lutemon;

import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

public class MainActivity extends AppCompatActivity {
    private static final String POKEMON_URL = "https://pokeapi.co/api/v2/pokemon/ditto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home);

    }
}
