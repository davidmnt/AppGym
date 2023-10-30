package com.example.appgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {
    private static String fecha;
    private static String[] columnasPecho={"id","pressPlanoMaquina","pressInclinado","contractora","flexiones"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        conexionSQLlite conn = new conexionSQLlite(this, "pesos", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        CalendarView calendario = findViewById(R.id.calendario);
        TextView pantalla = findViewById(R.id.pantalla);
        String dia = String.valueOf(calendario.getDate());
        pantalla.setText(dia);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int año, int mes, int dia) {


                 fecha = mes + "/" + dia;


                Cursor datos = db.query("PECHO",columnasPecho,"id = fecha",null,null,null,null);
                while (datos.moveToNext()) {
                    String result = datos.getString(datos.getInt(0));
                    pantalla.setText(result);
                }


            }
        });





    }
}