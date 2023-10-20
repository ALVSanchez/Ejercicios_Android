package com.example.ejercicios_android.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ejercicios_android.R;

import java.util.ArrayList;
import java.util.List;

public class u3a3aSeleccion extends AppCompatActivity {


    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a3a_seleccion);

        spinner = findViewById(R.id.u3a3aSpinner);
        List<String> spinnerArray =  new ArrayList<>();
        spinnerArray.add("Item1");
        spinnerArray.add("item2");
        spinnerArray.add("item3");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.u3a3aSpinner);
        sItems.setAdapter(adapter);

    }


}