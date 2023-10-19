package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ejercicios_android.R;

public class u3a2aCalculadora extends AppCompatActivity {

    public static final String CLAVE_RESULTADO = "RESULTADO";
    public static final String CLAVE_OPERANDO1 = "OPERANDO1";
    public static final String CLAVE_OPERANDO2 = "OPERANDO2";
    public static final String CLAVE_OPERACION = "OPERACION";
    RadioGroup rgOperacion;
    EditText etOperando1;
    EditText etOperando2;
    Button btCalcular;

    TextView tvError;

    void mostrarError(String texto) {
        tvError.setText(texto);

        tvError.setAlpha(1);
        final float FREQ = 2f;
        final float DECAY = 2f;
        final long DURACION = 240;
        tvError.animate().rotationBy(3).setInterpolator((float input) -> {
            double raw = Math.sin(FREQ * input * 2 * Math.PI);
            return (float)(raw * Math.exp(-input * DECAY));
        }).setDuration(DURACION).withEndAction(()->tvError.setRotation(0)).start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a2a_calculadora);

        rgOperacion = findViewById(R.id.u3a2aRgOperacion);
        btCalcular = findViewById(R.id.u3a2aBtCalcular);
        etOperando1 = findViewById(R.id.u3a2aEtOperando1);
        etOperando2 = findViewById(R.id.u3a2aEtOperando2);
        tvError = findViewById(R.id.u3a2aTvError);
        tvError.setAlpha(0);

        btCalcular.setOnClickListener(view -> {
            if(etOperando1.getText().toString().isEmpty() || etOperando2.getText().toString().isEmpty()){
                String prueba = etOperando2.getText().toString();
                mostrarError("Debes rellenar todos los campos");
                return;
            }
            int operando1;
            int operacion;
            int operando2;
            try {
                operando1 = Integer.parseInt(etOperando1.getText().toString());
                operacion = rgOperacion.getCheckedRadioButtonId();
                operando2 = Integer.parseInt(etOperando2.getText().toString());
            } catch(NumberFormatException e){
                mostrarError("Formato incorrecto");
                return;
            }
            String stringOperacion;
            int resultado;
            if (operacion == R.id.u3a2aRbSumar) {
                stringOperacion = "+";
                resultado = operando1 + operando2;
            } else if (operacion == R.id.u3a2aRbRestar) {
                stringOperacion = "-";
                resultado = operando1 - operando2;
            } else if (operacion == R.id.u3a2aRbMultiplicar) {
                stringOperacion = "*";
                resultado = operando1 * operando2;
            } else {
                stringOperacion = "/";
                if (operando2 == 0) {
                    //Mensaje de error
                    mostrarError("No se puede dividir por 0");
                    return;
                }
                resultado = operando1 / operando2;
            }

            Intent i = new Intent(this, u3a2bResultado.class);
            i.putExtra(CLAVE_OPERANDO1, operando1);
            i.putExtra(CLAVE_RESULTADO, resultado);
            i.putExtra(CLAVE_OPERANDO2, operando2);
            i.putExtra(CLAVE_OPERACION, resultado);


            startActivity(i);
        });

    }
}