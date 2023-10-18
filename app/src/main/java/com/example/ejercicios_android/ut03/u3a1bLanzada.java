package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicios_android.R;

public class u3a1bLanzada extends AppCompatActivity {

    TextView saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a1b_lanzada);

        saludo = findViewById(R.id.u3a1bSaludo);

        Bundle info = getIntent().getExtras();
        String sInfo = info.getString("INFO_NOMBRE");

        saludo.setText("Hola, "+sInfo);
    }
}