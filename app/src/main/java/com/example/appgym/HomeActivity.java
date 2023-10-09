package com.example.appgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton botontablaEntrenamiento = findViewById(R.id.tablaEntrenamiento);
        ImageButton botontablaDieta = findViewById(R.id.tablaDieta);

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

    }

    private void mandartablaEntrenamiento(){
        Intent i = new Intent(this, TablaEntrenamientoActivity.class);
        startActivity(i);
    }

    private void mandartablaDieta(){
        Intent i = new Intent(this, TablaDietaActivity.class);
        startActivity(i);
    }
}