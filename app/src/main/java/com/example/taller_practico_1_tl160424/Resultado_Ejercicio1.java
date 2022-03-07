package com.example.taller_practico_1_tl160424;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado_Ejercicio1 extends AppCompatActivity {


    private TextView TV1;
    private ImageView Perfil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_ejercicio1);
        comisiones();
    }

    private void comisiones() {
        TV1 = (TextView) findViewById(R.id.TV1);
        Perfil2 = (ImageView) findViewById(R.id.Perfil2);

        //Obtenemos los datos de la main activity
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("TxtNombre");
        String codigo = bundle.getString("TxtCodigo");
        String ventas = bundle.getString("TxtVentas");

        //Calculo de comisiones
        String comision = "";
        double comisioncalc = 0;
        double ventavalor = Double.parseDouble(ventas);

        if (ventavalor  < 500){
            comision = "0%";
            comisioncalc = (ventavalor);
        }else if(ventavalor >= 500 && ventavalor < 1000){
            comision = "5%";
            comisioncalc = (ventavalor * 0.05);
        }else if(ventavalor >= 1000 && ventavalor < 2000){
            comision = "10%";
            comisioncalc = (ventavalor * 0.1);
        }else if(ventavalor >= 2000 && ventavalor < 3000){
            comision = "15%";
            comisioncalc = (ventavalor * 0.15);
        }else if(ventavalor >= 3000 && ventavalor < 4000){
            comision = "20%";
            comisioncalc = (ventavalor * 0.20);
        }else if(ventavalor > 4000){
            comision = "30%";
            comisioncalc = (ventavalor * 0.30);
        }
        String resultado = "Empleado\n"+nombre+" \n\n" +
                "Código de empleado\n" + codigo + "\n\n"+
                "Resultados Obtenidos \nVentas registradas: $" + ventas + "\n"+
                "Porcentaje logrado: " + comision + "\n"+
                "Comision obtenida: $" + comisioncalc + "\n"+
                "¡Felicidades por su arduo trabajo!\n";


        //Obtenemos la llave de la image y seteamos nuestro imageview de la segunda actividad
        Uri imageUri = getIntent().getData();
        Perfil2.setImageURI(imageUri);
        TV1.setText(resultado);
    }

}