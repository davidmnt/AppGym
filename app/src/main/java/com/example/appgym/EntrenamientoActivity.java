package com.example.appgym;

import androidx.appcompat.app.AppCompatActivity;

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
    private boolean acabado = false;
    private static int cont = 0;
    private boolean isOn = false;
    private int mili = 0;
    private int seg = 0;
    private int min = 0;
    private Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);

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
        Spinner despl13 = findViewById(R.id.trece);

        //Declaramos los text de cada desplegable de ejercicios

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
        TextView text13 = findViewById(R.id.textTrece);


        //Declaramos el Boton enviar
        Button botonEnviar = findViewById(R.id.enviar);

        //Creamos array de texto

        TextView[] arrayText = {text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13};

        String[] arrayEjer = {PressPlanoMaquina, PressInclinado, Contractora, Flexiones, ElevacionesLatMancuernas,
                CurlAlternoPie, CurlInvertido, PullOver, RackPull, JalonPecho, RemoBarra, RemoT, PressFrancesTumbado,
                PressFrancesSentado, TironPoleaEncimaDeLaCabeza, FemoralTumbado, ExtensionCuádriceps, Prensa, PrensaUnaPierna, Aductores, GemeloEnPrensa,
                GemeloUnaPierna, Pajaro, PressMaquina, LateralesSentado, LateralesPolea, EncogimientoPesado};


        //Bucle para meter los grupos musculares en los desplegables

        Spinner[] arrayDesplegablesDias = {despleMusculo1, despleMusculo2, despleMusculo3};
        ArrayAdapter<CharSequence> adapterDias = ArrayAdapter.createFromResource(this, R.array.diaEj, android.R.layout.simple_spinner_item);
        adapterDias.setDropDownViewResource(android.R.layout.simple_spinner_item);

        for (int i = 0; i < arrayDesplegablesDias.length; i++) {
            arrayDesplegablesDias[i].setAdapter(adapterDias);
        }

        //Bucle para meter los ejecicios en los desplegables

        Spinner[] arrayDesplegablesEjercicios = {despl1, despl2, despl3, despl4, despl5, despl6, despl7, despl8, despl9, despl10, despl11, despl12, despl13};


        ArrayAdapter<CharSequence> adapterEjercicios = ArrayAdapter.createFromResource(this, R.array.EjercicioGym, android.R.layout.simple_spinner_item);
        adapterEjercicios.setDropDownViewResource(android.R.layout.simple_spinner_item);

        for(int i = 0;i<arrayDesplegablesEjercicios.length;i++){
            arrayDesplegablesEjercicios[i].setAdapter(adapterEjercicios);
        }


        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String resultLog = "";
                String result = "";

                //Creamos un bucle para recorrer los desplegables

                for (int i = 0; i < arrayDesplegablesEjercicios.length; i++) {


                    //Creamos condiciones if y else if para comprobar el desplegable y meter
                    if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Press plano maquina")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals(PressPlanoMaquina)) {
                                arrayEjer[j] = arrayText[i].getText().toString();
                                result = arrayEjer[j].toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + result;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Press inclinado")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals(PressInclinado)) {
                                arrayEjer[j] = arrayText[i].getText().toString();
                                result = arrayEjer[j].toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + result;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Contractora")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals(Contractora)) {
                                arrayEjer[j] = arrayText[i].getText().toString();
                                result = arrayEjer[j].toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + result;

                    } else if (arrayDesplegablesEjercicios[i].getSelectedItem().toString().equals("Flexiones")) {

                        for (int j = 0; j < arrayEjer.length; j++) {

                            if (arrayEjer[j].toString().equals(Flexiones)) {
                                arrayEjer[j] = arrayText[i].getText().toString();
                                result = arrayEjer[j].toString();
                                break;
                            }
                        }
                        resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + result;

                    }


                    Log.e("Result", resultLog);


                }

                acabado = true;
            }
        });


    }
}