package com.example.taller_practico_1_tl160424;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Ejercicio2 extends AppCompatActivity {

    //Creacion de las variables direccionadas a los elementos del activity que se mostraran
    private EditText a;
    private EditText b;
    private EditText c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        //Apuntando las variables segun los ID
        a = (EditText) findViewById(R.id.coea);
        b = (EditText) findViewById(R.id.coeb);
        c = (EditText) findViewById(R.id.coec);
    }


    public void operacion(View v){
        //Capturando los datos del activity
        String coeficientea = a.getText().toString();
        String coeficienteb = b.getText().toString();
        String coeficientec = c.getText().toString();

        //Convirtiendolo a tipo int
        int coefa = Integer.parseInt(coeficientea);
        int coefb = Integer.parseInt(coeficienteb);
        int coefc = Integer.parseInt(coeficientec);

        //Realizando las operaciones que van dentro del radical
        if (coefa == 0){
            //Mensaje para que el coeficiente a sea distinto de cero
            Toast toast1 = Toast.makeText(getApplicationContext(),"El coeficiente 'A' debe ser distinto a cero", Toast.LENGTH_SHORT);
            toast1.show();
        }
        else{
            DecimalFormat df = new DecimalFormat("#.000s");
            double radical = (Math.pow(coefb, 2)) - 4*coefa*coefc;
            if (radical < 0) {
                //Operaciones para respuesta imaginaria
                double radicala = (radical * (-1));
                double ima = Math.sqrt(radicala);
                String partea = df.format(-coefb/(2*coefa));
                double parteb1 = (ima/(2*coefa));
                String signo;
                if (parteb1 < 0){
                    signo = "-";
                    String b1 = df.format(parteb1);
                    //Mandando datos al segundo activity
                    Intent i = new Intent(this, Resultado_Ejercicio2.class);
                    i.putExtra("txta", coeficientea);
                    i.putExtra("txtb", coeficienteb);
                    i.putExtra("txtc", coeficientec);
                    i.putExtra("txtx1", partea);
                    i.putExtra("txtib", b1);
                    i.putExtra("signo1", signo);
                    startActivity(i);
                }
                else {
                    signo = "+";
                    String b1 = df.format(parteb1);
                    //Mandando datos al segundo activity
                    Intent i = new Intent(this, Resultado_Ejercicio2.class);
                    i.putExtra("txta", coeficientea);
                    i.putExtra("txtb", coeficienteb);
                    i.putExtra("txtc", coeficientec);
                    i.putExtra("txtx1", partea);
                    i.putExtra("txtib", b1);
                    i.putExtra("signo1", signo);
                    startActivity(i);
                }

            }
            else{
                //Operaciones para respuesta real

                String x1 = df.format((-coefb + Math.sqrt(radical))/(2*coefa));
                String x2 = df.format((-coefb - Math.sqrt(radical))/(2*coefa));

                //Convirtiendolo a string
                String resx1 = String.valueOf(x1);
                String resx2 = String.valueOf(x2);

                //Mandando datos al segundo activity
                Intent i = new Intent(this, Resultado_Ejercicio2.class);
                i.putExtra("txta", coeficientea);
                i.putExtra("txtb", coeficienteb);
                i.putExtra("txtc", coeficientec);
                i.putExtra("txtx1", resx1);
                i.putExtra("txtx2", resx2);
                startActivity(i);
            }
        }
    }

    public void Regresar (View v){
        //Finalizando actividad
        finish();
    }

}