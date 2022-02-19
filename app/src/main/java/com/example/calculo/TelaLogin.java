package com.example.calculo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        Button btCalcular = (Button) findViewById(R.id.btnAcessar);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {acessar();}
        });
    }

    void acessar(){
        TextView email = (TextView) findViewById(R.id.email);
        TextView senha = (TextView) findViewById(R.id.senha);

        String dados[][] = {{"matheus@gmail.com", "12345"},{"paulo@gmail.com","678912"}};

        if(email.getText().toString().equals(dados[0][0]) && senha.getText().toString().equals(dados[0][1])){
            Intent i = new Intent(TelaLogin.this, TelaCalculo.class);
            startActivity(i);
        }else if(email.getText().toString().equals(dados[1][0]) && senha.getText().toString().equals(dados[1][1])){
            Intent i = new Intent(TelaLogin.this, TelaCalculo.class);
            startActivity(i);
        }else{
            checarErroLogin();
        }

    }

    void checarErroLogin(){
        AlertDialog.Builder alerta = new AlertDialog.Builder(TelaLogin.this);
        alerta.setTitle("Aviso");
        alerta.setMessage("Email ou senha errados");
        alerta.setCancelable(false);
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TelaLogin.this, "Corrija email e senha", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alerta.create();
        alertDialog.show();
    }
}