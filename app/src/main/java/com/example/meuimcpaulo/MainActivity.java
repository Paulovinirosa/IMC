package com.example.meuimcpaulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText edtPeso;
    EditText edtAltura;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoCalcular();
    }

    protected void carregaComponentes() {
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoCalcular() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String resultado = realizaCalculo();
                exibiResultado(resultado);
                limpaCampos();
            }
        });
    }

    protected String realizaCalculo() {
        float Peso = Float.parseFloat(edtPeso.getText().toString());
        float Altura = Float.parseFloat(edtAltura.getText().toString());

        String resultado;
        double IMC;

        IMC = Peso / (Altura * Altura);

        if (IMC < 16) {
            resultado = "Magreza Grave";

        }else if((IMC >=16) && (IMC < 17)) {
            resultado = "Magreza Moderada";

        }else if((IMC >=17) && (IMC < 18.5)) {
            resultado = "Magreza Leve";

        }else if((IMC >=18.5) && (IMC < 25)) {
            resultado = "Saudável";

        }else if((IMC >=25) && (IMC < 30)){
            resultado = "Sobrepeso";

        }else if((IMC >=30) && (IMC < 35)){
            resultado = "Obesidade Grau I";

        }else if((IMC >=35) && (IMC < 40)){
            resultado = "Obesidade Grau II";

        }else{
            resultado = "Obesidade Grau III (Mórbida)";

        }
        return resultado;
    }

    protected void exibiResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    protected void limpaCampos() {
        edtAltura.setText("");
        edtPeso.setText("");
        edtPeso.requestFocus();
    }
}