package com.example.ejercicios_android.ut03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ejercicios_android.R;

public class u3a7MetalSlug extends AppCompatActivity {


    public static final String CLAVE_JUGADOR = "JUGADOR";
    public static final String CLAVE_SELECCIONP1 = "SELECCIONP1";
    public static final String CLAVE_SELECCIONP2 = "SELECCIONP2";
    ImageView ivP1;
    int seleccionP1 = R.drawable.metal_slug_c_placeholder;
    ImageView ivP2;
    int seleccionP2 = R.drawable.metal_slug_c_placeholder;

    ImageView ivArmaP1;

    ImageView ivArmaP2;

    public static final String CLAVE_IMAGEN = "IMAGEN";

    ActivityResultLauncher<Intent> lanzadorJugador = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), (result)->{
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    int jugador = data.getIntExtra(CLAVE_JUGADOR,1);
                    ImageView imagenJugador;
                    int seleccion = data.getIntExtra(CLAVE_IMAGEN, R.drawable.metal_slug_c_placeholder);
                    if(jugador == 1){
                        imagenJugador = ivP1;
                        seleccionP1 = seleccion;
                    } else {
                        imagenJugador = ivP2;
                        seleccionP2 = seleccion;
                    }
                    imagenJugador.setImageResource(seleccion);
                } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                    // Selección de personaje cancelada
                }
            }
    );

    ActivityResultLauncher<Intent> lanzadorArma = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), (result)->{
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    int jugador = data.getIntExtra(CLAVE_JUGADOR,1);
                    ImageView imagenArma;
                    int seleccion = data.getIntExtra(CLAVE_IMAGEN, R.drawable.metal_slug_c_placeholder);
                    if(jugador == 1){
                        imagenArma = ivArmaP1;
                        seleccionP1 = seleccion;
                    } else {
                        imagenArma = ivArmaP2;
                        seleccionP2 = seleccion;
                    }
                    imagenArma.setImageResource(seleccion);
                } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                    // Selección de arma cancelada
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a7_metal_slug);

        ivP1 = findViewById(R.id.u3a7ivP1);
        ivP2 = findViewById(R.id.u3a7ivP2);

        ivArmaP1 = findViewById(R.id.u3a7ivArmaP1);
        ivArmaP2 = findViewById(R.id.u3a7ivArmaP2);

        View.OnClickListener jugadorListener = v -> {
            int id = v.getId();
            Intent intent = new Intent(u3a7MetalSlug.this, u3a7SeleccionPersonaje.class);
            ImageView imagen = (ImageView)v;
            if(id == R.id.u3a7ivP1){
                intent.putExtra(CLAVE_JUGADOR,1);
            } else {
                intent.putExtra(CLAVE_JUGADOR,2);
            }
            intent.putExtra(CLAVE_SELECCIONP1,seleccionP1);
            intent.putExtra(CLAVE_SELECCIONP2,seleccionP2);
            lanzadorJugador.launch(intent);

        };
        View.OnClickListener armaListener = v -> {
            int id = v.getId();
            Intent intent = new Intent(u3a7MetalSlug.this, u3a7SeleccionArma.class);
            ImageView imagen = (ImageView)v;
            if(id == R.id.u3a7ivArmaP1){
                intent.putExtra(CLAVE_JUGADOR,1);
            } else {
                intent.putExtra(CLAVE_JUGADOR,2);
            }
            lanzadorArma.launch(intent);
        };

        ivP1.setOnClickListener(jugadorListener);
        ivP2.setOnClickListener(jugadorListener);

        ivArmaP1.setOnClickListener(armaListener);
        ivArmaP2.setOnClickListener(armaListener);

    }
}