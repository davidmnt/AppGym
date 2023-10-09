package com.example.appgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PortadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
        Button botonComenzar = findViewById(R.id.comenzar);

        botonComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comenzar();
            }
        });
    }

    private void comenzar(){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }
}