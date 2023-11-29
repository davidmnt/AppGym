package com.example.appgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.R.id;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appgym.Conexion.Modelo;
import com.example.appgym.Objetos.AductoresO;
import com.example.appgym.Objetos.BicepsO;
import com.example.appgym.Objetos.EspaldaO;
import com.example.appgym.Objetos.FemoralO;
import com.example.appgym.Objetos.GemeloO;
import com.example.appgym.Objetos.HombroO;
import com.example.appgym.Objetos.PechoO;
import com.example.appgym.Objetos.PiernaO;
import com.example.appgym.Objetos.TrapecioO;
import com.example.appgym.Objetos.TricepsO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EntrenamientoActivity extends AppCompatActivity {

    //DEFINICION DE VARIABLES VARIADAS

   public Spinner[] arrDesple = new Spinner[0];

    ArrayAdapter<Spinner> arrListDesple = null;
    static boolean pasarOnPause = false;
   public static String[] arrDesEjercicios = new String[0];
   public static ArrayList<ArrayAdapter<String>> arrAdaptadores = new ArrayList<>();

    static ArrayAdapter<String> adapterDesplePaused0 = null;
    static ArrayAdapter<String> adapterDesplePaused1 = null;
    static ArrayAdapter<String> adapterDesplePaused2 = null;
    static ArrayAdapter<String> adapterDesplePaused3 = null;
    static ArrayAdapter<String> adapterDesplePaused4 = null;
    static ArrayAdapter<String> adapterDesplePaused5 = null;
    static ArrayAdapter<String> adapterDesplePaused6 = null;
    static ArrayAdapter<String> adapterDesplePaused7 = null;
    static ArrayAdapter<String> adapterDesplePaused8 = null;
    static ArrayAdapter<String> adapterDesplePaused9 = null;
    static ArrayAdapter<String> adapterDesplePaused10 = null;
    static ArrayAdapter<String> adapterDesplePaused11 = null;
    static ArrayAdapter<String> adapterDesplePaused12 = null;


    //ALMACENAR DATOS PARA CAMBIAR DE ACTIVITY
    static String dato0 = "";
    static String dato1 = "";
    static String dato2 = "";
    static String dato3 = "";
    static String dato4 = "";
    static String dato5 = "";
    static String dato6 = "";
    static String dato7 = "";
    static String dato8 = "";
    static String dato9 = "";
    static String dato10 = "";
    static String dato11 = "";
    static String dato12 = "";

    static String datoSpinerGrupo1 = "";
    static String datoSpinerGrupo2 = "";
    static String datoSpinerGrupo3 = "";
    static String datoSpinerGrupo4 = "";

    static String datoSpinerMusculo0 = "";
    static String datoSpinerMusculo1 = "";
    static String datoSpinerMusculo2 = "";
    static String datoSpinerMusculo3 = "";
    static String datoSpinerMusculo4 = "";
    static String datoSpinerMusculo5 = "";
    static String datoSpinerMusculo6 = "";
    static String datoSpinerMusculo7 = "";
    static String datoSpinerMusculo8 = "";
    static String datoSpinerMusculo9 = "";
    static String datoSpinerMusculo10 = "";
    static String datoSpinerMusculo11 = "";
    static String datoSpinerMusculo12 = "";

    static String[] arrayDatos = {dato0, dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12};

    //---------------------------------------------------------------------------------------

    //DECLARACION DE ADAPTERS DE EJERCICIOS

    static ArrayAdapter<CharSequence> EjercicioDiaPecho = null;
    static ArrayAdapter<CharSequence> EjercicioDiaHombro = null;
    static ArrayAdapter<CharSequence> EjercicioDiaBiceps = null;
    static ArrayAdapter<CharSequence> EjercicioDiaTriceps = null;
    static ArrayAdapter<CharSequence> EjercicioDiaEspalda = null;
    static ArrayAdapter<CharSequence> EjercicioDiaPierna = null;
    static ArrayAdapter<CharSequence> EjercicioDiaFemoral = null;
    static ArrayAdapter<CharSequence> EjercicioDiaAductores = null;

    static ArrayAdapter<CharSequence> EjercicioDiaGemelo = null;
    static ArrayAdapter<CharSequence> EjercicioDiaTrapecio = null;
    static ArrayAdapter<CharSequence> adapterTrapecio = null;
    static ArrayAdapter<CharSequence> adapterHombro = null;
    static ArrayAdapter<CharSequence> adapterAductores = null;
    static ArrayAdapter<CharSequence> adapterGemelo = null;
    static ArrayAdapter<CharSequence> adapterPierna = null;
    static ArrayAdapter<CharSequence> adapterFemoral = null;
    static ArrayAdapter<CharSequence> adapterVacio = null;
    static ArrayAdapter<CharSequence> adapterPecho = null;
    static ArrayAdapter<CharSequence> adapterBiceps = null;
    static ArrayAdapter<CharSequence> adapterEspalda = null;
    static ArrayAdapter<CharSequence> adapterTriceps = null;
    static ArrayAdapter<CharSequence> adapterDias = null;


    //CREACION DE OBJETOS
    static Modelo obj;
    static PechoO p;
    static AductoresO a;
    static BicepsO b;
    static EspaldaO esp;
    static FemoralO f;
    static GemeloO ge;
    static HombroO hom;
    static PiernaO pie;
    static TrapecioO tra;
    static TricepsO tri;

    //-----------------------------------------------------------------------------------------------------

    //DECLARACION DE LOS TEXTVIEW

    static TextView text0 = null;
    static TextView text1 = null;
    static TextView text2 = null;
    static TextView text3 = null;
    static TextView text4 = null;
    static TextView text5 = null;
    static TextView text6 = null;
    static TextView text7 = null;
    static TextView text8 = null;
    static TextView text9 = null;
    static TextView text10 = null;
    static TextView text11 = null;
    static TextView text12 = null;

    //--------------------------------------------------------------------------------------------

    //Declaramos los desplegables de los grupos musculares

    static Spinner despleMusculo1 = null;
    static Spinner despleMusculo2 = null;
    static Spinner despleMusculo3 = null;
    static Spinner despleMusculo4 = null;

    //--------------------------------------------------------------------------------------------

    //Declaramos los desplegables de los musculos

    static Spinner despl0 = null;
    static Spinner despl1 = null;
    static Spinner despl2 = null;
    static Spinner despl3 = null;
    static Spinner despl4 = null;
    static Spinner despl5 = null;
    static Spinner despl6 = null;
    static Spinner despl7 = null;
    static Spinner despl8 = null;
    static Spinner despl9 = null;
    static Spinner despl10 = null;
    static Spinner despl11 = null;
    static Spinner despl12 = null;


    //--------------------------------------------------------------------------------------------

    //DECLARACION DE VARIABLE DE MUSCULOS

    //Pecho
    public static String PressPlanoMaquina = "";
    public static String PressInclinado = "";
    public static String Contractora = "";
    public static String Flexiones = "";

    //Hombro
    public static String ElevacionesLatMancuernas = "";

    //Biceps
    public static String CurlAlternoPie = "";
    public static String CurlInvertido = "";

    //Espalda
    public static String PullOver = "";
    public static String RackPull = "";
    public static String JalonPecho = "";
    public static String RemoBarra = "";
    public static String RemoT = "";

    //Triceps
    public static String PressFrancesTumbado = "";
    public static String PressFrancesSentado = "";
    public static String TironPoleaEncimaDeLaCabeza = "";

    //Femoral
    public static String FemoralTumbado = "";

    //Pierna
    public static String ExtensionCuádriceps = "";
    public static String HackSquad = "";
    public static String Prensa = "";
    public static String PrensaUnaPierna = "";

    //Aductores
    public static String Aductores = "";

    //Gemelo
    public static String GemeloEnPrensa = "";
    public static String GemeloUnaPierna = "";

    //Hombro
    public static String Pajaro = "";
    public static String PressMaquina = "";
    public static String LateralesSentado = "";
    public static String LateralesPolea = "";

    //Trapecio
    public static String EncogimientoPesado = "";

    //-------------------------------------------------------------------------------

    //Cronometro
    public static boolean isOn = false;
    public static int mili = 0;
    public static int seg = 0;
    public static int min = 0;
    public static Handler h = new Handler();


    static TextView reloj =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);


        //Funcionalidad de cronometro
        //Cronometro
        ImageButton start = findViewById(R.id.Start);
        ImageButton stop = findViewById(R.id.Stop);
        ImageButton reset = findViewById(R.id.reset);
         reloj = findViewById(R.id.reloj);


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

        relojFuncional();

        //Declaramos los desplegables de los musculos

        despleMusculo1 = findViewById(R.id.despleMusuculouno);
        despleMusculo2 = findViewById(R.id.despleMusuculodos);
        despleMusculo3 = findViewById(R.id.despleMusuculotres);
        despleMusculo4 = findViewById(R.id.despleMusuculocuatro);

        //Declaramos los desplegables de los ejercicios

        despl0 = findViewById(R.id.cero);
        despl1 = findViewById(R.id.uno);
        despl2 = findViewById(R.id.dos);
        despl3 = findViewById(R.id.tres);
        despl4 = findViewById(R.id.cuatro);
        despl5 = findViewById(R.id.cinco);
        despl6 = findViewById(R.id.seix);
        despl7 = findViewById(R.id.siete);
        despl8 = findViewById(R.id.ocho);
        despl9 = findViewById(R.id.nueve);
        despl10 = findViewById(R.id.diez);
        despl11 = findViewById(R.id.once);
        despl12 = findViewById(R.id.doce);


        //Declaramos los text de cada desplegable de ejercicios

        text0 = findViewById(R.id.textcero);
        text1 = findViewById(R.id.textUno);
        text2 = findViewById(R.id.textDos);
        text3 = findViewById(R.id.textTres);
        text4 = findViewById(R.id.textcuatro);
        text5 = findViewById(R.id.textCinco);
        text6 = findViewById(R.id.textSeix);
        text7 = findViewById(R.id.textSiete);
        text8 = findViewById(R.id.textOcho);
        text9 = findViewById(R.id.textnueve);
        text10 = findViewById(R.id.textDiez);
        text11 = findViewById(R.id.textOnce);
        text12 = findViewById(R.id.textDoce);


        //Declaramos el Boton enviar
        Button botonEnviar = findViewById(R.id.enviar);

        //Creamos array de texto
        TextView[] arrayText = {text0, text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12};

        //Creamos el array de ejercicios

        String[] arrayEjer = {"PressPlanoMaquina", "PressInclinado", "Contractora", "Flexiones", "ElevacionesLatMancuernas",
                "CurlAlternoPie", "CurlInvertido", "PullOver", "RackPull", "JalonPecho", "RemoBarra", "RemoT", "PressFrancesTumbado",
                "PressFrancesSentado", "TironPoleaEncimaDeLaCabeza", "FemoralTumbado", "ExtensionCuádriceps", "HackSquad", "Prensa", "PrensaUnaPierna", "Aductores", "GemeloEnPrensa",
                "GemeloUnaPierna", "Pajaro", "PressMaquina", "LateralesSentado", "LateralesPolea", "EncogimientoPesado"};

        arrDesEjercicios = new String[arrayEjer.length];
        //Creamos el array de los grupos musculares

        Spinner[] arrayDesplegablesDias = {despleMusculo1, despleMusculo2, despleMusculo3, despleMusculo4};
        adapterDias = ArrayAdapter.createFromResource(this, R.array.diaEj, android.R.layout.simple_spinner_item);
        adapterDias.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Bucle para meter los grupos musculares en los desplegables

        for (int i = 0; i < arrayDesplegablesDias.length; i++) {
            arrayDesplegablesDias[i].setAdapter(adapterDias);
        }

        //Bucle para meter los ejecicios en los desplegables

        Spinner[] arrayDesplegablesEjercicios = {despl0, despl1, despl2, despl3, despl4, despl5, despl6, despl7, despl8, despl9, despl10, despl11, despl12};

        arrDesple = new Spinner[arrayDesplegablesEjercicios.length];
        //Vacio
        ArrayAdapter<CharSequence> adapterVacio = ArrayAdapter.createFromResource(this, R.array.vacio, android.R.layout.simple_spinner_item);
        adapterVacio.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Declaramos todos los desplegables de ejercicios en vacio

        for (int i = 0; i < arrayDesplegablesEjercicios.length; i++) {
            arrayDesplegablesEjercicios[i].setAdapter(adapterVacio);
        }

        //--------------------------------------------------------------------------------------------------------

        //ADAPTER DE CADA DIA DE MUSCULO
        EjercicioDiaPecho = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaPecho, android.R.layout.simple_spinner_item);
        EjercicioDiaPecho.setDropDownViewResource(android.R.layout.simple_spinner_item);

        EjercicioDiaHombro = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaHombro, android.R.layout.simple_spinner_item);
        EjercicioDiaHombro.setDropDownViewResource(android.R.layout.simple_spinner_item);

        EjercicioDiaBiceps = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaBiceps, android.R.layout.simple_spinner_item);
        EjercicioDiaBiceps.setDropDownViewResource(android.R.layout.simple_spinner_item);

        EjercicioDiaTriceps = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaTriceps, android.R.layout.simple_spinner_item);
        EjercicioDiaTriceps.setDropDownViewResource(android.R.layout.simple_spinner_item);

        EjercicioDiaEspalda = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaEspalda, android.R.layout.simple_spinner_item);
        EjercicioDiaEspalda.setDropDownViewResource(android.R.layout.simple_spinner_item);

        EjercicioDiaPierna = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaPierna, android.R.layout.simple_spinner_item);
        EjercicioDiaPierna.setDropDownViewResource(android.R.layout.simple_spinner_item);

        EjercicioDiaFemoral = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaFemoral, android.R.layout.simple_spinner_item);
        EjercicioDiaFemoral.setDropDownViewResource(android.R.layout.simple_spinner_item);

        EjercicioDiaAductores = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaAductores, android.R.layout.simple_spinner_item);
        EjercicioDiaAductores.setDropDownViewResource(android.R.layout.simple_spinner_item);

        EjercicioDiaGemelo = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaGemelo, android.R.layout.simple_spinner_item);
        EjercicioDiaGemelo.setDropDownViewResource(android.R.layout.simple_spinner_item);

        EjercicioDiaTrapecio = ArrayAdapter.createFromResource(this, R.array.EjercicioDiaTrapecio, android.R.layout.simple_spinner_item);
        EjercicioDiaTrapecio.setDropDownViewResource(android.R.layout.simple_spinner_item);




        //--------------------------------------------------------------------------------------------------------------

        if(pasarOnPause == false) {


            //Pecho
            adapterPecho = ArrayAdapter.createFromResource(this, R.array.EjercicioPecho, android.R.layout.simple_spinner_item);
            adapterPecho.setDropDownViewResource(android.R.layout.simple_spinner_item);

            //Biceps
            adapterBiceps = ArrayAdapter.createFromResource(this, R.array.EjercicioBiceps, android.R.layout.simple_spinner_item);
            adapterBiceps.setDropDownViewResource(android.R.layout.simple_spinner_item);

            //Espalda
            adapterEspalda = ArrayAdapter.createFromResource(this, R.array.EjercicioEspalda, android.R.layout.simple_spinner_item);
            adapterEspalda.setDropDownViewResource(android.R.layout.simple_spinner_item);

            //Triceps
            adapterTriceps = ArrayAdapter.createFromResource(this, R.array.EjercicioTricpes, android.R.layout.simple_spinner_item);
            adapterTriceps.setDropDownViewResource(android.R.layout.simple_spinner_item);

            //Femoral
            adapterFemoral = ArrayAdapter.createFromResource(this, R.array.EjercicioFemoral, android.R.layout.simple_spinner_item);
            adapterFemoral.setDropDownViewResource(android.R.layout.simple_spinner_item);

            //Pierna
            adapterPierna = ArrayAdapter.createFromResource(this, R.array.EjercicioPierna, android.R.layout.simple_spinner_item);
            adapterPierna.setDropDownViewResource(android.R.layout.simple_spinner_item);

            //Aductores
            adapterAductores = ArrayAdapter.createFromResource(this, R.array.EjercicioAductores, android.R.layout.simple_spinner_item);
            adapterAductores.setDropDownViewResource(android.R.layout.simple_spinner_item);

            //Gemelo
            adapterGemelo = ArrayAdapter.createFromResource(this, R.array.EjercicioGemelo, android.R.layout.simple_spinner_item);
            adapterGemelo.setDropDownViewResource(android.R.layout.simple_spinner_item);

            //Hombro
            adapterHombro = ArrayAdapter.createFromResource(this, R.array.EjercicioHombro, android.R.layout.simple_spinner_item);
            adapterHombro.setDropDownViewResource(android.R.layout.simple_spinner_item);

            //Trapecio
            adapterTrapecio = ArrayAdapter.createFromResource(this, R.array.EjercicioTrapecio, android.R.layout.simple_spinner_item);
            adapterTrapecio.setDropDownViewResource(android.R.layout.simple_spinner_item);
        }

        //------------------------------------------------------------------------------------------
        //Desplegables grupos musculares para cambiar los musculos dependiendo del grupo musculas

        despleMusculo1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = despleMusculo1.getSelectedItem().toString();

                switch (seleccion) {
                    case "Seleccione una opcion":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterVacio);
                        }
                        break;
                    case "Pecho":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterPecho);
                        }
                        break;
                    case "Hombro":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterHombro);
                        }
                        break;
                    case "Biceps":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterBiceps);
                        }
                        break;
                    case "Triceps":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterTriceps);
                        }
                        break;
                    case "Espalda":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterEspalda);
                        }
                        break;
                    case "Pierna":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterPierna);
                        }
                        break;
                    case "Femoral":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterFemoral);
                        }
                        break;
                    case "Aductores":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterAductores);
                        }
                        break;
                    case "Gemelo":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterGemelo);
                        }
                        break;
                    case "Trapecio":

                        for (i = 0; i < 5; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterTrapecio);
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.e("Seleccion nula", "Tienes que seleccionar un item");
            }
        });

        despleMusculo2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = despleMusculo2.getSelectedItem().toString();

                switch (seleccion) {
                    case "Seleccione una opcion":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterVacio);
                        }
                        break;
                    case "Pecho":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterPecho);
                        }
                        break;
                    case "Hombro":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterHombro);
                        }
                        break;
                    case "Biceps":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterBiceps);
                        }
                        break;
                    case "Triceps":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterTriceps);
                        }
                        break;
                    case "Espalda":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterEspalda);
                        }
                        break;
                    case "Pierna":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterPierna);
                        }
                        break;
                    case "Femoral":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterFemoral);
                        }
                        break;
                    case "Aductores":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterAductores);
                        }
                        break;
                    case "Gemelo":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterGemelo);
                        }
                        break;
                    case "Trapecio":

                        for (i = 5; i < 9; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterTrapecio);
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.e("Seleccion nula", "Tienes que seleccionar un item");
            }
        });

        despleMusculo3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = despleMusculo3.getSelectedItem().toString();

                switch (seleccion) {
                    case "Seleccione una opcion":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterVacio);
                        }
                        break;
                    case "Pecho":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterPecho);
                        }
                        break;
                    case "Hombro":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterHombro);
                        }
                        break;
                    case "Biceps":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterBiceps);
                        }
                        break;
                    case "Triceps":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterTriceps);
                        }
                        break;
                    case "Espalda":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterEspalda);
                        }
                        break;
                    case "Pierna":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterPierna);
                        }
                        break;
                    case "Femoral":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterFemoral);
                        }
                        break;
                    case "Aductores":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterAductores);
                        }
                        break;
                    case "Gemelo":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterGemelo);
                        }
                        break;
                    case "Trapecio":

                        for (i = 9; i < 12; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterTrapecio);
                        }
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.e("Seleccion nula", "Tienes que seleccionar un item");
            }
        });

        despleMusculo4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = despleMusculo4.getSelectedItem().toString();

                switch (seleccion) {
                    case "Seleccione una opcion":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterVacio);
                        }
                        break;
                    case "Pecho":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterPecho);
                        }
                        break;
                    case "Hombro":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterHombro);
                        }
                        break;
                    case "Biceps":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterBiceps);
                        }
                        break;
                    case "Triceps":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterTriceps);
                        }
                        break;
                    case "Espalda":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterEspalda);
                        }
                        break;
                    case "Pierna":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterPierna);
                        }
                        break;
                    case "Femoral":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterFemoral);
                        }
                        break;
                    case "Aductores":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterAductores);
                        }
                        break;
                    case "Gemelo":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterGemelo);
                        }
                        break;
                    case "Trapecio":

                        for (i = 12; i < 13; i++) {

                            arrayDesplegablesEjercicios[i].setAdapter(adapterTrapecio);
                        }
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.e("Seleccion nula", "Tienes que seleccionar un item");
            }
        });

        //-------------------------------------------------------------------------------------
        //Boton enviar


        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int resInsert = 0;
                obj = new Modelo();
                String resultLog = "";
                String result = "";

                //Creamos un bucle para recorrer los desplegables

                for (int i = 0; i < arrayDesplegablesEjercicios.length; i++) {

                    String nombreEj = arrayDesplegablesEjercicios[i].getSelectedItem().toString();

                    switch (nombreEj) {
                        case "Press plano maquina":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("PressPlanoMaquina")) {
                                    PressPlanoMaquina = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressPlanoMaquina;
                            break;
                        case "Press inclinado":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("PressInclinado")) {
                                    PressInclinado = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressInclinado;
                            break;
                        case "Contractora":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("Contractora")) {
                                    Contractora = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Contractora;
                            break;
                        case "Flexiones":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("Flexiones")) {
                                    Flexiones = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Flexiones;
                            break;
                        case "Curl alterno de pie":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("CurlAlternoPie")) {
                                    CurlAlternoPie = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + CurlAlternoPie;
                            break;
                        case "Curl invertido":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("CurlInvertido")) {
                                    CurlInvertido = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + CurlInvertido;
                            break;
                        case "Pull over":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("PullOver")) {
                                    PullOver = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PullOver;
                            break;
                        case "Rack pull":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("RackPull")) {
                                    RackPull = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + RackPull;
                            break;
                        case "Jalon al pecho":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("JalonPecho")) {
                                    JalonPecho = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + JalonPecho;
                            break;
                        case "Remo con barra":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("RemoBarra")) {
                                    RemoBarra = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + RemoBarra;
                            break;
                        case "Remo en T":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("RemoT")) {
                                    RemoT = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + RemoT;
                            break;
                        case "Press frances tumbado":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("PressFrancesTumbado")) {
                                    PressFrancesTumbado = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressFrancesTumbado;
                            break;
                        case "Press frances sentado":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("PressFrancesSentado")) {
                                    PressFrancesSentado = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressFrancesSentado;
                            break;
                        case "Tiron de polea encima de la cabeza":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("TironPoleaEncimaDeLaCabeza")) {
                                    TironPoleaEncimaDeLaCabeza = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + TironPoleaEncimaDeLaCabeza;
                            break;
                        case "Femoral tumbado":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("FemoralTumbado")) {
                                    FemoralTumbado = arrayText[i].getText().toString();

                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + FemoralTumbado;
                            break;
                        case "Extension de cuádriceps":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("ExtensionCuádriceps")) {
                                    ExtensionCuádriceps = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + ExtensionCuádriceps;
                            break;
                        case "Hack squad":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("HackSquad")) {
                                    HackSquad = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + HackSquad;
                            break;
                        case "Prensa":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("Prensa")) {
                                    Prensa = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Prensa;
                            break;
                        case "PrensaUnaPierna":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("PrensaUnaPierna")) {
                                    PrensaUnaPierna = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PrensaUnaPierna;
                            break;
                        case "Aductores":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("Aductores")) {
                                    Aductores = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Aductores;
                            break;
                        case "Gemelo en prensa":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("GemeloEnPrensa")) {
                                    GemeloEnPrensa = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PrensaUnaPierna;
                            break;
                        case "Gemelo a una pierna":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("GemeloUnaPierna")) {
                                    GemeloUnaPierna = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + GemeloUnaPierna;
                            break;
                        case "Pajaro":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("Pajaro")) {
                                    Pajaro = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + Pajaro;
                            break;
                        case "Elevaciones lat Mancuernas":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("ElevacionesLatMancuernas")) {
                                    ElevacionesLatMancuernas = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + ElevacionesLatMancuernas;
                            break;
                        case "Press en maquina":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("PressMaquina")) {
                                    PressMaquina = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + PressMaquina;
                            break;
                        case "Laterales sentado":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("LateralesSentado")) {
                                    LateralesSentado = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + LateralesSentado;
                            break;
                        case "Laterales en polea":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("LateralesPolea")) {
                                    LateralesPolea = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + LateralesPolea;
                            break;
                        case "Encogimiento pesado":
                            for (int j = 0; j < arrayEjer.length; j++) {

                                if (arrayEjer[j].toString().equals("EncogimientoPesado")) {
                                    EncogimientoPesado = arrayText[i].getText().toString();
                                    break;
                                }
                            }
                            resultLog = "En el ejercicio: " + arrayDesplegablesEjercicios[i].getSelectedItem().toString() + " he levantado: " + EncogimientoPesado;
                            break;
                        case " ":
                            resultLog = "Desplegable vacio";
                    }

                    Log.e("Result", resultLog);


                }


                //PECHO
                if (!PressPlanoMaquina.isEmpty() && !PressInclinado.isEmpty() && !Contractora.isEmpty() && !Flexiones.isEmpty()) {
                    p = new PechoO(PressPlanoMaquina, PressInclinado, Contractora, Flexiones);
                    resInsert = obj.insertaPesoPecho(EntrenamientoActivity.this, p);
                    PressPlanoMaquina = "";
                    PressInclinado = "";
                    Contractora = "";
                    Flexiones = "";

                } else if (!PressPlanoMaquina.isEmpty() && !PressInclinado.isEmpty() && !Contractora.isEmpty()) {
                    p = new PechoO(PressPlanoMaquina, PressInclinado, Contractora, "");
                    resInsert = obj.insertaPesoPecho(EntrenamientoActivity.this, p);
                    PressPlanoMaquina = "";
                    PressInclinado = "";
                    Contractora = "";
                    Flexiones = "";

                } else if (!PressPlanoMaquina.isEmpty() && !PressInclinado.isEmpty() && Contractora.isEmpty() && Flexiones.isEmpty()) {
                    p = new PechoO(PressPlanoMaquina, PressInclinado, "", "");
                    resInsert = obj.insertaPesoPecho(EntrenamientoActivity.this, p);
                    PressPlanoMaquina = "";
                    PressInclinado = "";
                    Contractora = "";
                    Flexiones = "";

                } else if (!PressPlanoMaquina.isEmpty() && PressInclinado.isEmpty() && Contractora.isEmpty() && Flexiones.isEmpty()) {
                    p = new PechoO(PressPlanoMaquina, "", "", "");
                    resInsert = obj.insertaPesoPecho(EntrenamientoActivity.this, p);
                    PressPlanoMaquina = "";
                    PressInclinado = "";
                    Contractora = "";
                    Flexiones = "";
                }

                //ADUCTORES
                if (!Aductores.isEmpty()) {
                    a = new AductoresO(Aductores);
                    resInsert = obj.insertaPesoAductores(EntrenamientoActivity.this, a);
                    Aductores = "";
                }

                //GEMELO
                if (!GemeloEnPrensa.isEmpty() && !GemeloUnaPierna.isEmpty()) {
                    ge = new GemeloO(GemeloEnPrensa, GemeloUnaPierna);
                    resInsert = obj.insertaPesoGemelo(EntrenamientoActivity.this, ge);
                    GemeloEnPrensa = "";
                    GemeloUnaPierna = "";

                } else if (!GemeloEnPrensa.isEmpty() && GemeloUnaPierna.isEmpty()) {
                    ge = new GemeloO(GemeloEnPrensa, "");
                    resInsert = obj.insertaPesoGemelo(EntrenamientoActivity.this, ge);
                    GemeloEnPrensa = "";
                    GemeloUnaPierna = "";
                }

                //FEMORAL
                if (!FemoralTumbado.isEmpty()) {
                    f = new FemoralO(FemoralTumbado);
                    resInsert = obj.insertaPesoFemoral(EntrenamientoActivity.this, f);
                    FemoralTumbado = "";
                }

                //PIERNA
                if (!ExtensionCuádriceps.isEmpty() && !HackSquad.isEmpty() && !Prensa.isEmpty() && !PrensaUnaPierna.isEmpty()) {
                    pie = new PiernaO(ExtensionCuádriceps, HackSquad, Prensa, PrensaUnaPierna);
                    resInsert = obj.insertaPesoPierna(EntrenamientoActivity.this, pie);
                    ExtensionCuádriceps = "";
                    HackSquad = "";
                    Prensa = "";
                    PrensaUnaPierna = "";

                } else if (!ExtensionCuádriceps.isEmpty() && !HackSquad.isEmpty() && Prensa.isEmpty() && !PrensaUnaPierna.isEmpty()) {
                    pie = new PiernaO(ExtensionCuádriceps, HackSquad, "", PrensaUnaPierna);
                    resInsert = obj.insertaPesoPierna(EntrenamientoActivity.this, pie);
                    ExtensionCuádriceps = "";
                    HackSquad = "";
                    Prensa = "";
                    PrensaUnaPierna = "";

                } else if (!ExtensionCuádriceps.isEmpty() && !HackSquad.isEmpty() && !Prensa.isEmpty() && PrensaUnaPierna.isEmpty()) {
                    pie = new PiernaO(ExtensionCuádriceps, HackSquad, Prensa, "");
                    resInsert = obj.insertaPesoPierna(EntrenamientoActivity.this, pie);
                    ExtensionCuádriceps = "";
                    HackSquad = "";
                    Prensa = "";
                    PrensaUnaPierna = "";

                } else if (!ExtensionCuádriceps.isEmpty() && !HackSquad.isEmpty() && Prensa.isEmpty() && PrensaUnaPierna.isEmpty()) {
                    pie = new PiernaO(ExtensionCuádriceps, HackSquad, "", "");
                    resInsert = obj.insertaPesoPierna(EntrenamientoActivity.this, pie);
                    ExtensionCuádriceps = "";
                    HackSquad = "";
                    Prensa = "";
                    PrensaUnaPierna = "";

                } else if (!ExtensionCuádriceps.isEmpty() && HackSquad.isEmpty() && !Prensa.isEmpty() && PrensaUnaPierna.isEmpty()) {
                    pie = new PiernaO(ExtensionCuádriceps, "", Prensa, "");
                    resInsert = obj.insertaPesoPierna(EntrenamientoActivity.this, pie);
                    ExtensionCuádriceps = "";
                    HackSquad = "";
                    Prensa = "";
                    PrensaUnaPierna = "";

                } else if (!ExtensionCuádriceps.isEmpty() && HackSquad.isEmpty() && Prensa.isEmpty() && PrensaUnaPierna.isEmpty()) {
                    pie = new PiernaO(ExtensionCuádriceps, "", "", "");
                    resInsert = obj.insertaPesoPierna(EntrenamientoActivity.this, pie);
                    ExtensionCuádriceps = "";
                    HackSquad = "";
                    Prensa = "";
                    PrensaUnaPierna = "";
                }

                //ESPALDA
                if (!PullOver.isEmpty() && !RackPull.isEmpty() && !JalonPecho.isEmpty() && !RemoBarra.isEmpty() && !RemoT.isEmpty()) {
                    esp = new EspaldaO(PullOver, RackPull, JalonPecho, RemoBarra, RemoT);
                    resInsert = obj.insertaPesoEspalda(EntrenamientoActivity.this, esp);
                    PullOver = "";
                    RackPull = "";
                    JalonPecho = "";
                    RemoBarra = "";
                    RemoT = "";

                } else if (!PullOver.isEmpty() && !RackPull.isEmpty() && !JalonPecho.isEmpty() && !RemoBarra.isEmpty() && RemoT.isEmpty()) {
                    esp = new EspaldaO(PullOver, RackPull, JalonPecho, RemoBarra, "");
                    resInsert = obj.insertaPesoEspalda(EntrenamientoActivity.this, esp);
                    PullOver = "";
                    RackPull = "";
                    JalonPecho = "";
                    RemoBarra = "";
                    RemoT = "";

                } else if (!PullOver.isEmpty() && !RackPull.isEmpty() && !JalonPecho.isEmpty() && RemoBarra.isEmpty() && RemoT.isEmpty()) {
                    esp = new EspaldaO(PullOver, RackPull, JalonPecho, "", "");
                    resInsert = obj.insertaPesoEspalda(EntrenamientoActivity.this, esp);
                    PullOver = "";
                    RackPull = "";
                    JalonPecho = "";
                    RemoBarra = "";
                    RemoT = "";

                } else if (!PullOver.isEmpty() && !RackPull.isEmpty() && JalonPecho.isEmpty() && RemoBarra.isEmpty() && RemoT.isEmpty()) {
                    esp = new EspaldaO(PullOver, RackPull, "", "", "");
                    resInsert = obj.insertaPesoEspalda(EntrenamientoActivity.this, esp);
                    PullOver = "";
                    RackPull = "";
                    JalonPecho = "";
                    RemoBarra = "";
                    RemoT = "";

                } else if (!PullOver.isEmpty() && RackPull.isEmpty() && JalonPecho.isEmpty() && RemoBarra.isEmpty() && RemoT.isEmpty()) {
                    esp = new EspaldaO(PullOver, "", "", "", "");
                    resInsert = obj.insertaPesoEspalda(EntrenamientoActivity.this, esp);
                    PullOver = "";
                    RackPull = "";
                    JalonPecho = "";
                    RemoBarra = "";
                    RemoT = "";
                }

                //HOMBRO
                if (!ElevacionesLatMancuernas.isEmpty() && !Pajaro.isEmpty() && !PressMaquina.isEmpty() && !LateralesSentado.isEmpty() && !LateralesPolea.isEmpty()) {
                    hom = new HombroO(ElevacionesLatMancuernas, Pajaro, PressMaquina, LateralesSentado, LateralesPolea);
                    resInsert = obj.insertaPesoHombro(EntrenamientoActivity.this, hom);
                    ElevacionesLatMancuernas = "";
                    Pajaro = "";
                    PressMaquina = "";
                    LateralesSentado = "";
                    LateralesPolea = "";

                } else if (!ElevacionesLatMancuernas.isEmpty() && !Pajaro.isEmpty() && !PressMaquina.isEmpty() && !LateralesSentado.isEmpty() && LateralesPolea.isEmpty()) {
                    hom = new HombroO(ElevacionesLatMancuernas, Pajaro, PressMaquina, LateralesSentado, "");
                    resInsert = obj.insertaPesoHombro(EntrenamientoActivity.this, hom);
                    ElevacionesLatMancuernas = "";
                    Pajaro = "";
                    PressMaquina = "";
                    LateralesSentado = "";
                    LateralesPolea = "";

                } else if (!ElevacionesLatMancuernas.isEmpty() && !Pajaro.isEmpty() && !PressMaquina.isEmpty() && LateralesSentado.isEmpty() && LateralesPolea.isEmpty()) {
                    hom = new HombroO(ElevacionesLatMancuernas, Pajaro, PressMaquina, "", "");
                    resInsert = obj.insertaPesoHombro(EntrenamientoActivity.this, hom);
                    ElevacionesLatMancuernas = "";
                    Pajaro = "";
                    PressMaquina = "";
                    LateralesSentado = "";
                    LateralesPolea = "";

                } else if (!ElevacionesLatMancuernas.isEmpty() && !Pajaro.isEmpty() && PressMaquina.isEmpty() && LateralesSentado.isEmpty() && LateralesPolea.isEmpty()) {
                    hom = new HombroO(ElevacionesLatMancuernas, Pajaro, "", "", "");
                    resInsert = obj.insertaPesoHombro(EntrenamientoActivity.this, hom);
                    ElevacionesLatMancuernas = "";
                    Pajaro = "";
                    PressMaquina = "";
                    LateralesSentado = "";
                    LateralesPolea = "";

                } else if (!ElevacionesLatMancuernas.isEmpty() && Pajaro.isEmpty() && PressMaquina.isEmpty() && LateralesSentado.isEmpty() && LateralesPolea.isEmpty()) {
                    hom = new HombroO(ElevacionesLatMancuernas, "", "", "", "");
                    resInsert = obj.insertaPesoHombro(EntrenamientoActivity.this, hom);
                    ElevacionesLatMancuernas = "";
                    Pajaro = "";
                    PressMaquina = "";
                    LateralesSentado = "";
                    LateralesPolea = "";
                }

                //BICEPS
                if (!CurlAlternoPie.isEmpty() && !CurlInvertido.isEmpty()) {
                    b = new BicepsO(CurlAlternoPie, CurlInvertido);
                    resInsert = obj.insertaPesoBiceps(EntrenamientoActivity.this, b);
                    CurlAlternoPie = "";
                    CurlInvertido = "";

                } else if (!CurlAlternoPie.isEmpty() && CurlInvertido.isEmpty()) {
                    b = new BicepsO(CurlAlternoPie, "");
                    resInsert = obj.insertaPesoBiceps(EntrenamientoActivity.this, b);
                    CurlAlternoPie = "";
                    CurlInvertido = "";
                }

                //TRAPECIO
                if (!EncogimientoPesado.isEmpty()) {
                    tra = new TrapecioO(EncogimientoPesado);
                    resInsert = obj.insertaPesoTrapecio(EntrenamientoActivity.this, tra);
                    EncogimientoPesado = "";
                }

                //TRICEPS
                if (!PressFrancesTumbado.isEmpty() && !PressFrancesSentado.isEmpty() && !TironPoleaEncimaDeLaCabeza.isEmpty()) {
                    tri = new TricepsO(PressFrancesTumbado, PressFrancesSentado, TironPoleaEncimaDeLaCabeza);
                    resInsert = obj.insertaPesoTriceps(EntrenamientoActivity.this, tri);
                    PressFrancesTumbado = "";
                    PressFrancesSentado = "";
                    TironPoleaEncimaDeLaCabeza = "";

                } else if (!PressFrancesTumbado.isEmpty() && !PressFrancesSentado.isEmpty() && TironPoleaEncimaDeLaCabeza.isEmpty()) {
                    tri = new TricepsO(PressFrancesTumbado, PressFrancesSentado, "");
                    resInsert = obj.insertaPesoTriceps(EntrenamientoActivity.this, tri);
                    PressFrancesTumbado = "";
                    PressFrancesSentado = "";
                    TironPoleaEncimaDeLaCabeza = "";

                } else if (!PressFrancesTumbado.isEmpty() && PressFrancesSentado.isEmpty() && TironPoleaEncimaDeLaCabeza.isEmpty()) {
                    tri = new TricepsO(PressFrancesTumbado, "", "");
                    resInsert = obj.insertaPesoTriceps(EntrenamientoActivity.this, tri);
                    PressFrancesTumbado = "";
                    PressFrancesSentado = "";
                    TironPoleaEncimaDeLaCabeza = "";
                }

                if (resInsert == 1) {
                    Toast.makeText(EntrenamientoActivity.this, "Enhorabuena has terminado el entrenamiento", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EntrenamientoActivity.this, "No enviado a la base de datos, error 404", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    @SuppressLint("ResourceType")
    @Override
    protected void onPause() {
        super.onPause();


        dato0 = text0.getText().toString();
        dato1 = text1.getText().toString();
        dato2 = text2.getText().toString();
        dato3 = text3.getText().toString();
        dato4 = text4.getText().toString();
        dato5 = text5.getText().toString();
        dato6 = text6.getText().toString();
        dato7 = text7.getText().toString();
        dato8 = text8.getText().toString();
        dato9 = text9.getText().toString();
        dato10 = text10.getText().toString();
        dato11 = text11.getText().toString();
        dato12 = text12.getText().toString();

        //DESPLEGABLES GRUPO MUSCULARES

        datoSpinerGrupo1 = despleMusculo1.getSelectedItem().toString();
        datoSpinerGrupo2 = despleMusculo2.getSelectedItem().toString();
        datoSpinerGrupo3 = (String) despleMusculo3.getSelectedItem();
        datoSpinerGrupo4 = (String) despleMusculo4.getSelectedItem();
        Log.e("ADAPTER", datoSpinerGrupo1);

        //-----------------------------------------------------------

        //DESPLEGABLES EJERCICIOS
        String datoDesp1Ejer = (String) despl0.getSelectedItem();
        String datoDesp2Ejer = (String) despl1.getSelectedItem();
        String datoDesp3Ejer = (String) despl2.getSelectedItem();
        String datoDesp4Ejer = (String) despl3.getSelectedItem();
        String datoDesp5Ejer = despl4.getSelectedItem().toString();
        String datoDesp6Ejer = despl5.getSelectedItem().toString();
        String datoDesp7Ejer = despl6.getSelectedItem().toString();
        String datoDesp8Ejer = despl7.getSelectedItem().toString();
        String datoDesp9Ejer = despl8.getSelectedItem().toString();
        String datoDesp10Ejer = despl9.getSelectedItem().toString();
        String datoDesp11Ejer = despl10.getSelectedItem().toString();
        String datoDesp12Ejer = despl11.getSelectedItem().toString();
        String datoDesp13Ejer = despl12.getSelectedItem().toString();

        arrDesEjercicios[0] = datoDesp1Ejer;
        arrDesEjercicios[1] = datoDesp2Ejer;
        arrDesEjercicios[2] = datoDesp3Ejer;
        arrDesEjercicios[3] = datoDesp4Ejer;
        arrDesEjercicios[4] = datoDesp5Ejer;
        arrDesEjercicios[5] = datoDesp6Ejer;
        arrDesEjercicios[6] = datoDesp7Ejer;
        arrDesEjercicios[7] = datoDesp8Ejer;
        arrDesEjercicios[8] = datoDesp9Ejer;
        arrDesEjercicios[9] = datoDesp10Ejer;
        arrDesEjercicios[10] = datoDesp11Ejer;
        arrDesEjercicios[11] = datoDesp12Ejer;
        arrDesEjercicios[12] = datoDesp13Ejer;

        arrAdaptadores.add(adapterDesplePaused0);
        arrAdaptadores.add(adapterDesplePaused1);
        arrAdaptadores.add(adapterDesplePaused2);
        arrAdaptadores.add(adapterDesplePaused3);
        arrAdaptadores.add(adapterDesplePaused4);
        arrAdaptadores.add(adapterDesplePaused5);
        arrAdaptadores.add(adapterDesplePaused6);
        arrAdaptadores.add(adapterDesplePaused7);
        arrAdaptadores.add(adapterDesplePaused8);
        arrAdaptadores.add(adapterDesplePaused9);
        arrAdaptadores.add(adapterDesplePaused10);
        arrAdaptadores.add(adapterDesplePaused11);
        arrAdaptadores.add(adapterDesplePaused12);

       for(int i=0;i<arrDesEjercicios.length;i++){
           for(ArrayAdapter<String> arrAd : arrAdaptadores){
               arrAd = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrDesEjercicios);
               arrAd.setDropDownViewResource(android.R.layout.simple_spinner_item);
           }
           Log.e("ADAPTADORES", Arrays.toString(arrDesEjercicios));
       }

        //--------------------------------------------------------------------------------

        pasarOnPause = true;
    }

    @Override
    protected void onResume() {
        super.onResume();


        text0.setText(dato0);
        text1.setText(dato1);
        text2.setText(dato2);
        text3.setText(dato3);
        text4.setText(dato4);
        text5.setText(dato5);
        text6.setText(dato6);
        text7.setText(dato7);
        text8.setText(dato8);
        text9.setText(dato9);
        text10.setText(dato10);
        text11.setText(dato11);
        text12.setText(dato12);

        relojFuncional();



        if(pasarOnPause){
            switch (datoSpinerGrupo1){
                case "Pecho":despleMusculo1.setAdapter(EjercicioDiaPecho);break;
                case "Hombro":despleMusculo1.setAdapter(EjercicioDiaHombro);break;
                case "Biceps":despleMusculo1.setAdapter(EjercicioDiaBiceps);break;
                case "Triceps":despleMusculo1.setAdapter(EjercicioDiaTriceps);break;
                case "Espalda":despleMusculo1.setAdapter(EjercicioDiaEspalda);break;
                case "Pierna":despleMusculo1.setAdapter(EjercicioDiaPierna);break;
                case "Femoral":despleMusculo1.setAdapter(EjercicioDiaFemoral);break;
                case "Aductores":despleMusculo1.setAdapter(EjercicioDiaAductores);break;
                case "Gemelo":despleMusculo1.setAdapter(EjercicioDiaGemelo);break;
                case "Trapecio":despleMusculo1.setAdapter(EjercicioDiaTrapecio);break;
            }
            switch (datoSpinerGrupo2){
                case "Pecho":despleMusculo2.setAdapter(EjercicioDiaPecho);break;
                case "Hombro":despleMusculo2.setAdapter(EjercicioDiaHombro);break;
                case "Biceps":despleMusculo2.setAdapter(EjercicioDiaBiceps);break;
                case "Triceps":despleMusculo2.setAdapter(EjercicioDiaTriceps);break;
                case "Espalda":despleMusculo2.setAdapter(EjercicioDiaEspalda);break;
                case "Pierna":despleMusculo2.setAdapter(EjercicioDiaPierna);break;
                case "Femoral":despleMusculo2.setAdapter(EjercicioDiaFemoral);break;
                case "Aductores":despleMusculo2.setAdapter(EjercicioDiaAductores);break;
                case "Gemelo":despleMusculo2.setAdapter(EjercicioDiaGemelo);break;
                case "Trapecio":despleMusculo2.setAdapter(EjercicioDiaTrapecio);break;
            }
            switch (datoSpinerGrupo3){
                case "Pecho":despleMusculo3.setAdapter(EjercicioDiaPecho);break;
                case "Hombro":despleMusculo3.setAdapter(EjercicioDiaHombro);break;
                case "Biceps":despleMusculo3.setAdapter(EjercicioDiaBiceps);break;
                case "Triceps":despleMusculo3.setAdapter(EjercicioDiaTriceps);break;
                case "Espalda":despleMusculo3.setAdapter(EjercicioDiaEspalda);break;
                case "Pierna":despleMusculo3.setAdapter(EjercicioDiaPierna);break;
                case "Femoral":despleMusculo3.setAdapter(EjercicioDiaFemoral);break;
                case "Aductores":despleMusculo3.setAdapter(EjercicioDiaAductores);break;
                case "Gemelo":despleMusculo3.setAdapter(EjercicioDiaGemelo);break;
                case "Trapecio":despleMusculo3.setAdapter(EjercicioDiaTrapecio);break;
            }
            switch (datoSpinerGrupo4){
                case "Pecho":despleMusculo4.setAdapter(EjercicioDiaPecho);break;
                case "Hombro":despleMusculo4.setAdapter(EjercicioDiaHombro);break;
                case "Biceps":despleMusculo4.setAdapter(EjercicioDiaBiceps);break;
                case "Triceps":despleMusculo4.setAdapter(EjercicioDiaTriceps);break;
                case "Espalda":despleMusculo4.setAdapter(EjercicioDiaEspalda);break;
                case "Pierna":despleMusculo4.setAdapter(EjercicioDiaPierna);break;
                case "Femoral":despleMusculo4.setAdapter(EjercicioDiaFemoral);break;
                case "Aductores":despleMusculo4.setAdapter(EjercicioDiaAductores);break;
                case "Gemelo":despleMusculo4.setAdapter(EjercicioDiaGemelo);break;
                case "Trapecio":despleMusculo4.setAdapter(EjercicioDiaTrapecio);break;
            }





        }

    }
    private void relojFuncional(){
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
    }
}