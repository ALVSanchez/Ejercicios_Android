package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u3a5Fibonacci extends AppCompatActivity {

    TextView tvAnterior;
    TextView tvActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a5_fibonacci);

        tvAnterior = findViewById(R.id.u3a5tvAnterior);
        tvActual = findViewById(R.id.u3a5tvActual);




    }
}