package com.example.ejercicios_android.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u2a2UnaVistaParaTodas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a2_una_vista_para_todas);

        Button r,g,b,y;
        TextView salida;

        r = findViewById(R.id.u2e2bTRojo);
        g = findViewById(R.id.u2e2bTVerde);
        b = findViewById(R.id.u2e2bTAzul);
        y = findViewById(R.id.u2e2bTAmarillo);

        salida = findViewById(R.id.u2e2tVSalida);


        View.OnClickListener listener = (View v) -> {
            int id = v.getId();
            if(id == R.id.u2e2bTRojo) {
                salida.setText("Rojo");
            } else if(id == R.id.u2e2bTVerde) {
                salida.setText("Verde");
            } else if (id == R.id.u2e2bTAzul) {
                salida.setText("Azul");
            } else if (id == R.id.u2e2bTAmarillo) {
                salida.setText("Amarillo");
            } else {
                salida.setText("Desconocido");
            }
        };
        r.setOnClickListener(listener);
        g.setOnClickListener(listener);
        b.setOnClickListener(listener);
        y.setOnClickListener(listener);

    }
}