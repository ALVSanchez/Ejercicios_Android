package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
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

        View.OnClickListener listener = v -> {
            Intent resultIntent = new Intent();
            try {
                int id_imagen = (int)v.getTag();
                resultIntent.putExtra(u3a7MetalSlug.CLAVE_IMAGEN, id_imagen);
                setResult(Activity.RESULT_OK, resultIntent);
            } catch(Exception e){
                setResult(Activity.RESULT_CANCELED, resultIntent);
            }
            finish();
        };


        }


}