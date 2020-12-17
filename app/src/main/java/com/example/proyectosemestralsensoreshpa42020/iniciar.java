package com.example.proyectosemestralsensoreshpa42020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class iniciar extends AppCompatActivity  {
Button acelerometro, gps, temperatura, volver, salir;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);

        volver = findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          startActivity(new Intent(iniciar.this, MainActivity.class));
                                      }
                                  });

        salir=findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent= new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        //seccion del acelerometro
        acelerometro=findViewById(R.id.acelerometro);
        acelerometro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(iniciar.this, Senacelero.class));
            }
        });

        gps=findViewById(R.id.gps);
        gps.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {                    //en vez de mainactivity poner el nombre del layout del gps
                startActivity(new Intent(iniciar.this, MainActivity.class));
            }
        });

        temperatura=findViewById(R.id.temperatura);
        temperatura.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {                    //en vez de mainactivity poner el nombre del layout de temperatura
                startActivity(new Intent(iniciar.this, MainActivity.class));
            }
        });

    }
}
