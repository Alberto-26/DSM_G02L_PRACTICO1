package com.example.taller_practico_1_tl160424;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickEjercicio1(View v){
        Intent llamar = new Intent(this,Ejercicio1.class);
        startActivity(llamar);
    }
    public void onClickEjercicio2(View v){
        Intent llamar = new Intent(this,Ejercicio2.class);
        startActivity(llamar);
    }
    public void Salir (View v){
        //Finalizando actividad
        finish();
    }
}