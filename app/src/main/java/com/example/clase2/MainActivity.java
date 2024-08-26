package com.example.clase2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ingresarNombre, ingresarApe, ingresarEdad, ingresasCiudad, ingresarBarrio;
    TextView formulario;
    Button guardar, borrar;
    String nombreUsuario, apeUsuario, edadUsuario, ciudadUsuario, barrioUsuario;
    String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Estoy en el onCreate");

        ingresarNombre = (EditText) findViewById(R.id.editarNombre);
        ingresarApe = (EditText) findViewById(R.id.editarApe);
        ingresarEdad = (EditText) findViewById(R.id.editarEdad);
        ingresasCiudad = (EditText) findViewById(R.id.editarCiudad);
        ingresarBarrio = (EditText) findViewById(R.id.editarBarrio);
        formulario = (TextView) findViewById(R.id.txvFormulario);
        guardar = (Button) findViewById(R.id.btnGuardar);
        borrar = (Button) findViewById(R.id.btnBorrar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Estoy en el onStart");

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                formulario.setText("Se guardaron los datos correctamente");
                nombreUsuario = String.valueOf(ingresarNombre.getText());
                apeUsuario = String.valueOf(ingresarApe.getText());
                edadUsuario = String.valueOf(ingresarEdad.getText());
                ciudadUsuario = String.valueOf(ingresasCiudad.getText());
                barrioUsuario = String.valueOf(ingresarBarrio.getText());

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
        Log.d(TAG, "Estoy en el onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Estoy en el onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Estoy en el onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Estoy en el onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Estoy en el onDestroy");
    }
}