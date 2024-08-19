package com.example.clase2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ingresarNombre, ingresarApe, ingresarEdad, ingresasCiudad, ingresarBarrio;
    TextView formulario;
    Button guardar, borrar;
    String nombreUsuario, apeUsuario, edadUsuario, ciudadUsuario, barrioUsuario;

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
}