package com.example.appgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultadosActivity extends AppCompatActivity {
    private static String fec;
    private static Cursor cur;
    static Modelo m = new Modelo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        conexionSQLlite conn = new conexionSQLlite(this, "pesos", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        CalendarView calendario = findViewById(R.id.calendario);
        TextView primerEj = findViewById(R.id.uno);
        TextView segundoEj = findViewById(R.id.dos);
        TextView tercerEj = findViewById(R.id.tres);
        TextView cuartoEj = findViewById(R.id.cuatro);
        TextView quintoEj = findViewById(R.id.cinco);
        TextView sextoEj = findViewById(R.id.seix);
        TextView septimoEj = findViewById(R.id.siete);
        TextView octaboEj = findViewById(R.id.ocho);
        TextView novenoEj = findViewById(R.id.nueve);
        TextView decimoEj = findViewById(R.id.diez);
        TextView undecimoEj = findViewById(R.id.once);
        TextView duodecimoEj = findViewById(R.id.doce);
        TextView decimotercerEj = findViewById(R.id.trece);
        TextView decimoCuartoEj = findViewById(R.id.catorce);
        TextView decimoquintoEj = findViewById(R.id.quince);
        TextView decimosextoEj = findViewById(R.id.dieciseix);
        TextView decimoseptimoEj = findViewById(R.id.diecisiete);
        TextView decimooctavoEj = findViewById(R.id.dieciocho);
        TextView decimonovenoEj = findViewById(R.id.diecinueve);


        TextView[] arrayTextEjPecho = {primerEj, segundoEj, tercerEj, cuartoEj};
        TextView[] arrayTextEjEspalda = {quintoEj,sextoEj, septimoEj, octaboEj, novenoEj};
        TextView[] arrayTextEjPierna = {decimoquintoEj,decimosextoEj,decimoseptimoEj};
        TextView[] arrayTextEjHombro = {decimoEj,undecimoEj, duodecimoEj, decimotercerEj, decimoCuartoEj};


        TextView[] arrayTextEjTriceps = {sextoEj, septimoEj, octaboEj, novenoEj,decimoEj};
        TextView[] arrayTextEjFemoral= {sextoEj, septimoEj, octaboEj, novenoEj,decimoEj};
        TextView[] arrayTextEjBiceps = { undecimoEj, duodecimoEj, decimotercerEj, decimoCuartoEj};
        TextView[] arrayTextEjAductores = { undecimoEj, duodecimoEj, decimotercerEj, decimoCuartoEj};
        TextView[] arrayTextEjTrapecio = { undecimoEj, duodecimoEj, decimotercerEj, decimoCuartoEj};
        TextView[] arrayTextEjGemelo = {decimoquintoEj, decimosextoEj};


        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int año, int mes, int dia) {

                fec = (mes + 1) + "/" + dia;
                String[] parametroBuscar = {fec};

                //---------------------------------------------------------------------------------------------------------------------------------------

                //Pecho
                cur = db.query("PECHO", null, null, null, null, null, null);
                String[] columnasPecho = {cur.getColumnName(1), cur.getColumnName(2), cur.getColumnName(3), cur.getColumnName(4)};

                //Espalda
                cur = db.query("ESPALDA", null, null, null, null, null, null);
                String[] columnasEspalda = {cur.getColumnName(1), cur.getColumnName(2), cur.getColumnName(3), cur.getColumnName(4), cur.getColumnName(5)};

                //Hombro
                cur = db.query("HOMBRO", null, null, null, null, null, null);
                String[] columnasHombro = {cur.getColumnName(1), cur.getColumnName(2), cur.getColumnName(3), cur.getColumnName(4), cur.getColumnName(5)};

                //Pierna
                cur = db.query("PIERNA", null, null, null, null, null, null);
                String[] columnasPierna = {cur.getColumnName(1), cur.getColumnName(2), cur.getColumnName(3)};

                //Aductores
                cur = db.query("ADUCTORES", null, null, null, null, null, null);
                String[] columnasAductores = {cur.getColumnName(1)};

                //Gemelo
                cur = db.query("GEMELO", null, null, null, null, null, null);
                String[] columnasGemelo = {cur.getColumnName(1), cur.getColumnName(2)};

                //Femoral
                cur = db.query("FEMORAL", null, null, null, null, null, null);
                String[] columnasFemoral = {cur.getColumnName(1)};

                //Triceps
                cur = db.query("TRICEPS", null, null, null, null, null, null);
                String[] columnasTriceps = {cur.getColumnName(1), cur.getColumnName(2), cur.getColumnName(3)};

                //Trapecio
                cur = db.query("TRAPECIO", null, null, null, null, null, null);
                String[] columnasTrapecio = {cur.getColumnName(1)};

                //Biceps
                cur = db.query("BICEPS", null, null, null, null, null, null);
                String[] columnasBiceps = {cur.getColumnName(1), cur.getColumnName(2)};

                //---------------------------------------------------------------------------------------------------------------------------------------

                try {
                    //Pecho
                    cur = db.query("PECHO", columnasPecho, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();

                    String datoPecho1 = "";
                    String datoPecho2 = "";
                    String datoPecho3 = "";
                    String datoPecho4 = "";

                    if (cur.getCount() > 0) {
                        datoPecho1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));
                        datoPecho2 = (cur.getColumnName(1) + ":" + " " + cur.getString(1));
                        datoPecho3 = (cur.getColumnName(2) + ":" + " " + cur.getString(2));
                        datoPecho4 = (cur.getColumnName(3) + ":" + " " + cur.getString(3));
                    }

                    String[] objDatosPecho = {datoPecho1, datoPecho2, datoPecho3, datoPecho4};

                    //Espalda
                    cur = db.query("ESPALDA", columnasEspalda, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();

                    String datoEspalda1 = "";
                    String datoEspalda2 = "";
                    String datoEspalda3 = "";
                    String datoEspalda4 = "";
                    String datoEspalda5 = "";

                    if (cur.getCount() > 0) {
                        datoEspalda1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));
                        datoEspalda2 = (cur.getColumnName(1) + ":" + " " + cur.getString(1));
                        datoEspalda3 = (cur.getColumnName(2) + ":" + " " + cur.getString(2));
                        datoEspalda4 = (cur.getColumnName(3) + ":" + " " + cur.getString(3));
                        datoEspalda5 = (cur.getColumnName(4) + ":" + " " + cur.getString(4));
                    }
                    String[] objDatosEspalda = {datoEspalda1, datoEspalda2, datoEspalda3, datoEspalda4, datoEspalda5};


                    //Hombro
                    cur = db.query("HOMBRO", columnasHombro, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();
                    String resultHombro1 = "";
                    String resultHombro2 = "";
                    String resultHombro3 = "";
                    String resultHombro4 = "";
                    String resultHombro5 = "";

                    if (cur.getCount() > 0) {
                        resultHombro1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));
                        resultHombro2 = (cur.getColumnName(1) + ":" + " " + cur.getString(1));
                        resultHombro3 = (cur.getColumnName(2) + ":" + " " + cur.getString(2));
                        resultHombro4 = (cur.getColumnName(3) + ":" + " " + cur.getString(3));
                        resultHombro5 = (cur.getColumnName(4) + ":" + " " + cur.getString(4));
                    }

                    String[] objDatosHombro = {resultHombro1, resultHombro2, resultHombro3, resultHombro4, resultHombro5};


                    //Biceps
                    cur = db.query("BICEPS", columnasBiceps, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();
                    String datoBiceps1 = "";
                    String datoBiceps2 = "";
                    if (cur.getCount() > 0) {
                        datoBiceps1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));
                        datoBiceps2 = (cur.getColumnName(1) + ":" + " " + cur.getString(1));
                    }
                    String[] objDatosBiceps = {datoBiceps1, datoBiceps2};

                    //Triceps
                    cur = db.query("TRICEPS", columnasTriceps, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();

                    String datoTriceps1 = "";
                    String datoTriceps2 = "";
                    String datoTriceps3 = "";


                    if (cur.getCount() > 0) {
                        datoTriceps1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));
                        datoTriceps2 = (cur.getColumnName(1) + ":" + " " + cur.getString(1));
                        datoTriceps3 = (cur.getColumnName(2) + ":" + " " + cur.getString(2));

                    }

                    String[] objDatosTriceps = {datoTriceps1, datoTriceps2, datoTriceps3};

                    //Triceps
                    cur = db.query("TRAPECIO", columnasTrapecio, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();

                    String datoTrapecio1 = "";


                    if (cur.getCount() > 0) {
                        datoTrapecio1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));

                    }

                    String[] objDatosTrapecio = {datoTrapecio1};

                    //Gemelo
                    cur = db.query("GEMELO", columnasGemelo, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();

                    String datoGemelo1 = "";


                    if (cur.getCount() > 0) {
                        datoGemelo1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));

                    }

                    String[] objDatosGemelo = {datoGemelo1};

                    //Aductores
                    cur = db.query("ADUCTORES", columnasAductores, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();

                    String datoAductores1 = "";


                    if (cur.getCount() > 0) {
                        datoAductores1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));

                    }

                    String[] objDatosAductores = {datoAductores1};

                    //Femoral
                    cur = db.query("FEMORAL", columnasFemoral, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();

                    String datosFemoral1 = "";


                    if (cur.getCount() > 0) {
                        datosFemoral1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));

                    }

                    String[] objDatosFemoral = {datosFemoral1};

                    //Pierna
                    cur = db.query("PIERNA", columnasPierna, "id=?", parametroBuscar, null, null, null);
                    cur.moveToFirst();

                    String datoPierna1 = "";
                    String datoPierna2 = "";
                    String datoPierna3 = "";


                    if (cur.getCount() > 0) {
                        datoPierna1 = (cur.getColumnName(0) + ":" + " " + cur.getString(0));
                        datoPierna2 = (cur.getColumnName(1) + ":" + " " + cur.getString(1));
                        datoPierna3 = (cur.getColumnName(2) + ":" + " " + cur.getString(2));

                    }

                    String[] objDatosPierna = {datoPierna1, datoPierna2, datoPierna3};



                    //---------------------------------------------------------------------------------------------------------------------------------------

                    //Pecho
                    for (int i = 0; i < objDatosPecho.length; i++) {

                        if (!objDatosPecho[i].isEmpty()) {
                            arrayTextEjPecho[i].setText(objDatosPecho[i].toString());
                        }else{
                            arrayTextEjPecho[i].setText("");
                        }
                    }


                    //Espalda
                    for (int i = 0; i < objDatosEspalda.length; i++) {

                        if (!objDatosEspalda[i].isEmpty()) {
                            arrayTextEjEspalda[i].setText(objDatosEspalda[i].toString());
                        }else{
                            arrayTextEjEspalda[i].setText("");
                        }
                    }

                    //Hombro
                    for (int i = 0; i < objDatosHombro.length; i++) {

                        if (!objDatosHombro[i].isEmpty()) {
                            arrayTextEjHombro[i].setText(objDatosHombro[i].toString());
                        }else{
                            arrayTextEjHombro[i].setText("");
                        }
                    }

                    //Biceps
                    for (int i = 0; i < objDatosBiceps.length; i++) {

                        if (!objDatosBiceps[i].isEmpty()) {
                            arrayTextEjBiceps[i].setText(objDatosBiceps[i].toString());
                        }else{
                            arrayTextEjBiceps[i].setText("");
                        }
                    }

                    //Triceps
                    for (int i = 0; i < objDatosTriceps.length; i++) {

                        if (!objDatosTriceps[i].isEmpty()) {
                            arrayTextEjTriceps[i].setText(objDatosTriceps[i].toString());
                        }else{
                            arrayTextEjTriceps[i].setText("");
                        }
                    }

                    //Pierna
                    for (int i = 0; i < objDatosPierna.length; i++) {

                        if (!objDatosPierna[i].isEmpty()) {
                            arrayTextEjPierna[i].setText(objDatosPierna[i].toString());
                        }else{
                            arrayTextEjPierna[i].setText("");
                        }
                    }

                    //Aductor
                    for (int i = 0; i < objDatosAductores.length; i++) {

                        if (!objDatosAductores[i].isEmpty()) {
                            arrayTextEjAductores[i].setText(objDatosAductores[i].toString());
                        }else{
                            arrayTextEjAductores[i].setText("");
                        }
                    }

                    //Gemelo
                    for (int i = 0; i < objDatosGemelo.length; i++) {

                        if (!objDatosGemelo[i].isEmpty()) {
                            arrayTextEjGemelo[i].setText(objDatosGemelo[i].toString());
                        }else{
                            arrayTextEjGemelo[i].setText("");
                        }
                    }

                    //Femoral
                    for (int i = 0; i < objDatosFemoral.length; i++) {

                        if (!objDatosFemoral[i].isEmpty()) {
                            arrayTextEjFemoral[i].setText(objDatosFemoral[i].toString());
                        }else{
                            arrayTextEjFemoral[i].setText("");
                        }
                    }

                    //Trapecio
                    for (int i = 0; i < objDatosTrapecio.length; i++) {

                        if (!objDatosTrapecio[i].isEmpty()) {
                            arrayTextEjTrapecio[i].setText(objDatosTrapecio[i].toString());
                        }else{
                            arrayTextEjTrapecio[i].setText("");
                        }
                    }






                    cur.close();

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error al enviar los datos", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }
}