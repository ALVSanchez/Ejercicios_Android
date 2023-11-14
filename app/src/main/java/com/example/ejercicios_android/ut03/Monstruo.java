package com.example.ejercicios_android.ut03;

import android.graphics.Color;

import androidx.annotation.NonNull;

import java.io.Serializable;


public class Monstruo implements Serializable {

    public static final String CLAVE_MONSTRUO = "MONSTRUO";

    String nombre;
    int manos;
    int piernas;
    int color;

    Monstruo(String nombre, int miembros, int color){
        this.nombre = nombre;
        this.color = color;
        //Numero entre [0,miembros]
        manos = (int)Math.floor(Math.random()*(miembros+1));
        piernas = miembros - manos;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int ancho = Math.max(manos, piernas);
        int manosColocadas = 0;
        int piernasColocadas = 0;

        for (int i = 0; i < ancho/2; i++) {
            builder.append(" ");
        }
        builder.append("*");
        for (int i = 0; i < ancho/2; i++) {
            builder.append(" ");
        }
        builder.append("\n");

        for (int i = 0; i <= ancho/2 && manosColocadas < manos; i++) {
            builder.append("/");
            manosColocadas++;
        }
        builder.append("o");
        for (int i = 0; i <= ancho/2 && manosColocadas < manos; i++) {
            builder.append("\\");
            manosColocadas++;
        }
        builder.append("\n");

        for (int i = 0; i <= ancho/2 && piernasColocadas < piernas; i++) {
            builder.append("/");
            piernasColocadas++;
        }
        builder.append(" ");
        for (int i = 0; i <= ancho/2 && piernasColocadas < piernas; i++) {
            builder.append("\\");
            piernasColocadas++;
        }
        return builder.toString();
    }
}
