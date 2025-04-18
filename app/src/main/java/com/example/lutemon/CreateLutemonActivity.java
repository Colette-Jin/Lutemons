package com.example.lutemon;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CreateLutemonActivity extends AppCompatActivity {

    private EditText nameInput;
    private RadioGroup colorGroup;
    private Home home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_lutemon);

        nameInput = findViewById(R.id.name_input);
        colorGroup = findViewById(R.id.color_group);
        Button createButton = findViewById(R.id.create_button);

        home = new Home();

        createButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            int selectedId = colorGroup.getCheckedRadioButtonId();

            if (name.isEmpty() || selectedId == -1) {
                Toast.makeText(this, "Please enter a name and select a color", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedColor = findViewById(selectedId);
            String color = selectedColor.getText().toString();

            home.Create_lutemon(color, name);

            Toast.makeText(this, "Lutemon created!", Toast.LENGTH_SHORT).show();

            finish(); // Go back to MainActivity (home screen)
        });
    }
}
