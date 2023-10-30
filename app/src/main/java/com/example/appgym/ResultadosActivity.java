package com.example.appgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {
    private static String fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        CalendarView calendario = findViewById(R.id.calendario);
        TextView pantalla = findViewById(R.id.pantalla);
        String dia = String.valueOf(calendario.getDate());
        pantalla.setText(dia);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int año, int mes, int dia) {

                 fecha = mes + "/" + dia;


            }
        });





    }
}