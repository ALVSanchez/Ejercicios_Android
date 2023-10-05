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
            boolean esNum = true;
            int num;

            int id = v.getId();
            if (id == R.id.u2e3bT1) {
                num = 1;
            } else if (id == R.id.u2e3bT2) {
                num = 2;
            } else if (id == R.id.u2e3bT3) {
                num = 3;
            } else if (id == R.id.u2e3bT4) {
                num = 4;
            } else if (id == R.id.u2e3bT5) {
                num = 5;
            } else if (id == R.id.u2e3bT6) {
                num = 6;
            } else if (id == R.id.u2e3bT7) {
                num = 7;
            } else if (id == R.id.u2e3bT8) {
                num = 8;
            } else if (id == R.id.u2e3bT9) {
                num = 9;
            } else if (id == R.id.u2e3bT0) {
                num = 0;
            } else {
                num = -1;
                esNum = false;
            }



            if(esNum){
                propina.append(num + "");
            } else if(v.getId() == R.id.u2e3bTAtras) {
                propina.setText(propina.getText().subSequence(0,propina.length()-1));
            } else if(v.getId() == R.id.u2e3bTBorrar) {
                propina.setText("");
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