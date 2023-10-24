package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejercicios_android.R;

public class u3a4bNombre extends AppCompatActivity {

    EditText etNombre;

    Button btAceptar;
    Button btCancelar;
    Button btBorrar;

    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a4b_nombre);

        nombre = getIntent().getStringExtra(u3a4aPedirNombre.CLAVE_NOMBRE);

        etNombre = findViewById(R.id.u3a4betNombre);
        btAceptar = findViewById(R.id.u3a4bbtAceptar);
        btCancelar = findViewById(R.id.u3a4bbtCancelar);
        btBorrar = findViewById(R.id.u3a4bbtBorrar);

        etNombre.setText(nombre);

        btAceptar.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(u3a4aPedirNombre.CLAVE_NOMBRE, etNombre.getText().toString());
            resultIntent.putExtra(u3a4aPedirNombre.CLAVE_RESULTADO, u3a4aPedirNombre.Resultado.Aceptar);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });

        btCancelar.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(u3a4aPedirNombre.CLAVE_NOMBRE, etNombre.getText().toString());
            resultIntent.putExtra(u3a4aPedirNombre.CLAVE_RESULTADO, u3a4aPedirNombre.Resultado.Cancelar);
            setResult(Activity.RESULT_CANCELED, resultIntent);
            finish();
        });

        btBorrar.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(u3a4aPedirNombre.CLAVE_NOMBRE, etNombre.getText().toString());
            resultIntent.putExtra(u3a4aPedirNombre.CLAVE_RESULTADO, u3a4aPedirNombre.Resultado.Borrar);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });
    }
}