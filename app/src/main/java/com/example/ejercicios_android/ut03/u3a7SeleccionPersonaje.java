package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;

import com.example.ejercicios_android.R;

public class u3a7SeleccionPersonaje extends AppCompatActivity {

    ImageView ivC1;
    ImageView ivC2;
    ImageView ivC3;
    ImageView ivC4;

    Integer jugador;
    Integer seleccionP1;
    Integer seleccionP2;

    private void inicializarImagen(ImageView iv, View.OnClickListener listener){
        int tag = (int)iv.getTag();
        if(tag == seleccionP1 || tag == seleccionP2){
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0.1f);
            iv.setColorFilter(new ColorMatrixColorFilter(matrix));
        } else {
            iv.setOnClickListener(listener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a7_seleccion_personaje);

        ivC1 = findViewById(R.id.u3a7ivC1);
        ivC2 = findViewById(R.id.u3a7ivC2);
        ivC3 = findViewById(R.id.u3a7ivC3);
        ivC4 = findViewById(R.id.u3a7ivC4);

        ivC1.setTag(R.drawable.metal_slug_c1);
        ivC1.setImageResource((int)ivC1.getTag());

        ivC2.setTag(R.drawable.metal_slug_c2);
        ivC2.setImageResource((int)ivC2.getTag());

        ivC3.setTag(R.drawable.metal_slug_c3);
        ivC3.setImageResource((int)ivC3.getTag());

        ivC4.setTag(R.drawable.metal_slug_c4);
        ivC4.setImageResource((int)ivC4.getTag());
        Intent intent = getIntent();

        jugador = intent.getIntExtra(u3a7MetalSlug.CLAVE_JUGADOR,1);
        seleccionP1 = intent.getIntExtra(u3a7MetalSlug.CLAVE_SELECCIONP1,R.drawable.metal_slug_c_placeholder);
        seleccionP2 = intent.getIntExtra(u3a7MetalSlug.CLAVE_SELECCIONP2,R.drawable.metal_slug_c_placeholder);



        View.OnClickListener listener = v -> {
            Intent resultIntent = new Intent();
            int id_imagen = (int)v.getTag();
            resultIntent.putExtra(u3a7MetalSlug.CLAVE_IMAGEN, id_imagen);
            resultIntent.putExtra(u3a7MetalSlug.CLAVE_JUGADOR, jugador);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        };

        inicializarImagen(ivC1,listener);
        inicializarImagen(ivC2,listener);
        inicializarImagen(ivC3,listener);
        inicializarImagen(ivC4,listener);


    }
}