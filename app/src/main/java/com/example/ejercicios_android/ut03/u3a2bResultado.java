package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u3a2bResultado extends AppCompatActivity {

    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a2b_resultado);

        tvResultado = findViewById(R.id.u3a2bTvResultado);
        Bundle info = getIntent().getExtras();
        int resultado = info.getInt("RESULTADO");

        tvResultado.setText(Integer.toString(resultado));

        tvResultado.setScaleX(0);
        tvResultado.setScaleY(0);
        tvResultado.setRotation(0);

        tvResultado.animate().scaleX(1).scaleY(1).rotationBy(360).setInterpolator(new OvershootInterpolator()).setDuration(1000).setListener(null);
    }
}