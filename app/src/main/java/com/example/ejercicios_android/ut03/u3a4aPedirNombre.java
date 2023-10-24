package com.example.ejercicios_android.ut03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejercicios_android.R;

import java.io.Serializable;

public class u3a4aPedirNombre extends AppCompatActivity {

    Button btPedirNumero;

    TextView tvMostrarNombre;
    TextView tvMensaje;

    public static final String CLAVE_NOMBRE = "NOMBRE";
    public static final String CLAVE_RESULTADO = "RESULTADO";

    enum Resultado implements Serializable {
        Aceptar,
        Cancelar,
        Borrar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a4a_pedir_nombre);

        btPedirNumero = findViewById(R.id.u3a1dbtPedirNombre);
        tvMostrarNombre = findViewById(R.id.u3a4atvNombre);
        tvMensaje = findViewById(R.id.u3a4atvMensaje);

        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data.getSerializableExtra(CLAVE_RESULTADO) == Resultado.Borrar) {
                            tvMostrarNombre.setText("Anónimo");
                            animarMensaje("Se ha borrado el nombre");
                        } else {
                            tvMostrarNombre.setText(data.getStringExtra(CLAVE_NOMBRE));
                            animarMensaje("Se ha cambiado el nombre");
                        }


                    } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        animarMensaje("Se ha cancelado la edición");
                    }
                }
        );

        btPedirNumero.setOnClickListener(view -> {
                Intent intent = new Intent(u3a4aPedirNombre.this, u3a4bNombre.class);
                intent.putExtra(CLAVE_NOMBRE, tvMostrarNombre.getText().toString());
                lanzadora.launch(intent);
            });

    }
    public void animarMensaje(String mensaje) {
        tvMensaje.setAlpha(1);
        tvMensaje.setVisibility(View.VISIBLE);
        tvMensaje.setText(mensaje);
        int width = tvMensaje.getWidth();
        tvMensaje.setTranslationX(-800);

        tvMensaje.animate().translationX(0).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(() -> {

            tvMensaje.animate().alpha(0).setStartDelay(300).setDuration(1000).withEndAction(()-> {

            }).start();
        });
    }

}