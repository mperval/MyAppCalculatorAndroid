package com.example.myappcalculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView operacionARealizar = findViewById(R.id.operacionARealizar);
        TextView textResultado = findViewById(R.id.textResultado);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        if (intent != null) {
            double numero1 = intent.getDoubleExtra("numero1", 0);
            double numero2 = intent.getDoubleExtra("numero2", 0);
            double resultado = intent.getDoubleExtra("resultado", 0);

            // Verificar si la operación es una suma o una resta
            boolean esResta = intent.getBooleanExtra("esResta", false);
            boolean esSuma = intent.getBooleanExtra("esSuma", false);
            boolean esMultiplicar = intent.getBooleanExtra("esMultiplicar", false);
            boolean esDividir = intent.getBooleanExtra("esDividir", false);

            String operacion;

            if (esResta) {
                operacion = numero1 + " - " + numero2 + " = ";
            } else if (esSuma) {
                operacion = numero1 + " + " + numero2 + " = ";
            } else if(esMultiplicar){
                operacion = numero1 + " * " + numero2 + " = ";
            }else if(esDividir){
                operacion = numero1 + " / " + numero2 + " = ";
            }else {
                operacion = "Operación desconocida";
            }

            operacionARealizar.setText(operacion);
            textResultado.setText(String.valueOf(resultado));
        } else {
            System.out.println("error inesperado.");
        }
        //accion del boton back.
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentView2 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intentView2);
            }
        });
    }
}
