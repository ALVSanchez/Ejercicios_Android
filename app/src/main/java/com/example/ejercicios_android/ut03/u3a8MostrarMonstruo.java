package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u3a8MostrarMonstruo extends AppCompatActivity {
    Monstruo monstruo;

    TextView tvMonstruo;
    TextView tvMostrarNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a8_mostrar_monstruo);
        monstruo = (Monstruo)getIntent().getSerializableExtra(u3a8CrearMonstruo.CLAVE_MONSTRUO);

        tvMostrarNombre = findViewById(R.id.u3a8tvMostrarNombre);

        tvMonstruo = findViewById(R.id.u3a8tvMonstruo);
        tvMonstruo.setTextColor(monstruo.color);
        tvMonstruo.setText(monstruo.toString());

        tvMostrarNombre.setText(monstruo.nombre);

    }
}