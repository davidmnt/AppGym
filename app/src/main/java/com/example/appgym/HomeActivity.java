package com.example.appgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton botontablaEntrenamiento = findViewById(R.id.tablaEntrenamiento);
        ImageButton botontablaDieta = findViewById(R.id.tablaDieta);
        ImageButton entrenamiento = findViewById(R.id.entrenamiento);
        ImageButton resultados = findViewById(R.id.resultEntrenos);

        botontablaEntrenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandartablaEntrenamiento();
            }
        });

        botontablaDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandartablaDieta();
            }
        });

        entrenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandarEntrenamiento();
            }
        });

        resultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandarResultados();
            }
        });
    }

    private void mandartablaEntrenamiento(){
        Intent i = new Intent(this, TablaEntrenamientoActivity.class);
        startActivity(i);
    }

    private void mandartablaDieta(){
        Intent i = new Intent(this, TablaDietaActivity.class);
        startActivity(i);
    }

    private void mandarEntrenamiento(){
        Intent i = new Intent(this, EntrenamientoActivity.class);
        startActivity(i);
    }

    private void mandarResultados(){
        Intent i = new Intent(this, ResultadosActivity.class);
        startActivity(i);
    }
}