package com.example.ejercicios_android.ut02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.example.ejercicios_android.DatePickerManager;
import com.example.ejercicios_android.R;
import com.example.ejercicios_android.TimePickerManager;

import java.text.DateFormat;
import java.util.Calendar;

public class u2a4PedirCita extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    EditText etDate;

    EditText etTime;

    Button btConfirmar;

    ConstraintLayout defaultLayout;

    ConstraintLayout checkLayout;

    ImageView imageCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a4_pedir_cita);
        etDate = (EditText) findViewById(R.id.u2e4etDate);
        etTime = (EditText) findViewById(R.id.u2e4eTTime);
        btConfirmar = (Button) findViewById(R.id.u2e4btConfirmar);
        defaultLayout = (ConstraintLayout) findViewById(R.id.u2e4DefaultLayout);
        checkLayout = (ConstraintLayout) findViewById(R.id.u2e4CheckLayout);
        imageCheck = (ImageView) findViewById(R.id.u2e4imgCheck);

        btConfirmar.setOnClickListener((View view) -> {

            //Verificar - TODO

            //layout.setTransitionAlpha(); // Se necesita API 29

            defaultLayout.animate().alpha(0.0f)
                    .setDuration(400)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            defaultLayout.setVisibility(View.GONE);
                        };
                    });

            checkLayout.setVisibility(View.VISIBLE);
            checkLayout.setAlpha(0.0f);

            checkLayout.animate().alpha(1.0f)
                    .setDuration(500)
                    .setListener(null);

            animateCheck();


        });

        imageCheck.setOnClickListener((View v) -> {
            animateCheck();
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Please note that use your package name here
                DatePickerManager mDatePickerDialogFragment;
                mDatePickerDialogFragment = new DatePickerManager();
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Please note that use your package name here
                TimePickerManager mDatePickerDialogFragment;
                mDatePickerDialogFragment = new TimePickerManager();
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "TIME PICK");
            }
        });

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        etDate.setText(selectedDate);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        etTime.setText(String.format("%02d:%02d",hour,minute));
    }

    void animateCheck() {
        imageCheck.setScaleX(0);
        imageCheck.setScaleY(0);
        imageCheck.setRotation(0);

        imageCheck.animate().scaleX(1).scaleY(1).rotationBy(360).setInterpolator(new OvershootInterpolator()).setDuration(1000).setListener(null);
    }
}