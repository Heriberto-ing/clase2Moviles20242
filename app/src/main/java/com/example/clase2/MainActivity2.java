package com.example.clase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView nombre, ape, edad, ciudad, barrio, estadoCV;
    Button nueva, enlace;
    String EstadoTexto;
    String EstadoAnterior = "None";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre=(TextView) findViewById(R.id.IngreseNombre);
        ape=(TextView) findViewById(R.id.IngreseApe);
        edad=(TextView) findViewById(R.id.IngreseEdad);
        ciudad=(TextView) findViewById(R.id.IngreseCiudad);
        barrio=(TextView) findViewById(R.id.IngreseBarrio);
        nueva=(Button) findViewById(R.id.btnNueva);
        enlace=(Button) findViewById(R.id.btnEnlace);

        nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Datos();

        enlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        actualizarEstado("onStart");
        Log.d("Ciclo de vida","Estoy en OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizarEstado("onResume");
        Log.d("Ciclo de vida", "Estoy en el onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        actualizarEstado("onPause");
        Log.d("Ciclo de vida", "Estoy en el onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        actualizarEstado("onStop");
        Log.d("Ciclo de vida", "Estoy en el onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        actualizarEstado("onRestart");
        Log.d("Ciclo de vida", "Estoy en el onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        actualizarEstado("onDestroy");
        Log.d("Ciclo de vida", "Estoy en el onDestroy");
    }

    private void actualizarEstado(String EstadoActual) {
        EstadoTexto = "Estado anterior: " + EstadoAnterior + "\nEstado actual: " + EstadoActual;
        estadoCV.setText(EstadoTexto);
        EstadoAnterior = EstadoActual;
    }

    private void  Datos(){
        Bundle datos= this.getIntent().getExtras();
        String nombre1 = datos.getString("Nombre");
        String apellido = datos.getString("Apellido");
        String edad1 = datos.getString("Edad");
        String ciudad1 = datos.getString("Ciudad");
        String barrio1 = datos.getString("Barrio");

        nombre.setText(nombre1);
        ape.setText(apellido);
        edad.setText(edad1);
        ciudad.setText(ciudad1);
        barrio.setText(barrio1);
    }
}



