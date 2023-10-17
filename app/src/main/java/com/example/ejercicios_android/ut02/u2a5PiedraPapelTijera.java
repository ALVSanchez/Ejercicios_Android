package com.example.ejercicios_android.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u2a5PiedraPapelTijera extends AppCompatActivity {

    ImageView eleccionJugador;
    ImageView eleccionBot;

    TextView tvPuntosJugador;
    TextView tvPuntosBot;

    int puntosJugador = 0;
    int puntosBot = 0;

    Button btPiedra;

    Button btPapel;

    Button btTijera;

    enum Seleccion {
        Piedra,
        Papel,
        Tijera
    }

    Seleccion getSeleccionBot(){
        return Seleccion.values()[(int)(Math.random()*(Seleccion.values().length))];
    }

    int solucion[][] =
            {
                    {0,0,1}, //Piedra vs ?
                    {1,0,0}, //Papel vs ?
                    {0,1,0}  //Tijera vs ?
            };

    void setEleccion(ImageView imageView, Seleccion seleccion){
        int imageResource = R.drawable.u2a5piedra;
        switch (seleccion){
            case Piedra:
                imageResource = R.drawable.u2a5piedra;
                break;
            case Papel:
                imageResource = R.drawable.u2a5papel;
                break;
            case Tijera:
                imageResource = R.drawable.u2a5tijeras;
        }
        imageView.setImageResource(imageResource);

        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setRotation(0);

        imageView.animate().scaleX(1).scaleY(1).rotationBy(360).setInterpolator(new OvershootInterpolator()).setDuration(1000).setListener(null);
    }

    void seleccionar(Seleccion seleccionJugador) {
        Seleccion seleccionBot = getSeleccionBot();
        setEleccion(eleccionJugador, seleccionJugador);
        setEleccion(eleccionBot, seleccionBot);
        int addPuntosJugador = solucion[seleccionJugador.ordinal()][seleccionBot.ordinal()];
        int addPuntosBot = solucion[seleccionBot.ordinal()][seleccionJugador.ordinal()];
        puntosJugador += addPuntosJugador;
        puntosBot += addPuntosBot;
        tvPuntosJugador.setText(Integer.toString(puntosJugador));
        tvPuntosBot.setText(Integer.toString(puntosBot));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a5_piedra_papel_tijera);

        eleccionJugador = findViewById(R.id.u2a5ImgEleccionJugador);
        eleccionBot = findViewById(R.id.u2a5ImgEleccionBot);

        btPiedra = findViewById(R.id.u2e5BtPiedra);
        btPapel = findViewById(R.id.u2e5BtPapel);
        btTijera = findViewById(R.id.u2e5BtTijera);

        tvPuntosJugador = findViewById(R.id.u2e5TvPuntosJugador);
        tvPuntosBot = findViewById(R.id.u2e5TvPuntosBot);

        btPiedra.setOnClickListener((View v) -> {
            seleccionar(Seleccion.Piedra);
        });
        btPapel.setOnClickListener((View v) -> {
            seleccionar(Seleccion.Papel);
        });
        btTijera.setOnClickListener((View v) -> {
            seleccionar(Seleccion.Tijera);
        });
    }
}