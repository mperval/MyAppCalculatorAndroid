package com.example.myappcalculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView operacionARealizar = findViewById(R.id.operacionARealizar);
        TextView textResultado = findViewById(R.id.textResultado);

        Intent intent = getIntent();
        if (intent != null) {
            double numero1 = intent.getDoubleExtra("numero1", 0);
            double numero2 = intent.getDoubleExtra("numero2", 0);
            double resultado = intent.getDoubleExtra("resultado", 0);

            // Mostrar la operación en el TextView de MainActivity2
            String operacion = numero1 + " + " + numero2 + " = ";
            operacionARealizar.setText(operacion);

            //resultado.
            textResultado.setText(String.valueOf(resultado));
        }else{
            System.out.println("error inesperado.");
        }
    }
}