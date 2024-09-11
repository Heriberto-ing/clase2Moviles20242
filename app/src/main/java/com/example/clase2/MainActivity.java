package com.example.clase2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText ingresarNombre, ingresarApe, ingresarEdad, ingresasCiudad, ingresarBarrio;
    TextView formulario, estadoCV;
    Button guardar, borrar, nueva;
    String nombreUsuario, apeUsuario, edadUsuario, ciudadUsuario, barrioUsuario, EstadoTexto;
    String EstadoAnterior = "None";
    Persona datosUsuario;
    //String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingresarNombre = (EditText) findViewById(R.id.editarNombre);
        ingresarApe = (EditText) findViewById(R.id.editarApe);
        ingresarEdad = (EditText) findViewById(R.id.editarEdad);
        ingresasCiudad = (EditText) findViewById(R.id.editarCiudad);
        ingresarBarrio = (EditText) findViewById(R.id.editarBarrio);
        formulario = (TextView) findViewById(R.id.txvFormulario);
        guardar = (Button) findViewById(R.id.btnGuardar);
        borrar = (Button) findViewById(R.id.btnBorrar);
        nueva = (Button) findViewById(R.id.btnNueva);
        estadoCV = (TextView) findViewById(R.id.estadoCV);
        datosUsuario = new Persona(1020304050,(byte)50,"Pedro","Perez");

        actualizarEstado("onCreate");
        Log.d("Ciclo de vida", "Estoy en el onCreate");

        nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Ciclo de vida","ESTOY EN EL BOTÓN");

                String nombre = ingresarNombre.getText().toString();
                String apellido = ingresarApe.getText().toString();
                String edad = ingresarEdad.getText().toString();
                String ciudad = ingresasCiudad.getText().toString();
                String barrio = ingresarBarrio.getText().toString();

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("Nombre", nombre);
                i.putExtra("Apellido", apellido);
                i.putExtra("Edad", edad);
                i.putExtra("Ciudad", ciudad);
                i.putExtra("Barrio", barrio);

                startActivity(i);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        actualizarEstado("onStart");
        Log.d("Ciclo de vida", "Estoy en el onStart");

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                formulario.setText("Se guardaron los datos correctamente");
                nombreUsuario = String.valueOf(ingresarNombre.getText());
                apeUsuario = String.valueOf(ingresarApe.getText());
                edadUsuario = String.valueOf(ingresarEdad.getText());
                ciudadUsuario = String.valueOf(ingresasCiudad.getText());
                barrioUsuario = String.valueOf(ingresarBarrio.getText());
                guardarDatos(nombreUsuario);
                guardarDatos(apeUsuario);
                guardarDatos(edadUsuario);
                guardarDatos(ciudadUsuario);
                guardarDatos(barrioUsuario);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarNombre.setText("");
                ingresarApe.setText("");
                ingresarEdad.setText("");
                ingresasCiudad.setText("");
                ingresarBarrio.setText("");

            }
        });
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

    private void guardarDatos(String datos) {
        SharedPreferences sharedPreferences = getSharedPreferences("clase 2", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("datos Guardados", datos);
        editor.apply();

        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
    }
}
