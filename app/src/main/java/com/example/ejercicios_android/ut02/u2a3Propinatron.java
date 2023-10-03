package com.example.ejercicios_android.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u2a3Propinatron extends AppCompatActivity {


    TextView propina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a3_propinatron);

        Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,btAtras,btBorrar;
        propina = findViewById(R.id.u2e3tVPropina);

        View.OnClickListener listener = (View v) -> {
            Button clickedbutton = (Button) v;
            String texto = clickedbutton.getText().toString();
            boolean esNumero;
            try {
                Integer.parseInt(texto);
                esNumero = true;
            }catch(NumberFormatException e) {
                esNumero = false;
            };

            if(esNumero){
                propina.append(texto);
            } else if(texto.equals("<")) {
                propina.setText(propina.getText().subSequence(0,propina.length()-2));
            }

        };

        findViewById(R.id.u2e3bT1).setOnClickListener(listener);
        findViewById(R.id.u2e3bT2).setOnClickListener(listener);
        findViewById(R.id.u2e3bT3).setOnClickListener(listener);
        findViewById(R.id.u2e3bT4).setOnClickListener(listener);
        findViewById(R.id.u2e3bT5).setOnClickListener(listener);
        findViewById(R.id.u2e3bT6).setOnClickListener(listener);
        findViewById(R.id.u2e3bT7).setOnClickListener(listener);
        findViewById(R.id.u2e3bT8).setOnClickListener(listener);
        findViewById(R.id.u2e3bT9).setOnClickListener(listener);
        findViewById(R.id.u2e3bT0).setOnClickListener(listener);
        findViewById(R.id.u2e3bTAtras).setOnClickListener(listener);
        findViewById(R.id.u2e3bTBorrar).setOnClickListener(listener);



    }




}