package com.example.ejercicios_android.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ejercicios_android.R;

public class u2a4PedirCita extends AppCompatActivity {

    EditText etPlannedDate;
    DatePickerDialog datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a4_pedir_cita);
        datePicker = new DatePickerDialog();
        EditText etPlannedDate = (EditText) findViewById(R.id.etPlannedDate);
        etPlannedDate.setOnClickListener((View v) -> {
                switch (v.getId()) {
                    case R.id.etPlannedDate:
                        showDatePickerDialog();
                        break;
                }
        });

    }
}