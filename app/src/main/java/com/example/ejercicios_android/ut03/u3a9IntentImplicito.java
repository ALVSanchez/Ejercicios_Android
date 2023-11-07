package com.example.ejercicios_android.ut03;

import static android.provider.AlarmClock.EXTRA_HOUR;
import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static android.provider.AlarmClock.EXTRA_MINUTES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;

import com.example.ejercicios_android.R;

public class u3a9IntentImplicito extends AppCompatActivity {

    Button btPagina;
    Button btMarcar;
    Button btSMS;
    Button btIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a9_intent_implicito);

        btPagina = findViewById(R.id.u3a9btPagina);
        btMarcar = findViewById(R.id.u3a9btMarcar);
        btSMS = findViewById(R.id.u3a9btSMS);
        btIntent = findViewById(R.id.u3a9btIntent);

        btPagina.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.youtube.com/watch?v=KAwyWkksXuo"));
                startActivity(intent);
        });

        btMarcar.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "666"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // TODO: Mostrar error!
            }
        });

        btSMS.setOnClickListener(v -> {
            Uri uri = Uri.parse("smsto:12346556");
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(uri);
            intent.putExtra("sms_body", "Te veo hoy a las 6pm");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // TODO: Mostrar error!
            }
            startActivity(intent);
        });

        btIntent.setOnClickListener(v -> {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Hora de despertar")
                    .putExtra(AlarmClock.EXTRA_HOUR, 6)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 15);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

    }
}