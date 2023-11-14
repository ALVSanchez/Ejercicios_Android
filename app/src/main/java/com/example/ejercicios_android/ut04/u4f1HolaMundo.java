package com.example.ejercicios_android.ut04;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ejercicios_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link u4f1HolaMundo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class u4f1HolaMundo extends Fragment {

    public u4f1HolaMundo() {
        // Required empty public constructor
    }

    public static u4f1HolaMundo newInstance(String param1, String param2) {
        u4f1HolaMundo fragment = new u4f1HolaMundo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    TextView tvHola;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_u4f1_hola_mundo, container, false);

        tvHola = layout.findViewById(R.id.u4f1idtvHolaMundo);

        tvHola.setOnClickListener(view -> {
            tvHola.setBackgroundColor((int)(Math.random()*Integer.MAX_VALUE));
        });


        return layout;
    }
}