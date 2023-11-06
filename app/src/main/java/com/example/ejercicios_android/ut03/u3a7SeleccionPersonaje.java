package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Layout;

import com.example.ejercicios_android.R;

public class u3a7SeleccionPersonaje extends AppCompatActivity {
    ConstraintLayout layoutPersonaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a7_seleccion_personaje);
        layoutPersonaje = findViewById(R.id.u3a7LayoutPersonaje);
        layoutPersonaje.getChildCount(); //TODO: Loop through views and get all imageviews...

    }
}