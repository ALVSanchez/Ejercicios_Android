package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ejercicios_android.R;

public class u3a7SeleccionArma extends AppCompatActivity {

    ImageView armaH;
    ImageView arma2H;
    ImageView armaL;
    ImageView armaR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a7_seleccion_arma);

        Integer jugador = getIntent().getIntExtra(u3a7MetalSlug.CLAVE_JUGADOR,0);


        armaH = findViewById(R.id.u3a7ivArmaH);
        arma2H = findViewById(R.id.u3a7ivArma2h);
        armaL = findViewById(R.id.u3a7ivArmaL);
        armaR = findViewById(R.id.u3a7ivArmaR);

        armaH.setTag(R.drawable.metal_slug_arma_h);
        arma2H.setTag(R.drawable.metal_slug_arma_2h);
        armaL.setTag(R.drawable.metal_slug_arma_l);
        armaR.setTag(R.drawable.metal_slug_arma_r);

        View.OnClickListener listener = v -> {
            Intent resultIntent = new Intent();
            int id_imagen = (int)v.getTag();
            resultIntent.putExtra(u3a7MetalSlug.CLAVE_IMAGEN, id_imagen);
            resultIntent.putExtra(u3a7MetalSlug.CLAVE_JUGADOR, jugador);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        };

        armaH.setOnClickListener(listener);
        arma2H.setOnClickListener(listener);
        armaL.setOnClickListener(listener);
        armaR.setOnClickListener(listener);


    }
}