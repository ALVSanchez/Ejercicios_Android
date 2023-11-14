package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u3a8CrearMonstruo extends AppCompatActivity {

    public static final String CLAVE_MONSTRUO = "MONSTRUO";

    EditText etNombre;
    EditText etMiembros;
    EditText etColor;
    TextView tvColor;
    TextView tvErrorColor;
    Button btCrear;

    Color colorSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a8_crear_monstruo);

        etNombre = findViewById(R.id.u3a8etNombre);
        etMiembros = findViewById(R.id.u3a8etMiembros);
        etColor = findViewById(R.id.u3a8etColor);
        tvColor = findViewById(R.id.u3a8tvColor);
        tvErrorColor = findViewById(R.id.u3a8tvErrorColor);
        btCrear = findViewById(R.id.u3a8btCrear);

        etColor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    Color nuevoColor = Color.valueOf(Color.parseColor("#" + charSequence.toString()));
                    colorSeleccionado = nuevoColor;
                    tvColor.setTextColor(nuevoColor.toArgb());
                    tvErrorColor.setVisibility(View.INVISIBLE);
                } catch (Exception e) {
                    tvErrorColor.setText("Error: Formato incorrecto");
                    tvErrorColor.setVisibility(View.VISIBLE);
                    colorSeleccionado = null;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btCrear.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            if (nombre.isEmpty()) {
                tvErrorColor.setText("Error: Nombre vacio");
                tvErrorColor.setVisibility(View.VISIBLE);
                return;
            }

            try {
                int miembros = Integer.parseInt(etMiembros.getText().toString());

                if (colorSeleccionado == null) {
                    tvErrorColor.setText("Error: Formato incorrecto");
                    tvErrorColor.setVisibility(View.VISIBLE);
                    return;
                }

                Monstruo monstruo = new Monstruo(nombre, miembros, colorSeleccionado.toArgb());
                Intent intent = new Intent(u3a8CrearMonstruo.this, u3a8MostrarMonstruo.class);

                intent.putExtra(CLAVE_MONSTRUO, monstruo);
                startActivity(intent);

            } catch (Exception e) {
                tvErrorColor.setText("Error: Nº Miembros vacio");
                tvErrorColor.setVisibility(View.VISIBLE);
                return;
            }

        });

    }
}