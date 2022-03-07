package com.example.taller_practico_1_tl160424;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Ejercicio1 extends AppCompatActivity {


    //Declaramos Variables
    private EditText etNombre;
    private EditText etCodigo;
    private EditText etVentas;
    private ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        ivImagen = (ImageView) findViewById(R.id.Perfil);
    }

    public void Upload(View view) {
        etNombre = (EditText) findViewById(R.id.Nombre);
        etCodigo = (EditText) findViewById(R.id.Codigo);
        etVentas = (EditText) findViewById(R.id.Ventas);
        String nombre = etNombre.toString();
        String Result = "";
        if (TextUtils.isEmpty(etNombre.getText())) {
            etNombre.setError("¡CAMPO OBLIGATORIO!");
        } else if (TextUtils.isEmpty(etCodigo.getText())) {
            etCodigo.setError("¡CAMPO OBLIGATORIO!");
        } else if (TextUtils.isEmpty(etVentas.getText())) {
            etVentas.setError("¡CAMPO OBLIGATORIO!");
        }else {
            CargarImagen();
        }
    }

    private void CargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleeccione la aplicación"), 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri path = data.getData();
            ivImagen.setImageURI(path);
            Intent i = new Intent(this, Resultado_Ejercicio1.class);
            i.putExtra("TxtNombre", etNombre.getText().toString());
            i.putExtra("TxtCodigo", etCodigo.getText().toString());
            i.putExtra("TxtVentas", etVentas.getText().toString());
            i.setData(path);
            startActivity(i);
        }
    }

}