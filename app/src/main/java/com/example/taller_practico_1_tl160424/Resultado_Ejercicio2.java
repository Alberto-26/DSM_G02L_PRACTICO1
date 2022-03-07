package com.example.taller_practico_1_tl160424;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado_Ejercicio2 extends AppCompatActivity {

        //Creacion de las variables direccionadas a los elementos del activity que se mostraran
        private TextView texta;
        private TextView textb;
        private TextView textc;
        private TextView textx1a;
        private TextView textx1b;
        private TextView textx2a;
        private TextView textx2b;
        private TextView comp1;
        private TextView comp2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_resultado_ejercicio2);

            //Apuntando las variables segun los ID
            texta = (TextView) findViewById(R.id.coefia);
            textb = (TextView) findViewById(R.id.coefib);
            textc = (TextView) findViewById(R.id.coefic);
            textx1a = (TextView) findViewById(R.id.x1);
            textx1b = (TextView) findViewById(R.id.x1a);
            textx2a = (TextView) findViewById(R.id.x2);
            textx2b = (TextView) findViewById(R.id.x1b);
            comp1 = (TextView) findViewById(R.id.signo1);
            comp2 = (TextView) findViewById(R.id.signo2);

            //Trayendo las variables desde la otra activity para mostrarlas
            Bundle bundle = getIntent().getExtras();
            String coefa = bundle.getString("txta");
            String coefb = bundle.getString("txtb");
            String coefc = bundle.getString("txtc");

            String resib = bundle.getString("txtib");
            String resx1 = bundle.getString("txtx1");
            String resx2 = bundle.getString("txtx2");
            String sign1 = bundle.getString("signo1");
            String sign2 = bundle.getString("signo2");

            //enlazando los resultados a los elementos dentro del activity
            texta.setText(coefa);
            textb.setText(coefb);
            textc.setText(coefc);
            textx1a.setText(resx1);
            textx1b.setText(resib);
            textx2a.setText(resx2);
            textx2b.setText(resib);
            comp1.setText(sign1);
            comp2.setText(sign2);
        }

    public void Regresar (View v){
        //Finalizando actividad
        finish();
    }
}