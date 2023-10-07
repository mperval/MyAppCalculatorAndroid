package com.example.myappcalculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaracion de los 2 EditText numeros introducidos por usuario.
        EditText number1 = findViewById(R.id.number1);
        EditText number2 = findViewById(R.id.number2);

        //declaraciones de los botones de operaciones matematicas.
        Button btnSuma = findViewById(R.id.btnSuma);
        Button btnResta = findViewById(R.id.btnResta);
        Button btnMultiplicar = findViewById(R.id.btnMultiplicar);
        Button btnDividir = findViewById(R.id.btnDividir);

        //declaracion boton Clean.
        Button btnClean = findViewById(R.id.btnClean);

        /**
         * Accion del boton Sumar.
         */
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obtener el numero de los textView
                // Obtener los números de los EditText
                String num1String = number1.getText().toString();
                String num2String = number2.getText().toString();

                //si esta vacio y si es numero double.
                if(!num1String.isEmpty() && !num2String.isEmpty() && isValidDouble(num1String) && isValidDouble(num2String)){
                    //parseamos los numeros.
                    double numero1 = Double.parseDouble(number1.getText().toString());
                    double numero2 = Double.parseDouble(number2.getText().toString());

                    //realizar suma.
                    double resultado = numero1 + numero2;

                    // Crear un Intent para abrir MainActivity2 y pasar el resultado.
                    Intent intentViewIntent = new Intent(MainActivity.this, MainActivity2.class);

                    //enviar resultado.
                    intentViewIntent.putExtra("resultado", resultado);
                    //enviar numeros introducidos por el usuario.
                    intentViewIntent.putExtra("numero1", numero1);
                    intentViewIntent.putExtra("numero2", numero2);

                    //activar segunda actividad.
                    startActivity(intentViewIntent);

                }else {
                    Toast.makeText(MainActivity.this, "Ingresa dos números válidos.", Toast.LENGTH_SHORT).show();
                    //borro los datos incorrectos.
                    number1.setText("");
                    number2.setText("");
                }
            }
        });
    }
    // Funcion para comprobrar si una cadena es un numero double valido.
    private boolean isValidDouble(String string) {
        try {
            double value = Double.parseDouble(string);
            return !Double.isNaN(value) && !Double.isInfinite(value);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}