package com.example.ejercicios_android.ut03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u3a5Fibonacci extends AppCompatActivity {

    public static final String CLAVE_NUM1 = "NUM1";
    public static final String CLAVE_NUM2 = "NUM2";
    public static final String CLAVE_SUMA = "SUMA";
    TextView tvAnterior;
    TextView tvActual;

    Button btSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a5_fibonacci);

        tvAnterior = findViewById(R.id.u3a5tvAnterior);
        tvActual = findViewById(R.id.u3a5tvActual);
        btSiguiente = findViewById(R.id.u3a5btSiguiente);

        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        tvAnterior.setText(tvActual.getText().toString());
                        tvActual.setText(Integer.toString(data.getIntExtra(CLAVE_SUMA,1)));
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                    }
                }
        );

        btSiguiente.setOnClickListener(v -> {
                Intent intent = new Intent(u3a5Fibonacci.this, u3a5SiguienteNumero.class);
                intent.putExtra(CLAVE_NUM1, Integer.parseInt(tvAnterior.getText().toString()));
            intent.putExtra(CLAVE_NUM2, Integer.parseInt(tvActual.getText().toString()));
                lanzadora.launch(intent);
        });




    }
}