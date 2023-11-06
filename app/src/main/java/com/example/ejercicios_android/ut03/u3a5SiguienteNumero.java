package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u3a5SiguienteNumero extends AppCompatActivity {

    int num1;
    int num2;

    Button btVolver;
    TextView tvSuma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a5_siguiente_numero);

        num1 = getIntent().getIntExtra(u3a5Fibonacci.CLAVE_NUM1,1);
        num2 = getIntent().getIntExtra(u3a5Fibonacci.CLAVE_NUM2,1);

        btVolver = findViewById(R.id.u3a5btVolver);
        tvSuma = findViewById(R.id.u3a5tvSuma);
        int suma = num1 + num2;
        tvSuma.setText(String.format("%d + %d = %d",num1,num2,suma));

        btVolver.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(u3a5Fibonacci.CLAVE_SUMA, suma);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });
    }
}