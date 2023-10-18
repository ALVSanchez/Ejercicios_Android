package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejercicios_android.R;

public class u3a1aLanza extends AppCompatActivity {

    Button btLanzar;
    EditText etLanzar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a1a_lanza);

        btLanzar = findViewById(R.id.u3a1aBtLanzar);
        etLanzar = findViewById(R.id.u3a1aEtLanzar);

        btLanzar.setOnClickListener(view -> {
            Intent i = new Intent(this, u3a1bLanzada.class);
            i.putExtra("INFO_NOMBRE",etLanzar.getText().toString());
            startActivity(i);
        });
    }
}