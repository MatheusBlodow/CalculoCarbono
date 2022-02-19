package com.example.calculo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaCalculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calculo);
        Button btCalcular = (Button) findViewById(R.id.btnCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    protected void calcular(){
        Calculo calculo = new Calculo();

        TextView editMos = (TextView) findViewById(R.id.mosText);
        TextView editAdicaoKgHaAnoText = (TextView) findViewById(R.id.adicaoKgHaAnoText);
        TextView thaMos = (TextView) findViewById(R.id.thaMos);
        TextView tCHa = (TextView) findViewById(R.id.tCHa);
        TextView tempoEstimadoAumentoCmos = (TextView) findViewById(R.id.tempoEstimadoAumentoCmos);

        if(editMos.getText().length() == 0){
            if (editAdicaoKgHaAnoText.getText().length() == 0){
                editAdicaoKgHaAnoText.setError("Campo vazio");
                editMos.setError("Campo vazio");
            }
            editMos.setError("Campo vazio");
        }else
            if (editAdicaoKgHaAnoText.getText().length() == 0){
            if(editMos.getText().length() == 0){
                editMos.setError("Campo vazio");
                editAdicaoKgHaAnoText.setError("Campo vazio");
            }
            editAdicaoKgHaAnoText.setError("Campo vazio");
        }else {
            calculo.setMos(Double.parseDouble(editMos.getText().toString()));
            calculo.setAdicaoKgHaAnoText(Double.parseDouble(editAdicaoKgHaAnoText.getText().toString()));

            calculo.Calcular();

            thaMos.setText(" t/há de MOS = " + calculo.getConta1());
            tCHa.setText(" t/C/há = " + calculo.getConta2());
            tempoEstimadoAumentoCmos.setText("  Tempo estimado de aumento de C/MOS = " + " " + calculo.getConta3());
        }
    }

}