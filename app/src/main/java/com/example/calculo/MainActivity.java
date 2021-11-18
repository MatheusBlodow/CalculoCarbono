package com.example.calculo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btCalcular = (Button) findViewById(R.id.calcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    protected void calcular(){
        TextView editMos = (TextView) findViewById(R.id.mosText);
        TextView editAdicaoKgHaAnoText = (TextView) findViewById(R.id.adicaoKgHaAnotext);
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
            double mos = Double.parseDouble(editMos.getText().toString());
            double adicaoKgHaAnoText = Double.parseDouble(editAdicaoKgHaAnoText.getText().toString());

            double conta1 = 2400 * (mos / 100);
            double conta2 = conta1 / 1.724;
            double conta3 = conta2 / (adicaoKgHaAnoText / 1000);

            thaMos.setText(" t/há de MOS = " + conta1);
            tCHa.setText(" t/C/há = " + conta2);
            tempoEstimadoAumentoCmos.setText("  Tempo estimado de aumento de C/MOS = " + " " + conta3);
        }
    }

}