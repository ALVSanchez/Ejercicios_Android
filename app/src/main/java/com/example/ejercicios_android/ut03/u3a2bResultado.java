package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u3a2bResultado extends AppCompatActivity {

    TextView tvResultado;
    TextView tvOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a2b_resultado);

        tvResultado = findViewById(R.id.u3a2bTvResultado);
        tvOperacion = findViewById(R.id.u3a2tvOperacion);
        Bundle info = getIntent().getExtras();
        int resultado = info.getInt(u3a2aCalculadora.CLAVE_RESULTADO);
        int operando1 = info.getInt(u3a2aCalculadora.CLAVE_OPERANDO1);
        int operacion = info.getInt(u3a2aCalculadora.CLAVE_OPERACION);
        int operando2 = info.getInt(u3a2aCalculadora.CLAVE_OPERANDO2);



        tvResultado.setText(Integer.toString(resultado));
        tvOperacion.setText(String.format("%d %s %d",operando1, operacion, operando2));

        tvResultado.setScaleX(0);
        tvResultado.setScaleY(0);
        tvResultado.setRotation(0);
        final long DURACION = 1000;
        tvResultado.animate().scaleX(1).scaleY(1).rotationBy(360).setInterpolator(new OvershootInterpolator()).setDuration(DURACION).setListener(null);
    }
}