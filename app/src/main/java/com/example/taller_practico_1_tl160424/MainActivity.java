package com.example.taller_practico_1_tl160424;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMenu(View v){
        Intent llamar = new Intent(this,Menu.class);
        startActivity(llamar);
    }
    public void finalizarActividad(View v){
        finish();
    }
}