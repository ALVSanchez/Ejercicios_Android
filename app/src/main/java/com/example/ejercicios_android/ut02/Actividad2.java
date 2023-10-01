package com.example.ejercicios_android.ut02;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.ejercicios_android.R;

public class Actividad2 extends AppCompatActivity {

    SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progreso, boolean fromUser) {
            //texto.setText(Integer.toString(progreso));

            if(seekBar == rojo){

            } else if(seekBar == verde){

            } else if(seekBar == azul){

            }

            texto.setBackgroundColor(Color.rgb(rojo.getProgress(),verde.getProgress(),azul.getProgress()));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    SeekBar rojo;
    SeekBar azul;
    SeekBar verde;
    ToggleButton toggle;

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        rojo = findViewById(R.id.u2e2SbRojo);
        verde = findViewById(R.id.u2e2SbVerde);
        azul = findViewById(R.id.u2e2SbAzul);

        toggle = findViewById(R.id.u2e2BtToggle);
        texto = findViewById(R.id.u2e2TvPrueba);




        rojo.setOnSeekBarChangeListener(listener);
        verde.setOnSeekBarChangeListener(listener);
        azul.setOnSeekBarChangeListener(listener);

        toggle.setOnClickListener((View v) -> {
            if(!toggle.isChecked()){
                texto.setTextColor(Color.rgb(0,0,0));
            } else {
                texto.setTextColor(Color.rgb(255,255,255));
            }
        });

        texto.setTextColor(Color.rgb(0,0,0));

    }
}