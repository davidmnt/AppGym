package com.example.appgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class EntrenamientoActivity extends AppCompatActivity {

    private boolean isOn = false;
    private int mili = 0;
    private int seg = 0;
    private int min = 0;
    private Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);
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
                while(true){
                    if(isOn){
                        try {
                            Thread.sleep(1);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        mili++;
                        if(mili==999){
                            seg++;
                            mili = 0;
                        }
                        if(seg == 59){
                            min++;
                            seg = 0;
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                String m ="";
                                String s="";
                                String mi = "";
                                if(mili<10){
                                    m="00"+mili;
                                }else if(mili<100){
                                    m = "0"+mili;
                                }else{
                                    m=""+mili;
                                }
                                if(seg<10){
                                    s="0"+seg;
                                }else{
                                    s = ""+seg;
                                }
                                if(min<10){
                                    mi = "0"+min;
                                }else {
                                    mi = ""+min;
                                }
                                reloj.setText(mi+":"+s+":"+m);
                            }
                        });

                    }
                }
            }
        });
       cronos.start();




        //Ejercicios

        Spinner despleMusculo1 = findViewById(R.id.despleMusuculouno);
        Spinner despleMusculo2 = findViewById(R.id.despleMusuculodos);

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

        Spinner[] arrayDesplegablesDias = {despleMusculo1,despleMusculo2};
        ArrayAdapter<CharSequence> adapterDias=ArrayAdapter.createFromResource(this, R.array.diaEj, android.R.layout.simple_spinner_item);
        adapterDias.setDropDownViewResource(android.R.layout.simple_spinner_item);

        for(int i = 0;i<arrayDesplegablesDias.length;i++){
            arrayDesplegablesDias[i].setAdapter(adapterDias);
        }

        Spinner[] arrayDesplegablesEjercicios = {despl1,despl2,despl3,despl4,despl5,despl6,despl7,despl8,despl9,despl10,despl11,despl12};
        ArrayAdapter<CharSequence> adapterEjercicios=ArrayAdapter.createFromResource(this, R.array.ejerciciosGym, android.R.layout.simple_spinner_item);
        adapterEjercicios.setDropDownViewResource(android.R.layout.simple_spinner_item);

        for (int i = 0; i< arrayDesplegablesEjercicios.length;i++){
            arrayDesplegablesEjercicios[i].setAdapter(adapterEjercicios);
        }


    }
}