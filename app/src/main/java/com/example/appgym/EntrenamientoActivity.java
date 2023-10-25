package com.example.appgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.StringReader;
import java.security.Provider;

public class EntrenamientoActivity extends AppCompatActivity {


    private static int contEj = 0;
    private boolean isOn = false;
    private int mili = 0;
    private int seg = 0;
    private int min = 0;
    private Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);


        //Funcionalidad de cronometro
        //Cronometro
        Button start = findViewById(R.id.Start);
        Button stop = findViewById(R.id.Stop);
        Button reset = findViewById(R.id.reset);
        TextView reloj = findViewById(R.id.reloj);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOn = true;
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOn = false;
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOn = false;
                mili = 0;
                seg = 0;
                min = 0;
                reloj.setText("00:00:00");
            }
        });
        TextView finalCrono = reloj;
        Thread cronos = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (isOn) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mili++;
                        if (mili == 999) {
                            seg++;
                            mili = 0;
                        }
                        if (seg == 59) {
                            min++;
                            seg = 0;
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                String m = "";
                                String s = "";
                                String mi = "";
                                if (mili < 10) {
                                    m = "00" + mili;
                                } else if (mili < 100) {
                                    m = "0" + mili;
                                } else {
                                    m = "" + mili;
                                }
                                if (seg < 10) {
                                    s = "0" + seg;
                                } else {
                                    s = "" + seg;
                                }
                                if (min < 10) {
                                    mi = "0" + min;
                                } else {
                                    mi = "" + min;
                                }
                                reloj.setText(mi + ":" + s + ":" + m);
                            }
                        });

                    }
                }
            }
        });
        cronos.start();


        //Declaramos los desplegables de los musculos

        Spinner despleMusculo1 = findViewById(R.id.despleMusuculouno);
        Spinner despleMusculo2 = findViewById(R.id.despleMusuculodos);
        Spinner despleMusculo3 = findViewById(R.id.despleMusuculotres);

        //Declaramos los desplegables de los ejercicios

        Spinner despl0 = findViewById(R.id.cero);
        Spinner despl1 = findViewById(R.id.uno);
        Spinner despl2 = findViewById(R.id.dos);
        Spinner despl3 = findViewById(R.id.tres);
        Spinner despl4 = findViewById(R.id.cuatro);
        Spinner despl5 = findViewById(R.id.cinco);
        Spinner despl6 = findViewById(R.id.seix);
        Spinner despl7 = findViewById(R.id.siete);
        Spinner despl8 = findViewById(R.id.ocho);
        Spinner despl9 = findViewById(R.id.nueve);
        Spinner despl10 = findViewById(R.id.diez);
        Spinner despl11 = findViewById(R.id.once);
        Spinner despl12 = findViewById(R.id.doce);


        //Declaramos los text de cada desplegable de ejercicios

        TextView text0 = findViewById(R.id.textCero);
        TextView text1 = findViewById(R.id.textUno);
        TextView text2 = findViewById(R.id.textDos);
        TextView text3 = findViewById(R.id.textTres);
        TextView text4 = findViewById(R.id.textcuatro);
        TextView text5 = findViewById(R.id.textCinco);
        TextView text6 = findViewById(R.id.textSeix);
        TextView text7 = findViewById(R.id.textSiete);
        TextView text8 = findViewById(R.id.textOcho);
        TextView text9 = findViewById(R.id.textnueve);
        TextView text10 = findViewById(R.id.textDiez);
        TextView text11 = findViewById(R.id.textOnce);
        TextView text12 = findViewById(R.id.textDoce);



        //Declaramos el Boton enviar
        Button botonEnviar = findViewById(R.id.enviar);

        //Creamos array de texto

        TextView[] arrayText = {text0,text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12};

        //Creamos el array de ejercicios

        String[] arrayEjer = {"PressPlanoMaquina", "PressInclinado", "Contractora", "Flexiones", "ElevacionesLatMancuernas",
                "CurlAlternoPie", "CurlInvertido", "PullOver", "RackPull", "JalonPecho", "RemoBarra", "RemoT", "PressFrancesTumbado",
                "PressFrancesSentado", "TironPoleaEncimaDeLaCabeza", "FemoralTumbado", "ExtensionCuádriceps", "Prensa", "PrensaUnaPierna", "Aductores", "GemeloEnPrensa",
                "GemeloUnaPierna", "Pajaro", "PressMaquina", "LateralesSentado", "LateralesPolea", "EncogimientoPesado"};

        //Creamos el array  para introducir los pesos
        for (int i = 0;i<arrayEjer.length;i++){
            contEj++;
        }
        String[] arrayPesos = new String[contEj];

        Log.e("Longitud array de pesos", String.valueOf(contEj));

        //Creamos el array de los grupos musculares

        Spinner[] arrayDesplegablesDias = {despleMusculo1, despleMusculo2, despleMusculo3};
        ArrayAdapter<CharSequence> adapterDias = ArrayAdapter.createFromResource(this, R.array.diaEj, android.R.layout.simple_spinner_item);
        adapterDias.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Bucle para meter los grupos musculares en los desplegables

        for (int i = 0; i < arrayDesplegablesDias.length; i++) {
            arrayDesplegablesDias[i].setAdapter(adapterDias);
        }

        //Bucle para meter los ejecicios en los desplegables

        Spinner[] arrayDesplegablesEjercicios = {despl0,despl1, despl2, despl3, despl4, despl5, despl6, despl7, despl8, despl9, despl10, despl11, despl12};


        ArrayAdapter<CharSequence> adapterEjercicios = ArrayAdapter.createFromResource(this, R.array.EjercicioGym, android.R.layout.simple_spinner_item);
        adapterEjercicios.setDropDownViewResource(android.R.layout.simple_spinner_item);

        for(int i = 0;i<arrayDesplegablesEjercicios.length;i++){
            arrayDesplegablesEjercicios[i].setAdapter(adapterEjercicios);
        }

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Variables ejercicios
                String PressPlanoMaquina = "";
                String PressInclinado = "";
                String Contractora = "";
                String Flexiones = "";
                String ElevacionesLatMancuernas = "";
                String CurlAlternoPie = "";
                String CurlInvertido = "";
                String PullOver = "";
                String RackPull = "";
                String JalonPecho = "";
                String RemoBarra = "";
                String RemoT = "";
                String PressFrancesTumbado = "";
                String PressFrancesSentado = "";
                String TironPoleaEncimaDeLaCabeza = "";
                String FemoralTumbado = "";
                String ExtensionCuádriceps = "";
                String Prensa = "";
                String PrensaUnaPierna = "";
                String Aductores = "";
                String GemeloEnPrensa = "";
                String GemeloUnaPierna = "";
                String Pajaro = "";
                String PressMaquina = "";
                String LateralesSentado = "";
                String LateralesPolea = "";
                String EncogimientoPesado = "";
                String resultLog = "";
                String result = "";

                //Creamos un bucle para recorrer los desplegables

                for (int i = 0; i < arrayDesplegablesEjercicios.length; i++) {


                    //Creamos condiciones if y else if para comprobar el desplegable y meter
                    if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Press plano maquina")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("PressPlanoMaquina")) {
                                PressPlanoMaquina = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressPlanoMaquina;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Press inclinado")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("PressInclinado")) {
                                PressInclinado= arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressInclinado;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Contractora")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("Contractora")) {
                                Contractora = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Contractora;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Flexiones")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("Flexiones")) {
                                Flexiones = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Flexiones;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Curl alterno de pie")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("CurlAlternoPie")) {
                                CurlAlternoPie = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + CurlAlternoPie;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Curl invertido")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("CurlInvertido")) {
                                CurlInvertido = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + CurlInvertido;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Pull over")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("PullOver")) {
                                PullOver = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PullOver;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Rack pull")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("RackPull")) {
                                RackPull = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + RackPull;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Jalon al pecho")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("JalonPecho")) {
                                JalonPecho = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + JalonPecho;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Remo con barra")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("RemoBarra")) {
                                RemoBarra = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + RemoBarra;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Remo en T")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("RemoT")) {
                                RemoT = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + RemoT;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Press frances tumbado")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("PressFrancesTumbado")) {
                                PressFrancesTumbado = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressFrancesTumbado;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Press frances sentado")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("PressFrancesSentado")) {
                                PressFrancesSentado = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressFrancesSentado;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Tiron de polea encima de la cabeza")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("TironPoleaEncimaDeLaCabeza")) {
                               TironPoleaEncimaDeLaCabeza = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + TironPoleaEncimaDeLaCabeza;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Femoral tumbado")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("FemoralTumbado")) {
                                FemoralTumbado = arrayText[i].getText().toString();

                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + FemoralTumbado;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Extension de cuádriceps")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("ExtensionCuádriceps")) {
                                ExtensionCuádriceps = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + ExtensionCuádriceps;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Prensa")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("Prensa")) {
                                Prensa = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Prensa;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Prensa a una pierna")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("PrensaUnaPierna")) {
                                PrensaUnaPierna = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PrensaUnaPierna;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Aductores")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("Aductores")) {
                                Aductores = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Aductores;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Gemelo en prensa")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("PrensaUnaPierna")) {
                                PrensaUnaPierna = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PrensaUnaPierna;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Gemelo a una pierna")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("GemeloUnaPierna")) {
                                GemeloUnaPierna = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + GemeloUnaPierna;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Pajaro")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("Pajaro")) {
                                Pajaro = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Pajaro;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Elevaciones lat Mancuernas")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("ElevacionesLatMancuernas")) {
                                ElevacionesLatMancuernas = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + ElevacionesLatMancuernas;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Press en maquina")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("PressMaquina")) {
                                PressMaquina = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressMaquina;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Laterales sentado")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("LateralesSentado")) {
                                LateralesSentado = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + LateralesSentado;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Laterales en polea")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals("LateralesPolea")) {
                                LateralesPolea = arrayText[i].getText().toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + LateralesPolea;

                    }else{
                        resultLog = "Desplegable vacio";
                    }

                    Log.e("Result", resultLog);
                }


            }
        });


    }
}